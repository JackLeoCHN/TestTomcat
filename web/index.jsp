<%--
  Created by IntelliJ IDEA.
  User: 17399
  Date: 2022/8/16
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
  <title>Title</title>
</head>
<body  style="text-align: center;">
   <form  action = "<%=request.getContextPath()%>/register.htm" method ="POST" >
       <table border="1">
           <tr>
               <td>登录名:</td>
               <td><input name = "username"/></td>
           </tr>
           <tr>
               <td>密码：</td>
               <td><input name="passwd" type="password" /></td>
           </tr>
           <tr>
               <td>密码确认：</td>
               <td><input name="confirdPasswd"  type="password"/></td>
           </tr>
           <tr>
               <td>邮箱地址：</td>
               <td><input name ="email"/></td>
           </tr>
           <tr>
               <td><input type="submit" value="提交"/></td>
           </tr>
       </table>
   </form>
</body>
</html>
