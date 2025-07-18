package com.chen.heartMagic.model.dto.userAnswer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建用户答案请求
 * @author 尘小风
 */
@Data
public class UserAnswerAddRequest implements Serializable {

    /**
     * id（用户答案id,用于保证提交答案的幂等性）
     */
    private Long id;


    /**
     * 应用 id
     */
    private Long appId;


    /**
     * 用户答案（JSON 数组）
     */
    private List<String> choices;


    private static final long serialVersionUID = 1L;
}