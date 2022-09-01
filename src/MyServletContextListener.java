

import  org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    Logger log =Logger.getLogger("MyServletContextListener");
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获得对象
        ServletContext context = servletContextEvent.getServletContext();
        String name = context.getInitParameter("username");
        System.out.println(name+"实现接口");
        log.debug("初始化name"+name);
        log.debug("Tomcat启动中");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.debug("Tomcat关闭");
    }
}
