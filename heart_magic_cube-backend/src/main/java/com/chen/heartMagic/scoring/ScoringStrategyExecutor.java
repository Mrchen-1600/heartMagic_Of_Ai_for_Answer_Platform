package com.chen.heartMagic.scoring;

import com.chen.heartMagic.model.entity.App;
import com.chen.heartMagic.model.entity.UserAnswer;
import com.chen.heartMagic.common.ErrorCode;
import com.chen.heartMagic.exception.BusinessException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * 评分策略执行器
 * 该类用于根据应用配置选择合适的评分策略，并执行评分操作。
 * 核心功能包括：
 * 1. 根据应用类型和评分策略选择合适的评分策略。
 * 2. 执行评分操作并返回用户答案。
 *
 * 使用限制：
 * - 应用配置（appType 和 scoringStrategy）必须正确设置，否则会抛出 BusinessException。
 * - 策略列表（scoringStrategyList）必须包含至少一个匹配的应用类型和评分策略的评分策略。
 */

@Component
public class ScoringStrategyExecutor {

    // 策略列表
    //因为CustomScoreScoringStrategy和CustomTestScoringStrategy都是bean组件，
    // 所以List声明ScoringStrategy接口泛型后，接口的实现类就会自动注入
    @Resource
    private List<ScoringStrategy> scoringStrategyList;

    /**
     * @param choiceList 用户选择的选项列表
     * @param app 应用对象，包含应用类型和评分策略
     * @return 用户答案
     * @throws Exception 如果应用配置有误或未找到匹配的评分策略，则抛出异常
     */
    public UserAnswer doScore(List<String> choiceList, App app) throws Exception {
        Integer appType = app.getAppType();
        Integer appScoringStrategy = app.getScoringStrategy();

        if (appType == null || appScoringStrategy == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "应用配置有误，未找到匹配的策略");
        }

        // 根据自定义注解获取策略
        for (ScoringStrategy strategy : scoringStrategyList) {
            if (strategy.getClass().isAnnotationPresent(ScoringStrategyConfig.class)) {
                ScoringStrategyConfig scoringStrategyConfig = strategy.getClass().getAnnotation(ScoringStrategyConfig.class);
                if (scoringStrategyConfig.appType() == appType && scoringStrategyConfig.scoringStrategy() == appScoringStrategy) {
                    return strategy.doScore(choiceList, app);
                }
            }
        }
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "应用配置有误，未找到匹配的策略");
    }

}
