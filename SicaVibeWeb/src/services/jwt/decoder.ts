import jwt_decode, {type JwtPayload } from 'jwt-decode'
import type { DecodedToken, Token } from '@/types/Token'

export const decodeJWT = (token: Token): DecodedToken | null => {
  try {
    const decoded = jwt_decode<JwtPayload >(token)

    const sub = JSON.parse(<string>decoded?.sub)

    return {
      id: sub.id,
      role: sub.tipoUtilizador,
      iat: <number> decoded.iat,
      exp: <number> decoded.exp
    }

  } catch (e) {
    return null
  }
}
