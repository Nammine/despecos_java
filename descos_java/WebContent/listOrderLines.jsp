<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>odetail</title>
<style type="text/css">
body{
	text-align: center;
	font-family: "幼圆";
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
<p><img src="images/odetial.jpg" width="1359" height="340" usemap="#Map"/>
<map name="Map" id="Map">
    <area shape="rect" coords="372,249,535,323" href="home.html" />
    <area shape="rect" coords="563,247,746,331" href="register.jsp" />
    <area shape="rect" coords="787,252,923,325" href="listorderforms.jsp" />
    <area shape="rect" coords="967,252,1094,324" href="shopcart.jsp" />
    <area shape="rect" coords="1148,250,1281,324" href="logoutServlet" />
  </map>
</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="1359">
  <tr>
    <td width="226"><img src="images/cartno.jpg" width="226" height="50" /></td>
    <td width="226"><img src="images/cartname.jpg" width="226" height="50" /></td>
    <td width="226"><img src="images/cartprice.jpg" width="226" height="50" /></td>
    <td width="226"><img src="images/cartcount.jpg" width="226" height="50" /></td>
    <td width="186"><img src="images/cartntotal.jpg" width="226" height="50" /></td>
    <td width="241"><img src="images/cartprocess.jpg" width="226" height="50" /></td>
  </tr>
  <c:forEach items="${requestScope.orderLines }" var="orderLine">         
		<tr>
			<form method="post" action="" name="f1">
			<input type="hidden" name="productid" value="2">
			<input type="hidden" name="number" value="1">
			<td class=tablebody2 valign=middle align="center" width="">${orderLine.id }</td>
			<td class=tablebody1 valign=middle align="center" width=""><a href="cosmeticDetail?cosmeticId=${orderLine.id}">${orderLine.cosmeticName }</a></td>
			<td class=tablebody2 valign=middle align="center" width="">${orderLine.cosmeticPrice }</td>
			<td class=tablebody1 valign=middle align="center" width=""><input type="text" name="num" value="${orderLine.num }" size="4" /></td>
			<td class=tablebody2 valign=middle align="center" width="">&nbsp;&nbsp;${orderLine.total }元</td>
			<td class=tablebody1 valign=middle align="center" width="">
			</form>
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