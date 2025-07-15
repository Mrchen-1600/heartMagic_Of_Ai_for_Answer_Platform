package com.chen.heartMagic.model.vo;

import cn.hutool.json.JSONUtil;
import com.chen.heartMagic.model.dto.question.QuestionContentDTO;
import com.chen.heartMagic.model.entity.Question;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目视图
 * @author 尘小风
 */
@Data
public class QuestionVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 题目内容（json格式）
     */
    private List<QuestionContentDTO> questionContent;

    /**
     * 应用 id
     */
    private Long appId;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建用户信息
     */
    private UserVO user;

    /**
     * 封装类转对象
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        // 将封装类的属性复制到对象中
        BeanUtils.copyProperties(questionVO, question);
        // 获取封装类中的内容
        List<QuestionContentDTO> questionContentDTO = questionVO.getQuestionContent();
        // 将内容转换为JSON字符串，并赋给对象的questionContent属性
        question.setQuestionContent(JSONUtil.toJsonStr(questionContentDTO));
        return question;
    }


    /**
     * 对象转封装类
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        // 将传入的对象的属性值复制到新的封装类对象中
        BeanUtils.copyProperties(question, questionVO);
        // 获取传入的对象的questionContent属性值
        String questionContent = question.getQuestionContent();
        if (questionContent != null) {
            // 将questionContent属性值转换为List<QuestionContentDTO>类型
            questionVO.setQuestionContent(JSONUtil.toList(questionContent, QuestionContentDTO.class));
        }
        // 返回新的封装类对象
        return questionVO;
    }
}
