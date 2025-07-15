package com.chen.heartMagic.model.dto.question;

import lombok.Data;

/**
 * 题目答案封装类（用于 AI评分）
 * @author 尘小风
 */
@Data
public class QuestionAnswerDTO {

    /**
     * 题目
     */
    private String title;

    /**
     * 用户答案
     */
    private String userAnswer;
}
