export const emailValidator = (email: string): boolean => {
  const re = /\S+@\S+\.\S+/
  return re.test(email)
}

export const passwordValidator = (password: string): boolean => {
  return false
}

export const dateValidator = (date: string): boolean => {
  const re = /\d{4}-\d{2}-\d{2}/
  return re.test(date)
}
