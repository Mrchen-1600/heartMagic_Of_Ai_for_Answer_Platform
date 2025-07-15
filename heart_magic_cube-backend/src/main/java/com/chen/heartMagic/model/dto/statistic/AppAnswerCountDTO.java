package com.chen.heartMagic.model.dto.statistic;

import lombok.Data;

/**
 * App用户提交答案数统计
 */
@Data
public class AppAnswerCountDTO {

    private Long appId;

    /**
     * 用户提交答案数
     */
    private Long answerCount;
}