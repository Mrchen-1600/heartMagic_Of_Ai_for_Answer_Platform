import { createRouter, createWebHistory } from "vue-router";
import { routes } from "@/router/routes";

// createRouter用于创建一个新的Vue Router实例。它接收一个配置对象作为参数，该对象定义了路由的行为和路由表。
const router = createRouter({
  // history属性指定了路由模式。在这里，使用的是createWebHistory，这种方式不会在URL中添加#符号。
  // createWebHistory函数接收一个参数，即应用的BASE_URL。
  // process.env.BASE_URL是从环境变量中获取的基础URL，通常用于定义应用的部署路径。
  history: createWebHistory(process.env.BASE_URL),
  // routes属性是一个数组，包含了应用中所有定义的路由规则。
  routes,
});

export default router;
