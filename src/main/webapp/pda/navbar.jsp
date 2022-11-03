
<jsp:useBean id="userSession" class="next.pda.entity.User" scope="session"></jsp:useBean>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <ul class="container">
        <a class="navbar-brand" href="#">PDA</a>
        <div class="collapse navbar-collapse justify-content-between">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="activitie">Activitie</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="pda/v1/Exercice">Exercice</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="pda/v1/Users">Users</a>
                </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <div class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="pda/v1/profile"><%= userSession.getFirstName() %></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="pda/v1/logout?u=said">LogOut</a>
                    </li>
                </div>
            </ul>
        </div>
    </ul>
</nav>