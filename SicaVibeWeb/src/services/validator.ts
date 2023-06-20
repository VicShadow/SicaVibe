export const validateEmail = (email: string): boolean => {
  if (email.length === 0) return false

  const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
  return re.test(email)
}

export const validatePassword = (password: string): boolean => {
  if (password.length < 9) return false

  const re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]).{8,}$/
  return re.test(password)
}

export const validateDate = (date: string): boolean => {
  const re = /\d{4}-\d{2}-\d{2}/
  return re.test(date)
}

export const validateNif = (nif: string): boolean => {
  const re = /^\d{9}$/
  return re.test(nif)
}

export const validatePhone = (phone: string): boolean => {
  const re = /^\d{9}$/
  return re.test(phone)
}

export const validateCC = (cc: string): boolean => {
  const re = /^\d{8}$/
  return re.test(cc)
}
