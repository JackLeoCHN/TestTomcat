package test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseReplaceWrapperr extends HttpServletResponseWrapper {

    private  CharArrayWriter charWriter = new CharArrayWriter();

    public ResponseReplaceWrapperr(HttpServletResponse response) {
        super(response);
    }

    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(charWriter);
    }

    public CharArrayWriter getCharWriter() {
        return charWriter;
    }
}
