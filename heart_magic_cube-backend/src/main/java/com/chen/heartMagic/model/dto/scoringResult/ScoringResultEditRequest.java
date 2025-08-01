package com.chen.heartMagic.model.dto.scoringResult;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 编辑评分结果请求
 *
 * @author 尘小风
 */
@Data
public class ScoringResultEditRequest implements Serializable {

    /**
     * id
     */
    private Long id;


    /**
     * 结果名称，如物流师
     */
    private String resultName;


    /**
     * 结果描述
     */
    private String resultDesc;


    /**
     * 结果图片
     */
    private String resultPicture;


    /**
     * 结果属性集合 JSON，如 [I,S,T,J]
     */
    private List<String> resultProp;


    /**
     * 结果得分范围，如 80，表示 80及以上的分数命中此结果
     */
    private Integer resultScoreRange;

    private static final long serialVersionUID = 1L;
}