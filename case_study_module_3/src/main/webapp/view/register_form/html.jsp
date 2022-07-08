<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Create Account</h2>
    </div>
    <form id="form" class="form">
        <div class="form-control">
            <label for="username">Username</label>
            <input type="text" placeholder="florinpop17" id="username"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="username">Email</label>
            <input type="email" placeholder="a@florin-pop.com" id="email"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="username">Password</label>
            <input type="password" placeholder="Password" id="password"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="username">Password check</label>
            <input type="password" placeholder="Password two" id="password2"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <button>Submit</button>
    </form>
</div>
</body>
<script src="js.js"></script>
</html>
