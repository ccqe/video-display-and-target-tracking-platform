<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-calendar"></i> 用户添加
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="ID">
                        <el-input v-model="form.id"></el-input>
                    </el-form-item>
                    <el-form-item label="用户名">
                        <el-input v-model="form.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input type="password" v-model="form.password"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">表单提交</el-button>
                        <el-button>取消</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
import { addUser } from '@/api/user';
export default {
    name: 'useradd',
    data() {
        return {
            form: {
                id:'',
                username: '',
                password:'',               
            }
        };
    },
    methods: {
        add(){
            addUser(this.form).then(res => {
                console.log(res);

            });
        },
        onSubmit() {
            this.add();
            this.$message.success('提交成功！');
            this.$router.push({ path: '/userlist'  })
        }
    }
};
</script>