package com.example.hp.jenkinstomq.service.impl;

import com.example.hp.jenkinstomq.service.ScheduleExecutor;
import com.example.hp.jenkinstomq.thread.StreamReaderThread;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.ServerException;

/**
 * @author T828155V
 * @date 02/13/23
 * @description: TODO
 */
@Service
public class PythonScheduleExecutor implements ScheduleExecutor {
    @Override
    public void execute(String path) {
//        logger.info("======python start======");

        boolean success = false;
        Process proc = null;
        try {
            // linux 用 "python3", windows 用python.exe的绝对路径（"D:\\xxx\\Python\\Python39-32\\python.exe"）
            String[] args1 = new String[]{"python3", path};
            proc = Runtime.getRuntime().exec(args1);

            // 读写日志线程，分成两个也是为了避免线程堵塞之类的问题
            Thread thread1 = new Thread(new StreamReaderThread(proc.getInputStream(),"info.txt"));
            Thread thread2 = new Thread(new StreamReaderThread(proc.getErrorStream(),"error.txt"));

            thread2.start();
            //必须后执行，否则正确消息容易接收不到
            thread1.start();
            // result是结果，具体有哪些值，可以自己去查一下
            int result = proc.waitFor();
            success = result != -1;

            //等待后台线程读写完毕
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                proc.getErrorStream().close();
                proc.getInputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            proc.destroy();
//            logger.info("======python end");
        }
    }
}
