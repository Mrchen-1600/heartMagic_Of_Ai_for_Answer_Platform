package com.chen.heartMagic.model.dto.question;

import com.chen.heartMagic.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询题目请求
 *
 * @author 尘小风
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;


    /**
     * 题目内容（json格式）
     */
    private String questionContent;


    /**
     * 应用 id
     */
    private Long appId;


    /**
     * 创建用户 id
     */
    private Long userId;


    private Long notId;


    private static final long serialVersionUID = 1L;
}