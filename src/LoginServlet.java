import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(
        name = "loginServlet",
        urlPatterns = {"/login.htm"},
        initParams = {
                @WebInitParam(name = "success",value="success.jsp")
        }
)

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init() throws ServletException{
        System.out.println("初始化 init loginServlet 方法");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passwd = request.getParameter("passwd");

        if(checkLogin(userName,passwd)) {
            request.getSession().setAttribute("user",userName);
            request.getSession().setAttribute("count",MyHttpSessionListener.getCount());
           // System.out.println(MyHttpSessionListener.getCount());
            System.out.println(userName+" "+passwd);
           // String suss= getInitParameter("web/success.jsp");
//            response.sendRedirect(suss);
            //System.out.println(suss);
            //request.getRequestDispatcher("/member.htm").forward(request,response);
        }else {
            response.sendRedirect("login.jsp");
        }
        String suss= getInitParameter("success");
        System.out.println(suss);
        response.sendRedirect(suss);

    }

    public  boolean checkLogin(String username,String passwd) {
        HelloUser user = HelloUser.getInstance();
        Map<String,String> map = user.getUserMap();
        if(username!=null && !"".equals(username)&& passwd!=null && !"".equals(passwd)) {
            String[] arr = map.get(username).split("##");
            if(arr[0].equals(passwd)) return true;
            else return  false;
        }else {
            return  false;
        }
    }
}