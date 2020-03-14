import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import BlogHome from '../views/BlogHome.vue'
import { Tab, Tabs } from 'vant';
import { Sidebar, SidebarItem } from 'vant';
import { Icon } from 'vant';
import { Panel } from 'vant';
import { Button } from 'vant';
import { Divider } from 'vant';
import { Col, Row } from 'vant';
import { Pagination } from 'vant';
import { Image } from 'vant';
import { Tag } from 'vant';
import { NoticeBar } from 'vant';

Vue.use(NoticeBar);
Vue.use(Tag);
Vue.use(Image);
Vue.use(Pagination);
Vue.use(Col);
Vue.use(Row);
Vue.use(Divider);
Vue.use(Button);
Vue.use(Panel);
Vue.use(Icon);
Vue.use(Sidebar);
Vue.use(SidebarItem);
Vue.use(Tab);
Vue.use(Tabs);

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'BlogHome',
    component: BlogHome
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
