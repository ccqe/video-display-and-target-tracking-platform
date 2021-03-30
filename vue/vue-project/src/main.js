import Vue from 'vue'

import App from './App.vue'
import router from './router'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN'

import VCharts from 'v-charts'

import echarts from 'echarts'

import 'echarts/extension/bmap/bmap';
import BaiduMap from 'vue-baidu-map'

import iView from 'iview'
import 'iview/dist/styles/iview.css'

import VueVideoPlayer from 'vue-video-player'
import 'video.js/dist/video-js.css'

Vue.use(ElementUI, { locale })
Vue.use(VCharts)
Vue.prototype.$echarts = echarts 
Vue.use(BaiduMap,{
  ak: 'OlcFq4aGmMt1ai1g6DGsqynLqmCsmug2'
})
Vue.use(iView)
Vue.use(VueVideoPlayer)

Vue.config.productionTip = false

//使用钩子函数对路由进行权限跳转
router.beforeEach((to, from, next) => {
  document.title = `${to.meta.title} | 跨摄像头实时视频显示和目标追踪平台`;
  const role = localStorage.getItem('username');
  if (!role && to.path !== '/login'&&to.path !== '/register') {
      next();
  }else if (to.meta.permission) {
      // 如果是管理员权限则可进入，这里只是简单的模拟管理员权限而已
      role === 'admin' ? next() : next('/403');
  }else{
      next();
  }
});

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
