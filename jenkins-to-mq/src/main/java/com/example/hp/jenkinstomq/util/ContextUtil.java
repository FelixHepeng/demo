package com.example.hp.jenkinstomq.util;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author T828155V
 * @date 02/13/23
 * @description: TODO
 */
public class ContextUtil implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       ContextUtil.context = applicationContext;
    }

    public static <T> T getBean(Class<T> cz){
        return context.getBean(cz);
    }
}
