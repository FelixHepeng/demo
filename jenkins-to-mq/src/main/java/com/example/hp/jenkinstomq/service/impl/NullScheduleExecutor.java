package com.example.hp.jenkinstomq.service.impl;

import com.example.hp.jenkinstomq.service.ScheduleExecutor;

/**
 * @author T828155V
 * @date 02/13/23
 * @description: TODO
 */
public class NullScheduleExecutor implements ScheduleExecutor {
    @Override
    public void execute(String path) {
        //do nothing
    }
}
