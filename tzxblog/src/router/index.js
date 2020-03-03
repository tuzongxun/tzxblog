import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import BlogHome from '../views/BlogHome.vue'
import { Tab, Tabs } from 'vant';
import { Sidebar, SidebarItem } from 'vant';
import { Icon } from 'vant';

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
