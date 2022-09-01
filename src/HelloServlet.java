import org.jsoup.internal.StringUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


import org.apache.commons.lang3.StringUtils;


@MultipartConfig(location = "D:/tmp/",maxFileSize = 1024*1024*10)
@WebServlet(
        name = "HelloServlet",
        urlPatterns = {"/include.do"},
        loadOnStartup = 0
)

//@WebServlet(
//        urlPatterns = {"/HelloServlet"},
//        name = " helloServlet"
//)
public class HelloServlet extends HttpServlet {
    private  static  final long serialVersionUID = 1L;
    private  HelloUser user = new HelloUser();
    @Override
    public void init() throws ServletException{
        System.out.println("初始化 init HelloServlet 方法");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("调用service 方法");
        res.setContentType("text/html;charset=gbk");
        PrintWriter out = res.getWriter();
        out.println("收到service请求");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String userName = request.getParameter("username");
        String message = user.sayHello(userName);
        request.setAttribute("message",message);
        request.getRequestDispatcher("/second.do").forward(request,response);
    }


    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
