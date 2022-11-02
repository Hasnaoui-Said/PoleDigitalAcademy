<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String username = request.getAttribute("username") == null ? "" : request.getAttribute("username").toString();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PDA - Login Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.2/css/bootstrap.min.css" integrity="sha512-CpIKUSyh9QX2+zSdfGP+eWLx23C8Dj9/XmHjZY2uDtfkdLGo0uY12jgcnkX9vXOgYajEKb/jiw67EYm+kBf+6g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            .container {
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
            }
        </style>
</head>
<body>
    <div class="container">
        <div class="card col-4 p-4">
            <div class="card-header bg-white">
                <h3 class="text-center">Login</h3>
            </div>
            <form action="login" method="post">
                <%if(request.getAttribute("message") != null)  {%>
                <div class="form-outline mb-4 mt-4 m-auto">
                    <small class="alert alert-danger mt-4"><%=request.getAttribute("message")%></small>
                </div>
                <%}%>
                <div class="form-outline mb-4 mt-4">
                    <label class="form-label" for="username">Username</label>
                    <input type="text" id="username" name="username" placeholder="username" class="form-control" value="<%=username%>" />
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div>

                <div class="row mb-4">
                <div class="col d-flex justify-content-center">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="remember" checked />
                        <label class="form-check-label" for="remember"> Remember me </label>
                    </div>
                </div>

                <div class="col">
                    <a href="#!">Forgot password?</a>
                </div>
                </div>
                <div class="d-grid ">
                    <button type="submit" class="btn btn-primary btn-block mb-4 text-center">Sign in</button>
                </div>

            </form>
        </div>
    </div>

</body>
</html>