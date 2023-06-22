# Criar VM com as seguintes caracteristicas:
# Tipo: E2
# SO: Linux Ubuntu 22.04 LTS x86/64
# Disco: SSD 500GB
# Memoria: 16GB
# vCPU: 8
# Zona: us-central1-a

# NOTA: DEVEM ESTAR LOGADOS NA CONTA DO GOOGLE CLOUD
# CASO NÃO ESTEJAM, DEVEM EXECUTAR O COMANDO:
# $ gcloud auth login

# NOTA: TAMBÉM É NECESSÁRIO TER A CHAVE SSH ADICIONADA NO COMPUTE ENGINE

$vmName = "sicavibe-app"
$imageFamily = "ubuntu-2204-lts"
$imageProject = "ubuntu-os-cloud"
$bootDiskSize = "64GB"
$bootDiskType = "pd-ssd"
$customMemory = "16GB"
$customCpu = "8"
$zone = "us-central1-a"
$scopes = "https://www.googleapis.com/auth/cloud-platform"
$network = "address=34.28.141.169,network-tier=PREMIUM,stack-type=IPV4_ONLY,subnet=default"

# Criação da VM
Write-Host -NoNewline "Creating VM..."
gcloud compute instances create $vmName `
    --image-family $imageFamily `
    --image-project $imageProject `
    --boot-disk-size $bootDiskSize `
    --boot-disk-type $bootDiskType `
    --custom-memory $customMemory `
    --custom-cpu $customCpu `
    --zone $zone `
    --scopes $scopes `
    --network-interface $network
Write-Host "done."

# Get vm's ip
Write-Host -NoNewline "Getting VM's IP..."
$vmIP = gcloud compute instances describe $vmName --format="get(networkInterfaces[0].accessConfigs[0].natIP)"
Write-Host "$vmIP"

# Wait for the instance to be in the "RUNNING" state
Write-Host "Waiting for the instance to start..."


while ($true) {
    #gcloud compute ssh $vmName --command="echo instance now up" --strict-host-key-checking=no 2>$null
    $sshOutput = ssh -o "StrictHostKeyChecking=no" $vmIP -C "echo VM is up" #2>$null

    if ($LASTEXITCODE -eq 0) {
        break
    }

    Write-Host "($LASTEXITCODE) Instance not up yet, waiting 5 seconds..."
    Start-Sleep -Seconds 5
}

$sshInstallBasics = @"
sudo apt-get update
echo 'Sleeping for 1s'
sleep 1
sudo apt-get update
echo 'Sleeping for 6s'
sleep 6
sudo apt-get install openjdk-17-jre maven mysql-server -y
"@

$sshSetupGitHubUp = @"
gcloud secrets versions access 1 --secret="id_github" > ~/.ssh/id_rsa
sudo chmod 600 .ssh/id_rsa
gcloud secrets versions access 1 --secret="id_github_pub" > ./.ssh/id_rsa.pub
ssh-keyscan -t rsa github.com >> ~/.ssh/known_hosts
git config --global core.sshCommand 'ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no'
git clone git@github.com:VicShadow/SicaVibe.git
"@

$sshSetupBD = @"
sudo mkdir /var/lib/mysql-files/SicaVibeImgs
sudo cp ~/SicaVibe/SicaVibeApp/scripts/imgs/* /var/lib/mysql-files/SicaVibeImgs/
sudo mysql < ~/SicaVibe/SicaVibeApp/scripts/DBSicaVibeCreate.ddl
sudo mysql < ~/SicaVibe/SicaVibeApp/scripts/DBUserCreate.sql
sudo mysql < ~/SicaVibe/SicaVibeApp/scripts/DBPopulate.sql
"@

$sshSetupMaven = @"
mvn clean package -f ~/SicaVibe/SicaVibeApp/pom.xml
mv ~/SicaVibe/SicaVibeApp/target/SicaVibeApp-0.0.1-SNAPSHOT.jar ./SicaVibeApp.jar
mv ~/SicaVibe/SicaVibeApp/scripts/startApp.sh .
sudo chmod +x startApp.sh
"@

$sshSetupNPM = @"
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -
sudo apt-get install nodejs -y
echo 'Sleeping for 6s'
sleep 6
sudo npm install --global yarn
yarn --cwd ~/SicaVibe/SicaVibeWeb/
echo 'VITE_BACKEND_IP=$vmIP
VITE_BACKEND_PORT=8080
VITE_BACKEND_URL=http://`$VITE_BACKEND_IP:`$VITE_BACKEND_PORT' > ~/SicaVibe/SicaVibeWeb/.env
"@

$sshStartSicaVibe = @"
yarn --cwd ~/SicaVibe/SicaVibeWeb/ dev --host & ./startApp.sh
"@



Write-Host "Setting up VM..."
ssh -o "StrictHostKeyChecking=no" $vmIP -C $sshInstallBasics
ssh -o "StrictHostKeyChecking=no" $vmIP -C $sshSetupGitHubUp
ssh -o "StrictHostKeyChecking=no" $vmIP -C $sshSetupBD
ssh -o "StrictHostKeyChecking=no" $vmIP -C $sshSetupMaven
ssh -o "StrictHostKeyChecking=no" $vmIP -C $sshSetupNPM
Write-Host "Done. Starting App..."
ssh -o "StrictHostKeyChecking=no" $vmIP -C $sshStartSicaVibe