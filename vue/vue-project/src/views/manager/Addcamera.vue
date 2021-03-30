<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-calendar"></i> 摄像头添加
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="摄像头ID">
                        <el-input v-model="form.id"></el-input>
                    </el-form-item>
                    <el-form-item label="摄像头名称">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                    <el-form-item label="摄像头x轴坐标">
                        <el-input v-model="form.positionX"></el-input>
                    </el-form-item>
                    <el-form-item label="摄像头y轴坐标">
                        <el-input v-model="form.positionY"></el-input>
                    </el-form-item>
                    <el-form-item label="摄像头视频流地址">
                        <el-input v-model="form.rtmpSrc"></el-input>
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
import { addCamera } from '@/api/camera';
export default {
    name: 'cameraadd',
    data() {
        return {
            form: {
                id:'',
                name: '',
                positionX:'',
                positionY:'',
                rtmpSrc:''               
            }
        };
    },
    methods: {
        add(){
            addCamera(this.form).then(res => {
                console.log(res);

            });
        },
        onSubmit() {
            this.add();
            this.$message.success('提交成功！');
            this.$router.push({ path: '/cameralist'  })
        }
    }
};
</script>