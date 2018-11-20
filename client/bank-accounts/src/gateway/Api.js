import RuntimeConfig from '../constants/RuntimeConfig'

export function getAccount() {
    const url = `${RuntimeConfig.apiHost}/account`;
    return fetch(url)
        .then((res) => res.json())
        .catch((error) =>{
            alert(error);
        });
}

export function getTransfers() {
    const url = `${RuntimeConfig.apiHost}/account/transfers`;
    return fetch(url)
        .then((res) => res.json())
        .catch((error) =>{
            alert(error);
        });
}

export function getTransferById(id) {
    const url = `${RuntimeConfig.apiHost}/account/transfers/${id}`;
    return fetch(url)
        .then((res) => res.json())
        .catch((error) =>{
            alert(error);
        });
}
