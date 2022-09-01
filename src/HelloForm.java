import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm
 */
//@WebServlet(
//        name="HelloForm",
//        urlPatterns = "/register.htm",
//        loadOnStartup = 0
//)
public class HelloForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    HelloUser User  = new HelloUser();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        doPost(request,response);
    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userName = request.getParameter("username");
      String passwd = request.getParameter("passwd");
      String confirdPasswd = request.getParameter("confirdPasswd");

      String email = request.getParameter("email");

      List<String> errors = new ArrayList<String>();
      if(isVaildUesrname(userName)) {
          errors.add("用户名空或已存在");
      }
      if(!isValidEmail(email)) {
          errors.add("无效的邮箱号码！");
      }
      if(isValidPassword(passwd,confirdPasswd)) {
          errors.add("密码问题！");
      }
      if(!errors.isEmpty()) {
          request.setAttribute("errors",errors);
          request.getRequestDispatcher("/error.htm").forward(request,response);
      }else {
          HelloUser user= HelloUser.getInstance();
          Map<String,String> map= user.getUserMap();
          map.put(userName,passwd+"##"+email);
          request.getRequestDispatcher("/success.htm").forward(request,response);
      }
    }

    //正则表达式验证邮箱
    public  boolean isValidEmail(String email) {
        boolean flag =false;
        if(email == null || "".equals(email)) flag = false;
        if(email!=null && ! "".equals(email)) {
            flag = email.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
        }
        return  flag;
    }

    //验证用户名是否存在
    //根据key 判断是否存在
    public boolean isVaildUesrname(String userName) {
        HelloUser user =HelloUser.getInstance();
        Map<String,String> map = user.getUserMap();
        if(userName != null && !userName.equals("")) {
            if(map.get(userName)!=null && ! map.get(userName).equals("")) {
                return true;
            }else {
                return false;
            }
        }
        if(userName == null && userName.equals("")) {
            return true;
        }
        return  true;
    }

    //验证密码
    public boolean isValidPassword(String passwd,String confirdPasswd) {
        return passwd == null || confirdPasswd == null || passwd.length()<6 || confirdPasswd.length()<6 || !passwd.equals(confirdPasswd);
    }
}