export function getAccount() {
    const url = `http://localhost:8080/account`;
    return fetch(url).then((res) => res.json())
}
export function getTransfers() {
    const url = `http://localhost:8080/account/transfers`;
    return fetch(url).then((res) => res.json())
}
