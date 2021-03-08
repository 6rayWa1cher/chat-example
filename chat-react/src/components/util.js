export const dateToString = str => {
    const date = new Date(str);
    return `${date.getDay()}-${date.getMonth() + 1}-${date.getFullYear()}`;
}