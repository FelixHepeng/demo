package com.example.hp.jenkinstomq.thread;

import java.io.*;

/**
 * @author T828155V
 * @date 02/13/23
 * @description: TODO
 */
public class StreamReaderThread implements Runnable {
//    private Logger logger = LoggerFactory.getLogger(StreamReaderThread.class);

    /*
     * 输出流
     */
    private InputStream inputStream;
    /*
     * 输出信息保存的文件名称
     */
    private String logName;

    public StreamReaderThread(InputStream inputStream, String logName) {
        this.inputStream = inputStream;
        this.logName = logName;
    }

    /**
     * FileWriter将日志写入某文件
     * 也可以用logger打印日志记录。
     */
    public void run() {
        BufferedReader in = null;
        FileWriter fwriter = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.inputStream, "gbk"));
            fwriter = new FileWriter(logName, true);
            String line = null;
            while ((line = in.readLine()) != null) {
                fwriter.write(line);
//                logger.info(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                fwriter.flush();
                fwriter.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}