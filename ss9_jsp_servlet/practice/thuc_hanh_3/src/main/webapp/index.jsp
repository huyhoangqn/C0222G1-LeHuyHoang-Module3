<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 5/26/2022
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/convert" method="get">
    <div>
      <h1>Currency Convert</h1>
      <label>rate: </label>
      <input type="text" name="rate" value="${rates}">
      <label>USD: </label>
      <input type="text" name="usd" value="${usds}">
      <button type="submit">tinh</button>
      <p>Result: ${converts}</p>
    </div>
  </form>
  </body>
</html>
