<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>login</title>

<style type="text/css">
.youyuan {
	font-family: "幼圆";
}
</style>
</head>

<body>
<table width="1204" border="0" class="youyuan">
  <tr>
    <td width="638" height="250"><img src="images/tou.jpg" width="631" height="181" /></td>
    <td width="550" rowspan="2"><img src="images/login.jpg" width="554" height="766" /></td>
  </tr>
  <tr>
    <td valign="top"><form id="form1" name="login" method="post" action="loginServlet">
      <table width="633" height="247" border="0">
        <tr>
          <td width=37% height="85" align="right"><img src="images/yonghuming.jpg" width="157" height="51" /></td>
          <td width=63%><input name="name" type="text" id="name" value="" size="30" /> 
            <a href="register.jsp">没有注册？</a></td>
          </tr>
        <tr>
          <td height="64"align="right"><img src="images/mima.jpg" width="166" height="49" /></td>
          <td><input name="password" type="password" id="password" value="" size="30" />
            <a href="home.html">忘记密码？</a></td>
          </tr>
        <tr>
          <td height="63" align="right"> <input type="submit" name="submit" id="submit" value="登陆" /></td>
          <td><input type="reset" name="reset" id="reset" value="重置" /></td>
          </tr>
        </table>
    </form></td>
  </tr>
</table>
</body>
</html>
