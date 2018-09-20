import env from '../config/env';
import axios from 'axios';
import { Message } from 'iview';
import router from '../router';
let util = {

};
util.title = function (title) {
    title = title ? title : 'LHC';
    window.document.title = title;
};

const ajaxUrl = env === 'development'
    ? 'http://localhost:9090'
    : env === 'production'
        ? 'http://139.199.19.176:8080'
        : 'https://domain';

util.ajax = axios.create({
    baseURL: ajaxUrl,
    // headers: { 'Access-Control-Allow-Origin': '*' },
    withCredentials: true
});

util.ajax.interceptors.response.use(function (response) {
    if (response.data) {
        if (!response.data.success) {
            alertError(response.data);
        }
    } else {
        response.data = {
            data: null
        };
    }
    return response.data.data;
}, function (ex) {
    handleError(ex);
});

function handleError(ex) {
    let code = Number(ex && ex.response && ex.response.status);
    if (code === 403) {
        router.push({
            name: 'login'
        });
    } else {
        alertError(ex.response && ex.response.data);
    }
}

function alertError(error) {
    var message = (error && ('[' + error.traceId + ']' + error.errorMsg)) || '服务请求失败,请稍后重试';
    Message.error(message);
}

export default util;