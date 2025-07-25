<template>
  <div id="homePage">
    <a-form
      :model="formSearchParams"
      :style="{ marginBottom: '20px' }"
      style="align-items: center"
      @submit="doSearch"
    >
      <a-input-search
        v-model="formSearchParams.appName"
        :style="{ width: '320px' }"
        button-text="搜索"
        placeholder="快速发现答题应用"
        search-button
        size="large"
        @click="doSearch"
      >
        <template #button-icon>
          <icon-search />
        </template>
      </a-input-search>
    </a-form>
    <a-list
      :bordered="false"
      :data="dataList"
      :grid-props="{ gutter: [20, 20], sm: 24, md: 12, lg: 8, xl: 6 }"
      :pagination-props="{
        pageSize: searchParams.pageSize,
        current: searchParams.current,
        total,
      }"
      class="list-demo-action-layout"
      @page-change="onPageChange"
    >
      <template #item="{ item }">
        <AppCard :app="item" />
      </template>
    </a-list>
  </div>
</template>

<script lang="ts" setup>
import { ref, watchEffect } from "vue";
import AppCard from "@/components/AppCard.vue";
import { listAppVoByPageUsingPost } from "@/api/appController";
import message from "@arco-design/web-vue/es/message";
import { REVIEW_STATUS_ENUM } from "@/constant/app";

const formSearchParams = ref<API.AppQueryRequest>({});

const doSearch = () => {
  searchParams.value = {
    ...initSearchParams,
    ...formSearchParams.value,
  };
};

// 初始化搜索条件（不应该被修改）
const initSearchParams = {
  current: 1,
  pageSize: 8,
  sortOrder: "descend",
  sortField: "createTime",
};

const searchParams = ref<API.AppQueryRequest>({
  ...initSearchParams,
});
const dataList = ref<API.AppVO[]>([]);
const total = ref<number>(0);

/**
 * 加载数据
 */
const loadData = async () => {
  const params = {
    reviewStatus: REVIEW_STATUS_ENUM.PASS,
    ...searchParams.value,
  };
  const res = await listAppVoByPageUsingPost(params);
  if (res.data.code === 0) {
    dataList.value = res.data.data?.records || [];
    total.value = res.data.data?.total || 0;
  } else {
    message.error("获取数据失败，" + res.data.message);
  }
};

/**
 * 当分页变化时，改变搜索条件，触发数据加载
 * @param page
 */
const onPageChange = (page: number) => {
  searchParams.value = {
    ...searchParams.value,
    current: page,
  };
};

/**
 * 监听 searchParams 变量，改变时触发数据的重新加载
 */
watchEffect(() => {
  loadData();
});
</script>

<style scoped>
#homePage {
}

.searchBar {
  margin-bottom: 28px;
  text-align: center;
}

.list-demo-action-layout .image-area {
  width: 183px;
  height: 119px;
  overflow: hidden;
  border-radius: 2px;
}

.list-demo-action-layout .list-demo-item {
  padding: 20px 0;
  border-bottom: 1px solid var(--color-fill-3);
}

.list-demo-action-layout .image-area img {
  width: 100%;
}

.list-demo-action-layout .arco-list-item-action .arco-icon {
  margin: 0 4px;
}
</style>
