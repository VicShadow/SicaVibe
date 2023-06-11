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

$vmName = "abd-tp-vm"
$imageFamily = "ubuntu-2204-lts"
$imageProject = "ubuntu-os-cloud"
$bootDiskSize = "100GB"
$bootDiskType = "pd-ssd"
$customMemory = "16GB"
$customCpu = "8"
$zone = "europe-west1-b"
$scopes = "https://www.googleapis.com/auth/cloud-platform"
$tags = "http-server"

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
    --tags $tags
Write-Host "done."

# Get vm's ip
Write-Host -NoNewline "Getting VM's IP..."
$vmIP = gcloud compute instances describe $vmName --format="get(networkInterfaces[0].accessConfigs[0].natIP)"
Write-Host "$vmIP"

# Wait for the instance to be in the "RUNNING" state
Write-Host "Waiting for the instance to start..."


while ($true) {
    #gcloud compute ssh $vmName --command="echo instance now up" --strict-host-key-checking=no 2>$null
    ssh -o "StrictHostKeyChecking=no" $vmIP -C "echo VM is up" #2>$null

    if ($LASTEXITCODE -eq 0) {
        break
    }

    Write-Host "($LASTEXITCODE) Instance not up yet, waiting 5 seconds..."
    Start-Sleep -Seconds 5
}


Write-Host "Setting up VM..."
$sshCommand = @"
sudo apt update
sudo apt install openjdk-17-jre maven mysql-server -y
gcloud secrets versions access 1 --secret="id_github" > ~/.ssh/id_rsa
sudo chmod 600 .ssh/id_rsa
gcloud secrets versions access 1 --secret="id_github_pub" > ./.ssh/id_rsa.pub
ssh-keyscan github.com >> ~/.ssh/known_hosts
git clone git@github.com:VicShadow/SicaVibe.git
sudo mysql < ~/SicaVibe/SicaVibeApp/scripts/DBSicaVibeCreate.ddl
sudo mysql < ~/SicaVibe/SicaVibeApp/scripts/DBUserCreate.sql
mvn clean package -f ~/SicaVibe/SicaVibeApp/pom.xml
mv ~/SicaVibe/SicaVibeApp/target/SicaVibeApp-0.0.1-SNAPSHOT.jar ./SicaVibeApp.jar
mv ~/SicaVibe/SicaVibeApp/scripts/startApp.sh .
sudo chmod +x startApp.sh
"@

ssh -o "StrictHostKeyChecking=no" $vmIP -C $sshCommand
Write-Host "Done."

# Start interative ssh terminal
ssh -o "StrictHostKeyChecking=no" $vmIP