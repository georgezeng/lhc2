import qs from 'qs';
import util from './util';

export default {
    login(data) {
        return util.ajax.post('/login', qs.stringify(data));
    },

    getSxList() {
        return new Promise((resolve, reject) => {
            util.ajax.get('/sx/seq/').then(data => {
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

    clearTm() {
        return new Promise((resolve, reject) => {
            util.ajax.get('/tm/clear/').then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    clearTmWithPage(pageInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post('/tm/clear/', pageInfo).then(data => {
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

    getYzList(prefix) {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/${prefix}/yz/list`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getZfList(prefix) {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/${prefix}/zf/list`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getSwList(prefix) {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/${prefix}/sw/list`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getStats1() {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/statInfo/1`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getStats2() {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/statInfo/2`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    }
}