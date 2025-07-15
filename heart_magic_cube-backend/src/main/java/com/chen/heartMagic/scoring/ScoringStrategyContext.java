package com.chen.heartMagic.scoring;

import com.chen.heartMagic.common.ErrorCode;
import com.chen.heartMagic.exception.BusinessException;
import com.chen.heartMagic.model.entity.App;
import com.chen.heartMagic.model.entity.UserAnswer;
import com.chen.heartMagic.model.enums.AppScoringStrategyEnum;
import com.chen.heartMagic.model.enums.AppTypeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * ScoringStrategyContext 类用于根据应用类型和评分策略选择并执行相应的评分策略。
 * 该类包含两个评分策略的实现，分别是 CustomScoreScoringStrategy 和 CustomTestScoringStrategy。
 * 当调用 doScore 方法时，根据传入的应用类型和评分策略，选择并执行相应的评分策略。
 */
@Service
@Deprecated
public class ScoringStrategyContext {

    @Resource
    private CustomScoreScoringStrategy customScoreScoringStrategy;

    @Resource
    private CustomTestScoringStrategy customTestScoringStrategy;

    /**
     * 根据应用类型和评分策略进行评分。
     * @param choiceList 用户选择的选项列表
     * @param app 应用对象，包含应用类型和评分策略
     * @return 评分结果
     * @throws Exception 如果应用配置有误，抛出异常
     */
    public UserAnswer doScore(List<String> choiceList, App app) throws Exception {
        AppTypeEnum appTypeEnum = AppTypeEnum.getEnumByValue(app.getAppType());
        AppScoringStrategyEnum appScoringStrategyEnum = AppScoringStrategyEnum.getEnumByValue(app.getScoringStrategy());
        if (appTypeEnum == null || appScoringStrategyEnum == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "应用配置有误，未找到匹配的策略");
        }

        // 根据不同的应用类别和评分策略，选择对应的策略执行
        switch (appTypeEnum) {
            case SCORE:
                switch (appScoringStrategyEnum) {
                    case CUSTOM:
                        return customScoreScoringStrategy.doScore(choiceList, app);
                    case AI:
                        break;
                }
                break;

            case TEST:
                switch (appScoringStrategyEnum) {
                    case CUSTOM:
                        return customTestScoringStrategy.doScore(choiceList, app);
                    case AI:
                        break;
                }
                break;
        }

        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "应用配置有误，未找到匹配的策略");
    }
}
