<template>
  <div id="userLayout">
    <a-layout style="height: 100vh">
      <!--  顶部栏    -->
      <a-layout-header class="header">
        <!-- a-space：让标签内组件在同一行，且保持一定的间距   -->
        <a-space>
          <img class="logo" src="../assets/logo.png" />
          <div>心灵魔方AI智能测评平台</div>
        </a-space>
      </a-layout-header>
      <!--   内容栏   -->
      <a-layout-content class="content">
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

<script setup lang="ts"></script>

<style scoped>
#userLayout {
  text-align: center;
  background: url("../assets/bg.png");
  background-size: cover;
}

#userLayout .logo {
  width: 48px;
  height: 48px;
}

#userLayout .header {
  margin-top: 16px;
  font-size: 21px;
}

#userLayout .content {
  margin-bottom: 16px;
  padding: 20px;
}

.footer {
  padding: 16px;
  text-align: center;
  background: #efefef;
}
</style>
