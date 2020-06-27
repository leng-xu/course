<template>
    <div>
        <h1>欢迎！</h1>
    </div>
</template>

<script>
    export default {
        name: 'welcome',
        mounted: function() {//组件每次加载都会执行
            this.$parent.activeSidebar("welcome-sidebar");
        },
        methods:{
        }
    }
</script>