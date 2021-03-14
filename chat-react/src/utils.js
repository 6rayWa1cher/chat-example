export const dateToString = str => {
    const date = new Date(str);
    console.log(date);
    return `${date.getDate()}-${date.getMonth() + 1}-${date.getFullYear()}`;
}