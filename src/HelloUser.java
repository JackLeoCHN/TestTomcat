import java.util.HashMap;
import java.util.Map;

public class HelloUser {
    private Map<String,String> helloMessage = new HashMap<String,String>();
    private static  HelloUser user = null;
    public HelloUser() {
        helloMessage.put("John","1115555##a@sina.com");
        helloMessage.put("Smith","2225555##j@bai.com");
        helloMessage.put("Rose","3335555##wang@sina.com");
    }

    public static  HelloUser getInstance() {
        if(user == null) {
            user=new HelloUser();
        }
        return user;
    }
    //根据用户，返回Map消息：
    public String sayHello(String userName) {
        return helloMessage.get(userName);
    }
    public Map<String,String> getUserMap() {
        return helloMessage;
    }
}
