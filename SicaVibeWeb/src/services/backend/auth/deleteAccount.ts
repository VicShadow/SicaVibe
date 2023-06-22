import type { Token } from "@/types/Token";
import { backend } from "../backend";

const DELETE_ACCOUNT_ENDPOINT = "/hospede/delete-account"

export const deleteAccount = async (token:Token):Promise<void> => { 
    const headers = {
        token
    }

    const response = await backend.post(DELETE_ACCOUNT_ENDPOINT, null,{headers})
    
    if (response.status !== 200) {
        throw new Error("Erro ao deletar conta")
    }
}