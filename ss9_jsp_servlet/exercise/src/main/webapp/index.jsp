<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 5/26/2022
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/discount" method="post">
    <div>
      <label>Description:</label>
      <input type="text" name="description" placeholder="Enter description ">
      <label>gia:</label>
      <input type="text" name="price" placeholder="enter price">
      <label>Discount Price</label>
      <input type="text" name="discount" placeholder="enter discount">
      <button type="submit">Calculate</button>
    </div>
  </form>
  </body>
</html>
