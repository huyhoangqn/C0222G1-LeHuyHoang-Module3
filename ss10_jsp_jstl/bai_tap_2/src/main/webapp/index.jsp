<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 5/27/2022
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/cal" method="post">
    <table>
        <tr>
            <td>First operation:</td>
            <td>
                <input type="text" name="first">
            </td>
        </tr>
        <tr>
            <td>Operation:</td>
            <td>
                <select name="operation">
                    <option value="+">Add</option>
                    <option value="-">Sub</option>
                    <option value="*">Mul</option>
                    <option value="/">Div</option>
                </select>

            </td>
        </tr>
        <tr>
            <td>Second operation:</td>
            <td>
                <input type="text" name="second">
            </td>
        </tr>
        <tr>
            <td>Submit</td>
            <td>
                <button type="submit">Submit</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
