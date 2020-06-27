import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login.vue'
import Admin from '../views/admin.vue'
import Welcome from '../views/admin/welcome'
import Chapter from '../views/admin/chapter'


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'login',
        component: Login
    },
    {
        path: '*',
        name: 'login',
        component: Login
    },
    {
        path: '/',
        name: 'admin',
        component: Admin,
        children: [
            {
                path: 'welcome',
                name: 'welcome',
                component: Welcome
            },
            {
                path: 'business/chapter',
                name: 'business/chapter',
                component: Chapter
            }
        ]
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
