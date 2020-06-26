import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login.vue'
import Admin from '../views/admin.vue'
import Welcome from '../views/admin/welcome'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Login',
        component: Login
    },
    {
        path: '*',
        name: 'Login',
        component: Login
    },
    {
        path: '/admin',
        name: 'Admin',
        component: Admin,
        children: [
            {
                path: 'welcome',
                name: 'Welcome',
                component: Welcome
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
