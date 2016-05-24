<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
body{
	text-align: center;
	font-family: "幼圆";
	font-size: 24px;
	color: #72392c;
	}
</style>
</head>

<body>
<p><img src="images/order.jpg" width="1359" height="340" usemap="#Map" />
 <map name="Map" id="Map">
    <area shape="rect" coords="373,240,523,326" href="home.html" />
    <area shape="rect" coords="565,239,746,329" href="register.jsp" />
    <area shape="rect" coords="785,239,922,327" href="#" />
    <area shape="rect" coords="964,240,1097,325" href="listCosmetics.jsp" />
    <area shape="rect" coords="1134,243,1292,322" href="logoutServlet" />
  </map>
</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="1359">
  <tr>
    <td width="271"><img src="images/orderno.jpg" width="271" height="50" /></td>
    <td width="271"><img src="images/orderid.jpg" width="271" height="50" /></td>
    <td width="271"><img src="images/ordertotal.jpg" width="271" height="50" /></td>
    <td width="239"><img src="images/orderstate.jpg" width="271" height="50" /></td>
    <td width="283"><img src="images/orderhowpay.jpg" width="271" height="50" /></td>

  </tr>
  <c:forEach items="${requestScope.orderForms}" var="orderForm" varStatus="status">                
		<tr>
			<td class=tablebody2 valign=middle align="center" width="">${status.index}</td>
			<td class=tablebody1 valign=middle align="center" width="">${orderForm.id }</td>
			<td class=tablebody2 valign=middle align="center" width="">${orderForm.cost}元</td>
			<td class=tablebody1 valign=middle align="center" width="">pending</td>
			<td class=tablebody2 valign=middle align="center" width="">邮局汇款 </td>
		</tr>
		<tr>
		<td colspan="5"><input type="button" value="明细" onclick="javascript:window.location='listOrderLineServlet?orderFormId=${orderForm.id}';"></td>
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