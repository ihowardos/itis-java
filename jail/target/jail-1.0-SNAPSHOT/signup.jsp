<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="css/signup.css" media="screen" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
</head>

<body>
<div idPrisoner="login-form">
    <h1>Sign Up</h1>
    <fieldset>
        <form method="post" name="signup">
            <input type="text" name="firstname" placeholder="Jack" name="firstname" maxlength="50">
            <input type="text" name="lastname" placeholder="Howard" name="lastname" maxlength="50" style="border-radius: 0px 0px 0px 0px; -moz-border-radius: 0px 0px 0px 0px; -webkit-border-radius: 0px 0px 0px 0px;">
            <input type="email" required placeholder="JackHoward@kpfu.ru" name="email" maxlength="50">
            <input type="password" required placeholder="******" idPrisoner="pass" name="password" minlength="6">
            <input type="password" required placeholder="******" idPrisoner="repPass">
            <input type="date" required name="date">
            <input type="submit" value="signup" idPrisoner="submit" onclick="document.signup.action='signup'">
            <div class="footer">
                <a href="/login">I have an account</a>
            </div>
            <% String emailBusy = (String) request.getAttribute("emailBusy"); %>
            <% if (emailBusy != null) { %>
            <p class="invalidPsOrEmail" style="color: red; padding-top: 15px; font-size: 12px"><%= emailBusy%></p>
            <%}%>
        </form>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var pass1 = document.querySelector('#pass'),
                        pass2 = document.querySelector('#repPass'),
                        submit = document.querySelector('#submit');
                pass1.addEventListener('input', function () {
                    this.value != pass2.value ? pass2.setCustomValidity('Password mismatch') : pass2.setCustomValidity('');
                })
                pass2.addEventListener('input', function (e) {
                    this.value != pass1.value ? this.setCustomValidity('Password mismatch') : this.setCustomValidity('');
                    !pass2.checkValidity() && submit.click();
                })
                submit.addEventListener('click', function (e) {
                    pass1.value == '' && e.preventDefault();
                })
            })
        </script>
    </fieldset>
</div>
</body>
</html>