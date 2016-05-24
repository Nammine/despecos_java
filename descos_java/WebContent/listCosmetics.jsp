<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>List</title>
<style type="text/css">
body {
	text-align: center;
	font-family: "幼圆";
}
body,td,th {
	font-size: 24px;
	color: #72392c;
}
a:link{color: #72392c;}
a:hover{color: #CCC;}
a:visited {color: #CCC;}
a:active {color: #CCC;}
</style>
</head>

<body>
<p><img src="images/list.jpg" width="1359" height="340" border="0" usemap="#Map" />
 <map name="Map" id="Map">
    <area shape="rect" coords="372,249,535,323" href="home.html" />
    <area shape="rect" coords="563,247,746,331" href="register.jsp" />
    <area shape="rect" coords="787,252,923,325" href="listorderforms.jsp" />
    <area shape="rect" coords="967,252,1094,324" href="shopcart.jsp" />
    <area shape="rect" coords="1148,250,1281,324" href="logoutServlet" />
  </map>
</p>
<p>&nbsp;</p>
<table width="1359">
  <tr>
    <td width="70"></td>
    <td width="527"></td>
    <td width="87"></td>
    <td width="196"></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td align="center"><img src="images/xuhao.jpg" width="70" height="50" /></td>
    <td align="center"><img src="images/chanpm.jpg" width="527" height="50" /></td>
    <td align="center"><img src="images/price.jpg" width="87" height="50" /></td>
    <td align="center"><img src="images/buy.jpg" width="196" height="50" /></td>
  </tr>
        <c:forEach items="${sessionScope.cosmetics }" var="cosmetic">         
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${cosmetic.id }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="cosmeticDetail?cosmeticId=${cosmetic.id}">${cosmetic.name }</a></td>
			<td class=tablebody2 valign=middle align=center width="">${cosmetic.price }</td>
			<td class=tablebody1 valign=middle align=center width="">
			<a href="addToCart?cosmeticId=${cosmetic.id}"><img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
</c:forEach>       
</table>
<p>&nbsp;</p>
<p><img src="images/fot.jpg" width="1359" height="90" border="0" align="bottom" usemap="#Map2" />
  <map name="Map2" id="Map2">
    <area shape="rect" coords="1197,29,1343,65" href="http://www.desperado.com" />
  </map>
</p>
</body>
</html>
