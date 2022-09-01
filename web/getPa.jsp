<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body  style="text-align: center;">
    <form  action="index.jsp" method="post">
        <table align="center">
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value="" /></td>
            </tr>
            <tr>
                <td>城市</td>
                <td><input type="text" name="city" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交" /></td>
            </tr>
            <tr>
                <td><input  type="reset" value="重置"/></td>
            </tr>
        </table>

    </form>
</body>
</html>
