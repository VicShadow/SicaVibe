<template>
<div>
    <span class='title'>Employees</span>

    <div class="flex">
        <v-btn @click.prevent="addFuncionario"
        rounded="lg" color="#023E7D">ADD EMPLOYEE</v-btn>
    </div>

    <EmployeesTable class="marginTop" :users="funcionarios" />

    <AddEmployeeModal :is-modal-open="isModalOpen" @close="isModalOpen = false"/>

</div>
</template>

<script setup lang='ts'>
import { ref } from 'vue'
import { getToken } from '@/services/storage/sessionStorage'
import type { Token } from '@/types/Token'
import { getEmployees, type Employee} from '@/services/backend/admin/getEmployees'
import EmployeesTable from '@/components/tables/EmployeesTable.vue'
import AddEmployeeModal from '@/components/modals/AddEmployeeModal.vue'


const currentPage = ref<number>(1)
const pagesize = ref<number>(10)
const token: Token | null = getToken() // TODO: Migrate to use the useUserStore() hook

const isModalOpen = ref(false);

if (!token) {
    throw new Error('No token found')
}

const headers = {
    token: token,
    page: currentPage.value,
    pagesize: pagesize.value,
    usertype: 'FUNCIONARIO'
}


let funcionarios = ref<Employee[]>([])
getEmployees(headers).then(res => funcionarios.value = res)

function addFuncionario () {
    isModalOpen.value = true;
}
</script>

<style scoped>
.title {
    color: #023E7D;
    font-style: normal;
    font-weight: 500;
    font-size: 30px;
}

.marginTop {
    margin-top: 30px;
}

.flex {
    display: flex;
    justify-content: end;
    color: white;
}
</style>
  