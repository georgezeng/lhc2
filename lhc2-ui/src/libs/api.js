import qs from 'qs';
import util from './util';

export default {
    login(data) {
        return util.ajax.post('/login', qs.stringify(data));
    },

    getSxList() {
        return new Promise((resolve, reject) => {
            util.ajax.get('/sxList/').then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getTmList(queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post('/tm/list/', queryInfo).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    saveTm(data) {
        return new Promise((resolve, reject) => {
            util.ajax.post('/tm/save/', data).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    deleteTm(id) {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/tm/${id}/delete/`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    calculate() {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/calculate/`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    loadCalculationStatus() {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/calculation/status`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getSxyzList() {
        return new Promise((resolve, reject) => {
            util.ajax.get('/sx/yz/list').then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getSxzfList() {
        return new Promise((resolve, reject) => {
            util.ajax.get('/sx/zf/list').then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getSxswList() {
        return new Promise((resolve, reject) => {
            util.ajax.get('/sx/sw/list').then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    }
}