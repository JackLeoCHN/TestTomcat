

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) throws IOException {

        // 获取日志管理器
        Logger logger = Logger.getLogger(Main.class);
        // 日志管理器配置文件位置
        PropertyConfigurator.configure("src/log4j.properties");

        // 日志记录
        logger.warn("考试开始！");
        logger.info("开始计算1+1");
        System.out.println("1 + 1 = " + (1+1));
        logger.info("开始计算1/0");
        try {
            System.out.println("1 / 1 = " + (1/0));
        } catch (Exception e) {
            logger.error("除数不能为0！！");
        }
        logger.warn("考试结束！");

    }

}