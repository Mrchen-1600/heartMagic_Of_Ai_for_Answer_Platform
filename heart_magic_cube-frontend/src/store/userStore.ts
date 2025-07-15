import { defineStore } from "pinia";
import { ref } from "vue";
import { getLoginUserUsingGet } from "@/api/userController";
import ACCESS_ENUM from "@/access/accessEnum";


/**
 * 登录用户信息全局状态
 */
export const useLoginUserStore = defineStore("loginUser", () => {
  const loginUser = ref<API.LoginUserVO>({
    userName: "未登录",
  });

  // 定义一个函数 setLoginUser，用于设置登录用户的信息
  function setLoginUser(newLoginUser: API.LoginUserVO) {
    loginUser.value = newLoginUser;
  }

  // 定义一个异步函数 fetchLoginUser 用于获取登录用户信息
  async function fetchLoginUser() {
    // 使用 await 关键字等待 getLoginUserUsingGet 函数的执行结果，并将结果赋值给 res 变量
    const res = await getLoginUserUsingGet();
    // 检查 res 对象中的 data 属性的 code 是否为 0（通常表示请求成功）以及 data 属性是否存在
    if ( res.data.data) {
      // 如果条件成立，将 res.data.data 赋值给 loginUser.value，更新登录用户信息
      loginUser.value = res.data.data;
    } else {
      // 如果条件不成立，将 loginUser.value 设置为一个默认对象，表示用户未登录
      loginUser.value = { userRole: ACCESS_ENUM.NOT_LOGIN };
    }
  }

  return { loginUser, setLoginUser, fetchLoginUser };
});


