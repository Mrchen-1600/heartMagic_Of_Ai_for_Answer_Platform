// 传统情况下，每个请求都要单独编写代码，很麻烦。
// 可以使用 OpenAPI 工具，根据接口文档直接自动生成

const { generateService } = require("@umijs/openapi");

generateService ({
  requestLibPath: "import request from '@/request'", //指定根据我们自己的request文件进行生成
  schemaPath: "http://localhost:8101/api/v2/api-docs", //根据哪个地址的接口文档生成
  serversPath: "./src", //在哪个目录下生成
});
