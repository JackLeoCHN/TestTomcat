import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet(
        urlPatterns = {"/servletConfigDemo.do"},
        loadOnStartup = 1,
        name = "ServletConfigDemo",
        displayName = "demo",
        initParams = {
                @WebInitParam(name="success",value="success.html"),
                @WebInitParam(name="error",value = "error.html")
        }
)

public class ServletConfigDemo extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletConfig对象
        ServletConfig config = getServletConfig();

        //getInitParameter(name)
        String success = config.getInitParameter("success");
        String error = config.getInitParameter("error");
        System.out.println("success----"+success);
        System.out.println("error----"+error);

        //getInitParameterNames
        Enumeration enumeration = config.getInitParameterNames();
        while(enumeration.hasMoreElements()) {
            String name =(String) enumeration.nextElement();
            String value = config.getInitParameter(name);
            System.out.println("name---"+name);
            System.out.println("value---"+value);
        }

        //getServletContext
        ServletContext servletContext = config.getServletContext();
        System.out.println("servletContext-----"+servletContext);

        //getServletName
        String servletName = config.getServletName();
        System.out.println("servletName---"+servletName);

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String userID = request.getParameter("userID");
        String passwd = request.getParameter("passwd");

        //判断是否为lin1



    }
}