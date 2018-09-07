<style lang="less">
    @import '../styles/login.less';
</style>

<template>
    <div class="login" @keydown.enter="handleSubmit">
        <div class="login-con">
            <Card :bordered="false">
                <p slot="title">
                    <Icon type="log-in"></Icon>
                    欢迎登录
                </p>
                <div class="form-con">
                    <Form ref="loginForm" :model="form" :rules="rules">
                        <FormItem prop="username">
                            <i-input size="large" v-model="form.username" placeholder="请输入用户名">
                <span slot="prepend">
                    <Icon type="md-person"/>
                </span>
                            </i-input>
                        </FormItem>
                        <FormItem prop="password">
                            <i-input size="large" type="password" v-model="form.password" placeholder="请输入密码">
                <span slot="prepend">
                    <Icon type="md-lock"/>
                </span>
                            </i-input>
                        </FormItem>
                        <FormItem>
                            <Button @click="handleSubmit" size="large" :ghost=true :long=true>登录</Button>
                        </FormItem>
                    </Form>
                </div>
            </Card>
        </div>
    </div>
</template>

<script>
    import API from '../libs/api';
    import router from '../router';

    export default {
        data() {
            return {
                form: {
                    username: '',
                    password: ''
                },
                rules: {
                    username: [
                        {required: true, message: '账号不能为空', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '密码不能为空', trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            handleSubmit() {
                const that = this;
                this.$refs.loginForm.validate((valid) => {
                    if (valid) {
                        API.login(that.form).then(() => {
                            router.push({
                                name: 'tm'
                            })
                        });
                    }
                });
            }
        }
    };
</script>
