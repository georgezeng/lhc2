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

    getLhc3TmList(queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post('/lhc3/tm/list/', queryInfo).then(data => {
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


    getLhc3YzList(prefix, queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post(`/lhc3/${prefix}/yz/list`, queryInfo).then(data => {
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

    getLhc3ZfList(prefix, queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post(`/lhc3/${prefix}/zf/list`, queryInfo).then(data => {
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

    getLhc3SwList(prefix, queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post(`/lhc3/${prefix}/sw/list`, queryInfo).then(data => {
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
    },

    getPickNums(queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post(`/pickNum/list`, queryInfo).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getLhc3PickNums(queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post(`/lhc3/pickNum/list`, queryInfo).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getTimes(tables, type) {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/comparision/times/${tables}/${type}`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },


    getLhc3Times(tables, type, queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post(`/lhc3/comparision/times/${tables}/${type}`, queryInfo).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getColors(tables, type) {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/comparision/colors/${tables}/${type}`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getLhc3Colors(tables, type, queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post(`/lhc3/comparision/colors/${tables}/${type}`, queryInfo).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getColors2(tables, type) {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/comparision/colors2/${tables}/${type}`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getLhc3Colors2(tables, type, queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post(`/lhc3/comparision/colors2/${tables}/${type}`, queryInfo).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getDxds1yz() {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/dxds/yz1/list`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getDxds2yz() {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/dxds/yz2/list`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getDxds2zf() {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/dxds/zf2/list`).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getAnalyze1(queryInfo) {
        return new Promise((resolve, reject) => {
            util.ajax.post(`/analyze/list`, queryInfo).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    },

    getLhc3Stake(type) {
        return new Promise((resolve, reject) => {
            util.ajax.get(`/lhc3/stake/` + type).then(data => {
                resolve(data);
            }).catch(ex => {
                reject(ex);
            });
        });
    }
}