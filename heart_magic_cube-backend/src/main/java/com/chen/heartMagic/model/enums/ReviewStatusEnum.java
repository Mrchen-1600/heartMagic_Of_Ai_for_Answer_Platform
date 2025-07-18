package com.chen.heartMagic.model.enums;

import cn.hutool.core.util.ObjectUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 审核状态枚举
 * @author 尘小风
 */
public enum ReviewStatusEnum {

    //枚举类的两个字段，一个是存入数据库的值，一个是对值进行解释的字段
    REVIEWING("待审核", 0),
    PASS("通过", 1),
    REJECT("拒绝", 2);

    private final String text;

    private final int value;


    //构造器
    ReviewStatusEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }



    /**
     * 根据 value 获取枚举
     * @param value
     * @return
     */
    public static ReviewStatusEnum getEnumByValue(Integer value) {
        if (ObjectUtil.isEmpty(value)) {
            return null;
        }
        for (ReviewStatusEnum anEnum : ReviewStatusEnum.values()) {
            if (anEnum.value == value) {
                return anEnum;
            }
        }
        return null;
    }



    /**
     * 获取所有枚举值列表
     * @return
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }



    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
