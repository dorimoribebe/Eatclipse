<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식당 정보</title>
</head>
<body>
<%@ include file="../include/menu_cust.jsp" %>
<h2>식당 이름이 나오게 해야함.</h2>
<h2>${shop_name}</h2>

<table border="1" width="700px">
   <tr>
      <th>메뉴</th>
      <th>가격</th>
      <th>수량</th>
  	  <th>장바구니???</th>
   </tr>
   
<%--    		<c:forEach var="row" items="${dto}">
			<tr>
                <td>${row.product_name}</td>
				<td>${row.price}</td>
			
				<td>
					<form name="form1" method="post" action="/eatclipse/customer/cart/insert.do">
				    <select name="amount">
                        <c:forEach begin="1" end="10" var="i">
                           <option value="${i}">${i}</option>
                        </c:forEach>
                     </select>&nbsp;개
                     <input type="submit" value="장바구니에 담기">
					</form>
				</td>
			</tr>
		</c:forEach> --%>



</table>



</body>
</html>