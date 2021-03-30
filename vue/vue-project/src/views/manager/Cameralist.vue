<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 摄像头管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-input v-model="query.name" placeholder="摄像头名称" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
            </div>
            <el-table
                :data="tableData"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
            >
                <el-table-column prop="id" label="摄像头ID" width="55" align="center"></el-table-column>
                <el-table-column prop="name" label="摄像头名称"></el-table-column>
                <el-table-column prop="positionX" label="摄像头x轴坐标"></el-table-column>
                <el-table-column prop="positionY" label="摄像头y轴坐标"></el-table-column>
                <el-table-column prop="rtmpSrc" label="摄像头视频流地址"></el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button>
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.$index, scope.row)"
                        >删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    layout="total, prev, pager, next"
                    :current-page="query.pageIndex"
                    :page-size="query.pageSize"
                    :total="pageTotal"
                    @current-change="handlePageChange"
                ></el-pagination>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="70px">
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
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import { getCameralist,deleteCamera,updateCamera } from '@/api/camera';
export default {
    name: 'basetable',
    data() {
        return {
            query: {
                name: '',
                pageIndex: 1,
                pageSize: 10
            },
            tableData: [],
            delList: [],
            editVisible: false,
            pageTotal: 0,
            form: {},
            idx: -1,
            id: -1,
            deleteState:false
        };
    },
    created() {
        this.getData();
    },
    methods: {

        getData() {
            getCameralist(this.query).then(res => {
                console.log(res);
                this.tableData = res.data['list'];
                this.pageTotal = res.data['pageTotal'] || 50;
            });
        },
        deleteCamera(row){
            deleteCamera(this.form).then(res=>{               
                console.log(res.data['state']);

            })

        },
        updateCamera(){
            updateCamera(this.form).then(res=>{
                console.log(res.data['state']);
            })
        },
        // 触发搜索按钮
        handleSearch() {
            this.$set(this.query, 'pageIndex', 1);
            this.getData();
        },
        // 删除操作
        handleDelete(index, row) {
            // 二次确认删除
            this.$confirm('确定要删除吗？', '提示', {
                type: 'warning'
            })
                .then(() => {
                    this.form = row;
                    this.deleteCamera();
                    this.$message.success('删除成功');
                    this.tableData.splice(index, 1);
                })
                .catch(() => {});
        },
        
        // 编辑操作
        handleEdit(index, row) {
            this.idx = index;
            this.form = row;
            this.editVisible = true;
        },
        // 保存编辑
        saveEdit() {
            this.editVisible = false;
            console.log(this.form);
            this.updateCamera();
            this.$message.success(`修改第 ${this.idx + 1} 行成功`);
            this.$set(this.tableData, this.idx, this.form);
        },
        // 分页导航
        handlePageChange(val) {
            this.$set(this.query, 'pageIndex', val);
            this.getData();
        }
    }
};
</script>

<style scoped>
/* .el-button{
    background: #909399;
    border-color:#909399;
} */

.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}
.table {
    width: 100%;
    font-size: 14px;
}
.red {
    color: #ff0000;
}
.mr10 {
    margin-right: 10px;
}
.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>