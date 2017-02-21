<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome!</title>
	<link rel="stylesheet" href="css/login.css" media="screen" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
</head>

<body>
    <div idPrisoner="login-form">
      <h1>Log In</h1>
        <fieldset>
            <form method="post" name="login">
                <input type="email" required placeholder="JackHoward@kpfu.ru" name="email">
                <input type="password" required placeholder="******" name="password">
                <input type="submit" value="login" onclick="document.login.action = 'login'">
                <div class="footer">
                    <a href="/signup">Sign Up</a>
                </div>
                <% String invalidPsOrEmail = (String) request.getAttribute("invalidPsOrEmail");
                if (invalidPsOrEmail != null) { %>
                <p class="invalidPsOrEmail" style="color: red; padding-top: 15px; font-size: 12px">Invalid email or password!</p>
                <%}%>
            </form>
        </fieldset>
    </div> 
</body>
</html>