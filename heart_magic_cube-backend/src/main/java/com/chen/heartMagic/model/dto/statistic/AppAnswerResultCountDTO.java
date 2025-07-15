package com.chen.heartMagic.model.dto.statistic;

import lombok.Data;

/**
 * App答案结果统计
 */
@Data
public class AppAnswerResultCountDTO {
    // 结果名称
    private String resultName;
    // 对应个数
    private String resultCount;
}