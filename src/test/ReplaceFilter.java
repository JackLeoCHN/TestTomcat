package test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;





@WebFilter(
        filterName = "replaceFilter",
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name="filePath",value="replace_ZH.properties")
        }
)

public class ReplaceFilter implements Filter {

    private Properties propert = new Properties();

    public void init(FilterConfig filterConfig) throws ServletException {
        //通过filterConfig
//        String filePath = filterConfig.getInitParameter("filePath");
//        try{
//            propert.load(ReplaceFilter.class.getClassLoader().getResourceAsStream(filePath));
//        }catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        }catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    public void doFilter(ServletRequest request , ServletResponse response , FilterChain chain) throws IOException,ServletException{
        Map<String,String> map = new HashMap<String,String >();
        map.put("赌博","***");
        HttpServletResponse res = (HttpServletResponse) response;
        //实例化响应器包装类
        ResponseReplaceWrapperr resp = new ResponseReplaceWrapperr(res);
        chain.doFilter(request,resp);

        //缓存输出字符
        String outString = resp.getCharWriter().toString();

        //循环替换不合法的字符
        for(Object o:map.keySet()) {
            String key = (String) o;
            outString = outString.replace(key,map.get(key));
        }

        //利用原先的输出字符
        PrintWriter out = res.getWriter();
        out.write(outString);
    }
    public void destroy() {

    }
}
