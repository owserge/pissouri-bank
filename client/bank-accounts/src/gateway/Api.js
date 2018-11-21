import RuntimeConfig from '../constants/RuntimeConfig';

import { NETWORK_ERROR_MESSAGE } from '../constants/Messages';

/**
 * Get current account profile data.
 * @returns {Promise<any>}
 */
export function getAccount() {
    return new Promise((resolve, reject) => {
        const url = `${RuntimeConfig.apiHost}/account`;
        fetch(url).then((res) => {
            res.json().then((res) => (res.status_code == 2000 ? resolve(res) : reject(res.status_text) ))        
        }).catch(() => reject(NETWORK_ERROR_MESSAGE))
    })
}

/**
 * Get the list of the last transfers of the current user.
 * @returns {Promise<any>}
 */
export function getTransfers() {
    return new Promise((resolve, reject) => {
        const url = `${RuntimeConfig.apiHost}/account/transfers`;
        fetch(url).then((res) => {
            res.json().then((res) => (res.status_code == 2000 ? resolve(res) : reject(res.status_text) ))        
        }).catch(() => reject(NETWORK_ERROR_MESSAGE))
    })
}

/**
 * Get one transfer details by transfer id.
 * @param id
 * @returns {Promise<any>}
 */
export function getTransferById(id) {
    return new Promise((resolve, reject) => {
        const url = `${RuntimeConfig.apiHost}/account/transfers/${id}`;
        fetch(url).then((res) => {
            res.json().then((res) => (res.status_code == 2000 ? resolve(res) : reject(res.status_text) ))        
        }).catch(() => reject(NETWORK_ERROR_MESSAGE))
    })
}
