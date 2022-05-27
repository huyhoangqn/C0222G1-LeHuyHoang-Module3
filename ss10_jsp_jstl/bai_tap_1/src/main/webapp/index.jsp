<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 5/27/2022
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table border="1" width="500px">
    <tr>
      <th>No.</th>
      <th>Customer's name</th>
      <th>Customer's birthday</th>
      <th>Customer's addresss</th>
      <th>Customer's picture</th>
    </tr>
    <c:forEach items="${listCustomer}" var="customers" varStatus="counts">
      <tr>
        <td>${counts.count}</td>
        <td>${customers.name}</td>
        <td>${customers.birthday}</td>
        <td>${customers.address}</td>
        <td>
          <img src="${customers.img}" alt="img-customer">
        </td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
