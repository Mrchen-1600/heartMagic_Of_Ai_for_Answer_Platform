<!-- 通用布局，比如导航栏，访问每个页面导航栏都不变 -->
<!-- html页面 -->
<template>
  <div id="basicLayout">
    <a-layout style="height: 100vh">
      <!--   顶部栏   -->
      <a-layout-header class="header">
        <!--   components中定义的全局顶部导航栏     -->
        <GlobalHeader />
      </a-layout-header>
      <!--   内容栏   -->
      <a-layout-content class="content">
        <!--  当用户访问某个路由时，Vue Router会动态地将对应的组件渲染到 <router-view /> 所在的位置（根据用户输入的访问页面进行动态的切换）  -->
        <router-view />
      </a-layout-content>
      <!--   底部栏   -->
      <a-layout-footer class="footer">
        <a
          href="https://github.com/Mrchen-1600"
          style="text-decoration: none"
          target="_blank"
        >chenxiaofeng</a
        >
        &copy; 心灵魔方. All rights reserved.
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
import GlobalHeader from "@/components/GlobalHeader.vue";
</script>

<style scoped>
#basicLayout {
}

#basicLayout .header {
  margin-bottom: 16px;
  /* 给导航栏加阴影 颜色、阴影扩散的距离：左边x轴、y轴以及要扩散的范围*/
  box-shadow: #eee 1px 1px 5px;
}

#basicLayout .content {
  margin-bottom: 28px;
  padding: 20px;
  /* 渐变色背景 */
  background: linear-gradient(to right, #fefefe, #fff);
}

.footer {
  padding: 16px;
  text-align: center;
  background: #efefef;
  /*text-decoration: none;*/
}
</style>
