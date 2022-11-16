<%@ page import="next.pda.enu.Roles" %>
<jsp:useBean id="usersList" type="java.util.ArrayList<next.pda.entity.User>" scope="request"></jsp:useBean>

<div class="container">
    <div class="d-flex justify-content-end align-items-center m-4">
        <div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Add
                </button>
                <ul class="dropdown-menu dropdown-menu-muted">
                    <li><a class="dropdown-item" href="responsable?add">Responsable</a></li>
                    <li><a class="dropdown-item" href="participant?add">Participant</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="d-flex justify-content-end align-items-center gap-2 mx-4">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                Status
            </button>
            <ul class="dropdown-menu dropdown-menu-muted">
                <li><a class="dropdown-item" href="#">Active</a></li>
                <li><a class="dropdown-item" href="#">Inactive</a></li>
            </ul>
        </div>
        <div class="input-group">
            <div class="form-outline btn-group" role="group">
                <input type="search" class="form-control" />
                <button class="btn btn-primary shadow-none">
                    <span class="material-symbols-outlined">search</span>
                </button>
            </div>
        </div>
    </div>
    <div class="card p-4 m-4">
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Email</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Status</th>
                    <th scope="col">Role</th>
                    <th scope="col" colspan="2" class="text-end">Actions</th>
                </tr>
                </thead>
                <tbody class="table-group-divider">

                <% for (int i=0; i<usersList.size();i++){%>
                <tr>
                    <td><%=usersList.get(i).getId()%></td>
                    <td><%=usersList.get(i).getEmail()%></td>
                    <td><%=usersList.get(i).getFirstName()%></td>
                    <td><%=usersList.get(i).getLastName()%></td>
                    <td><%=usersList.get(i).getPhone()%></td>
                    <td class="text-center">
                        <p class="rounded-3 border
                            <%if (usersList.get(i).isIs_active() == false) {%> border-danger<%}%>
                            <%if (usersList.get(i).isIs_active() == true) {%> border-success <%}%>
                            bg-gradient p-1"><%=usersList.get(i).isIs_active()?"Active":"Inactive"%>
                        </p>
                    </td>
                    <td class="text-center">
                        <p class="rounded-3
                            <%if (usersList.get(i).getRole() == Roles.ADMIN) {%> bg-danger<%}%>
                            <%if (usersList.get(i).getRole() == Roles.RESPONSABLE) {%> bg-success <%}%>
                            <%if (usersList.get(i).getRole() == Roles.PARTICIPANT) {%> bg-warning <%}%>
                            bg-gradient p-1"><%=usersList.get(i).getRole()%>
                        </p>
                    </td>
                    <td class="d-flex gap-1 justify-content-between" colspan="2">
                        <div class="nav-item"><a class="nav-link" href="activity?edit=<%=usersList.get(i).getId()%>"><span class="material-symbols-outlined">Edit</span></a></div>
                        <div class="nav-item"><a class="nav-link" href="activity?delete=<%=usersList.get(i).getId()%>"><span class="material-symbols-outlined">Delete</span></a></div>
                        <div class="nav-item"><a class="nav-link" href="activity?info=<%=usersList.get(i).getId()%>"><span class="material-symbols-outlined">info</span></a></div>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>



