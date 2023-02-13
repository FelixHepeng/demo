package com.example.hp.jenkinstomq.enums;

import com.example.hp.jenkinstomq.service.ScheduleExecutor;
import com.example.hp.jenkinstomq.service.impl.GroovyScheduleExecutor;
import com.example.hp.jenkinstomq.service.impl.JavaScheduleExecutor;
import com.example.hp.jenkinstomq.service.impl.NullScheduleExecutor;
import com.example.hp.jenkinstomq.service.impl.PythonScheduleExecutor;
import com.example.hp.jenkinstomq.util.ContextUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

/**
 * @author T828155V
 * @date 02/13/23
 * @description: TODO
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ScheduleTypeEnum {

    JAVA("java"),
    PYTHON("python"),
    GROOVY("groovy");

    private String type;

    public static ScheduleExecutor getExecutor(String type){
        if (type == null || type.length() == 0){
            return ContextUtil.getBean(NullScheduleExecutor.class);
        }
        if (JAVA.type.equals(type)){
            return ContextUtil.getBean(JavaScheduleExecutor.class);
        }
        if (PYTHON.type.equals(type)){
            return ContextUtil.getBean(PythonScheduleExecutor.class);
        }
        if (GROOVY.type.equals(type)){
            return ContextUtil.getBean(GroovyScheduleExecutor.class);
        }
        return ContextUtil.getBean(NullScheduleExecutor.class);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
