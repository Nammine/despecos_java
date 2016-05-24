<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>product_detail</title>
<style type="text/css">
body,td,th {
	font-family: "幼圆";
	font-size: 24px;
	color: #72392c;
	text-align: center;
}
</style>
</head>

<body>
<p><img src="images/detaildaohang.jpg" width="1359" height="340" border="0" usemap="#Map2" />
 <map name="Map" id="Map2">
    <area shape="rect" coords="372,249,535,323" href="home.html" />
    <area shape="rect" coords="563,247,746,331" href="register.jsp" />
    <area shape="rect" coords="787,252,923,325" href="listorderforms.jsp" />
    <area shape="rect" coords="967,252,1094,324" href="shopcart.jsp" />
    <area shape="rect" coords="1148,250,1281,324" href="logoutServlet" />
  </map>
</p>
<p>&nbsp;</p>
<table width="1324" border="1">
  <tr>
    <td colspan="3"><img src="images/productdetail.jpg" width="1359" height="50" /></td>
  </tr>
  <tr>
    <td width="453"><img src="images/ID.jpg" width="453" height="50" /></td>
    <td width="453"><img src="images/PEICE.jpg" width="453" height="50" /></td>
    <td width="402"><img src="images/detail.jpg" width="453" height="50" /></td>
  </tr>
  <tr>
    <td align="center">${requestScope.cosmetic.id}</td>
    <td align="center">${requestScope.cosmetic.price}</td>
    <td align="center">${requestScope.cosmetic.description}</td>
  </tr>
</table>
<p>&nbsp;</p>
<p><img src="images/fot.jpg" width="1359" height="90" border="0" usemap="#Map" />
  <map name="Map" id="Map">
    <area shape="rect" coords="1198,30,1345,66" href="http://www.desperado.com" />
  </map>
</p>
</body>
</html>