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
      <label>mo ta:</label>
      <input type="text" name="mota" placeholder="nhap mo ta san pham">
      <label>gia:</label>
      <input type="text" name="gia" placeholder="nhap gia niem yet">
      <label>ty le chiet khau</label>
      <input type="text" name="chietkhau" placeholder="nhap ty le chiet khau">
      <button type="submit">Tinh chiet khau</button>
    </div>
  </form>
  </body>
</html>
