<template>
  <div class="login-page">
    <h2>用户登录</h2>
    <a-form
      :model="form"
      :style="{ maxWidth: '550px', margin: '0 auto' }"
      auto-label-width
      label-align="left"
      @submit="handleSubmit"
    >
      <div class="input-group">
        <icon-user-add class="icon" size="20px" />
        <a-form-item field="userAccount" label="账号">
          <a-input
            v-model="form.userAccount"
            class="input-field"
            placeholder="请输入账号"
          />
        </a-form-item>
      </div>
      <div class="input-group">
        <icon-code class="icon" size="20px" />
        <a-form-item
          field="userPassword"
          label="密码"
          tooltip="密码不小于 8 位"
        >
          <a-input-password
            v-model="form.userPassword"
            class="input-field"
            placeholder="请输入密码"
          />
        </a-form-item>
      </div>

      <a-form-item>
        <div class="actions">
          <a-button class="submit-button" html-type="submit" type="primary">
            登录
          </a-button>
          <a-button class="register-link" href="/user/register" type="outline"
          >新用户注册
          </a-button>
        </div>
      </a-form-item>
    </a-form>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from "vue";
import { userLoginUsingPost } from "@/api/userController";
import { useLoginUserStore } from "@/store/userStore";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";

const loginUserStore = useLoginUserStore();
const router = useRouter();

const form = reactive({
  userAccount: "",
  userPassword: "",
} as API.UserLoginRequest);

/**
 * 提交
 */
const handleSubmit = async () => {
  const res = await userLoginUsingPost(form);
  if (res.data.code === 0) {
    await loginUserStore.fetchLoginUser();
    message.success("登录成功");
    router.push({
      path: "/",
      replace: true,
    });
  } else {
    message.error("登录失败，" + res.data.message);
  }
};
</script>

<style scoped>
.login-page {
  width: 500px;
  margin: auto;
  margin-top: 100px;
  padding: 30px;
  text-align: center;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.login-page h2 {
  margin-bottom: 30px;
}

.input-group {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.icon {
  margin-right: 10px;
  margin-bottom: 20px;
  color: #999;
}

.input-field {
  width: 100%;
  max-width: 400px;
}

.actions {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  margin: auto;
}

.submit-button {
  width: 100px;
  margin-right: 80px;
}

.register-link {
}

.social-logins a-button {
  width: 100px;
}
</style>
