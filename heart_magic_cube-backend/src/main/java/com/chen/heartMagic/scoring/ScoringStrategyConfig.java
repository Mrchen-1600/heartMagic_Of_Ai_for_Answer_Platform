package com.chen.heartMagic.scoring;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * ScoringStrategyConfig 注解用于指定应用类型和评分策略。
 */
@Target(ElementType.TYPE) //表示该注解可以应用于类、接口（包括注解类型）或枚举声明。
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ScoringStrategyConfig {

    /**
     * 应用类型
     */
    int appType();

    /**
     * 评分策略
     */
    int scoringStrategy();
}