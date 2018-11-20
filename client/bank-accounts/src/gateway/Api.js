import RuntimeConfig from '../constants/RuntimeConfig';

import { NETWORK_ERROR_MESSAGE } from '../constants/Messages'

export function getAccount() {
    return new Promise((resolve, reject) => {
        const url = `${RuntimeConfig.apiHost}/account`;
        fetch(url).then((res) => {
            res.json().then((res) => (res.status_code == 2000 ? resolve(res) : reject(res.status_text) ))        
        }).catch(() => reject(NETWORK_ERROR_MESSAGE))
    })
}

export function getTransfers() {
    return new Promise((resolve, reject) => {
        const url = `${RuntimeConfig.apiHost}/account/transfers`;
        fetch(url).then((res) => {
            res.json().then((res) => (res.status_code == 2000 ? resolve(res) : reject(res.status_text) ))        
        }).catch(() => reject(NETWORK_ERROR_MESSAGE))
    })
}

export function getTransferById(id) {
    return new Promise((resolve, reject) => {
        const url = `${RuntimeConfig.apiHost}/account/transfers/${id}`;
        fetch(url).then((res) => {
            res.json().then((res) => (res.status_code == 2000 ? resolve(res) : reject(res.status_text) ))        
        }).catch(() => reject(NETWORK_ERROR_MESSAGE))
    })
}
