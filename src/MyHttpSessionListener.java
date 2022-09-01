import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    public static  int count=0 ;

    public static  int getCount() {
        return count;
    }


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        MyHttpSessionListener.count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        MyHttpSessionListener.count--;
    }
}
