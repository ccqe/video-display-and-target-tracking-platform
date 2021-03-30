<template>
  <div class="error-page">

      <div class="error-code">403</div>
      <div class="error-desc">没有权限访问该页面</div>
      <div class="error-handle">
          <router-link to="/">
            <el-button type="primary" size="large">返回首页</el-button>
          </router-link>
          <el-button class="error-btn" type="primary" size="large" @click="goBack">返回上一页</el-button>
      </div>
  </div>
</template>

<style>
.error-btn{
  margin-left: 100px;
}
</style>