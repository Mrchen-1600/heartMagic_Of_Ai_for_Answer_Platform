package com.chen.heartMagic.scoring;

import com.chen.heartMagic.model.entity.App;
import com.chen.heartMagic.model.entity.UserAnswer;

import java.util.List;

/**
 * 评分策略 策略模式接口
 * @author 尘小风
 */

public interface ScoringStrategy {

    /**
     * 执行评分
     * @param choices 选项
     * @param app 应用
     * @return 用户答案
     * @throws Exception 异常
     */
    UserAnswer doScore(List<String> choices, App app) throws Exception;
}