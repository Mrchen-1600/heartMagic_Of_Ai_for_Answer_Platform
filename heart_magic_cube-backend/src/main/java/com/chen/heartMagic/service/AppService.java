package com.chen.heartMagic.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.heartMagic.model.dto.app.AppQueryRequest;
import com.chen.heartMagic.model.entity.App;
import com.chen.heartMagic.model.vo.AppVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 应用服务
 * @author 尘小风
 */
public interface AppService extends IService<App> {

    /**
     * 校验数据
     * @param app
     * @param add 对创建的数据进行校验
     */
    void validApp(App app, boolean add);


    /**
     * 获取查询条件
     * @param appQueryRequest
     * @return
     */
    QueryWrapper<App> getQueryWrapper(AppQueryRequest appQueryRequest);


    /**
     * 获取应用封装
     * @param app
     * @param request
     * @return
     */
    AppVO getAppVO(App app, HttpServletRequest request);


    /**
     * 分页获取应用封装
     * @param appPage
     * @param request
     * @return
     */
    Page<AppVO> getAppVOPage(Page<App> appPage, HttpServletRequest request);
}
