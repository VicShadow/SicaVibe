export const formatDate = (date: Date): string => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()

  return `${day}/${month}/${year}`
}

export const formatDateTime = (dateTime: Date): string => {
  const date = formatDate(dateTime)
  const hours = dateTime.getHours()
  const minutes = dateTime.getMinutes()

  return `${date} ${hours}:${minutes}`
}

export const formatDateBackend = (date: Date): string => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()

  return `${day}/${month}/${year}`
}

export const formatDateBackendFromStr = (date: string): string => {
  const [day, month, year] = date.split('-')

  return `${year}/${month}/${day}`
}
