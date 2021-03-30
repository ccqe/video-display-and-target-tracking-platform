<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            background-color="#393e46"
            text-color="#bfcbd9"
            active-text-color="#20a0ff"
            unique-opened
            router
        >
            <template v-for="item in items">
                <template v-if="item.subs">
                    <el-submenu :index="item.index" :key="item.index">
                        <template slot="title">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </template>
                        <template v-for="subItem in item.subs">
                            <el-submenu
                                v-if="subItem.subs"
                                :index="subItem.index"
                                :key="subItem.index"
                            >
                                <template slot="title">{{ subItem.title }}</template>
                                <el-menu-item
                                    v-for="(threeItem,i) in subItem.subs"
                                    :key="i"
                                    :index="threeItem.index"
                                >{{ threeItem.title }}</el-menu-item>
                            </el-submenu>
                            <el-menu-item
                                v-else
                                :index="subItem.index"
                                :key="subItem.index"
                            >{{ subItem.title }}</el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        <span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import situation from '../situation.js';
export default {
    data() {
        return {
            collapse: false,
            items: [
                {
                    icon: 'el-icon-map-location',
                    index: 'mapshow',
                    title: '地图标点'
                },
                {
                    icon: 'el-icon-s-platform',
                    index: 'control',
                    title: '跨视频监控'
                },
                {
                    icon: 'el-icon-video-camera',
                    index: 'playback',
                    title: '视频回放'
                },
                {
                    icon: 'el-icon-pie-chart',
                    index: 'statistics',
                    title: '数据统计'
                },
                {
                    icon: 'el-icon-user',
                    index: '4',
                    title: '摄像头管理',
                    subs: [
                        {
                            index: 'cameralist',
                            title: '摄像头列表'
                        },
                        {
                            index: 'addcamera',
                            title: '摄像头添加'
                        }
                    ]
                },
                {
                    icon: 'el-icon-user',
                    index: '5',
                    title: '用户管理',
                    subs: [
                        {
                            index: 'userlist',
                            title: '用户列表'
                        },
                        {
                            index: 'adduser',
                            title: '用户添加'
                        }
                    ]
                }
            ]
        };
    },
    computed: {
        onRoutes() {
            return this.$route.path.replace('/', '');
        }
    },
    created() {
        // 通过 Event situation 进行组件间通信，来折叠侧边栏
        situation.$on('collapse', msg => {
            this.collapse = msg;
            situation.$emit('collapse-content', msg);
        });
    },
    isCollapse() {
      return !this.sidebar.opened
    }
};
</script>
