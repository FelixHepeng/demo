package com.example.hp.jenkinstomq.service.impl;

import com.example.hp.jenkinstomq.service.ScheduleExecutor;
import groovy.lang.GroovyShell;
import org.springframework.stereotype.Service;

import java.io.File;
import java.rmi.ServerException;

/**
 * @author T828155V
 * @date 02/13/23
 * @description: TODO
 */
@Service
public class GroovyScheduleExecutor implements ScheduleExecutor {
    @Override
    public void execute(String path) {
//        logger.info("======groovy start======");

        boolean success = false;
        try {
            GroovyShell groovyShell = new GroovyShell();
            Object result = groovyShell.evaluate(new File(path));
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            logger.info("======groovy end=======");
        }
    }
}
