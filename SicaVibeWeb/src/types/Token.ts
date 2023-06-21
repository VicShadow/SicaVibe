export type Token = string

export interface DecodedToken {
  id: number
  role: string
  iat: number
  exp: number
}
