export const dateToString = str => {
    const date = new Date(str);
    return `${date.getDate()}-${date.getMonth() + 1}-${date.getFullYear()}`;
}