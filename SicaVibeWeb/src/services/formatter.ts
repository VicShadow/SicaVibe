export const formatDate = (date: Date): string => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()

  return `${year}-${month}-${day}`
}

export const formatDateTime = (dateTime: Date): string => {
  const date = formatDate(dateTime)
  const hours = dateTime.getHours()
  const minutes = dateTime.getMinutes()

  return `${date} ${hours}:${minutes}`
}
