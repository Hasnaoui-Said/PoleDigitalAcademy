

<jsp:useBean id="userSession" class="next.pda.entity.Administrateur" scope="session"></jsp:useBean>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <ul class="container">
        <a class="navbar-brand" href="home">PDA</a>
        <div class="collapse navbar-collapse justify-content-between">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="activity">Activitie</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="exercise">Exercise</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="users">Users</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <div class="dropdown">
                        <button class="btn text-white dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <%= userSession.getEmail() %>
                        </button>
                        <ul class="dropdown-menu dropdown-menu-muted">
                            <li><a class="dropdown-item" href="profile">Profile</a></li>
                        </ul>
                    </div>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="logout">LogOut</a>
                </li>
            </ul>
        </div>
    </ul>
</nav>