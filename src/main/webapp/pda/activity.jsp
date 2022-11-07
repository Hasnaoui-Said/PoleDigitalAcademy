<%@ page import="java.text.SimpleDateFormat" %>
<jsp:useBean id="activities" type="java.util.ArrayList<next.pda.entity.Activity>" scope="request"></jsp:useBean>

<div class="container">
    <div class="d-flex justify-content-end align-items-center m-4">
        <div>
            <button type="button" onclick="createActivity()" class="btn btn-primary"
                    <%= (request.getAttribute("edit") != null)? "disabled": ""  %> id="createActivity">
                Create Activity
            </button>
        </div>
    </div>

    <% if (request.getAttribute("edit") != null) { %>
        <%@include file="editActivity.jsp" %>
    <% } else {%>
    <div class="" id="formCreateActivity" style="display: none">
        <div class="card p-4 mb-3">
            <div class="modal-body">
                <form action="activity" method="post">
                    <div class="row">
                        <div class="col-6 mb-3">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" class="form-control" id="title" name="title" aria-describedby="titleHelp">
                            <div id="titleHelps" class="form-text d-none">error</div>
                        </div>
                        <div class="col-6 mb-3">
                            <label for="description">Description</label>
                            <textarea class="form-control" placeholder="Leave a comment here" id="description" name="description"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6 mb-3">
                            <label for="dateDebut" class="form-label">date debut</label>
                            <input type="date" class="form-control" id="dateDebut" name="dateDebut" aria-describedby="dateDebutHelp">
                            <div id="dateDebutHelps" class="form-text d-none">error</div>
                        </div>
                        <div class="col-6 mb-3">
                            <label for="dateFin" class="form-label">date fin</label>
                            <input type="date" class="form-control" id="dateFin" name="dateFin" aria-describedby="dateFinHelp">
                            <div id="dateFinHelps" class="form-text d-none">error</div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6 mb-3">
                            <label for="exercise" class="form-label">exercise</label>
                            <select class="form-select" multiple id="exercise" name="exercise" aria-label="Select a manager" aria-describedby="exerciseHelp">
                                <option selected disabled></option>
                                <option value="1">m1</option>
                                <option value="2">m2</option>
                                <option value="3">m3</option>
                            </select>
                            <div id="exerciseHelps" class="form-text d-none">error</div>
                        </div>
                        <div class="col-6 mb-3">
                            <label for="responsable" class="form-label">responsable</label>
                            <select class="form-select" id="responsable" name="responsable" aria-label="Select a manager" aria-describedby="responsableHelp">
                                <option selected></option>
                                <option value="1">responsable1</option>
                                <option value="2">responsable2</option>
                                <option value="3">responsable3</option>
                            </select>
                            <div id="responsableHelps" class="form-text d-none">error</div>
                        </div>
                    </div>
                    <div class="modal-footer mb-0">
                        <button type="submit" name="update" class="btn btn-primary">Update</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <% }%>
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
                    <th scope="col">Title</th>
                    <th scope="col">Desc</th>
                    <th scope="col">date debut</th>
                    <th scope="col">date fin</th>
                    <th scope="col">Status</th>
                    <th scope="col" colspan="2" class="text-end">Actions</th>
                </tr>
                </thead>
                <tbody class="table-group-divider">

                <% for (int i=0; i<activities.size();i++){%>
                    <tr>
                        <td><%=activities.get(i).getId()%></td>
                        <td><%=activities.get(i).getTitle()%></td>
                        <td><%=activities.get(i).getDescription()%></td>
                        <td><%=new SimpleDateFormat("yyyy-MM-dd").format(activities.get(i).getDateDebut())%></td>
                        <td><%=activities.get(i).getDateFin()%></td>
                        <td><%=activities.get(i).getEtat()%></td>
                        <td class="d-flex gap-1 justify-content-between" colspan="2">
                            <div class="nav-item"><a class="nav-link" href="activity?edit=<%=activities.get(i).getId()%>"><span class="material-symbols-outlined">Edit</span></a></div>
                            <div class="nav-item"><a class="nav-link" href="activity?delete=<%=activities.get(i).getId()%>"><span class="material-symbols-outlined">Delete</span></a></div>
                            <div class="nav-item"><a class="nav-link" href="activity?info=<%=activities.get(i).getId()%>"><span class="material-symbols-outlined">info</span></a></div>
                        </td>
                    </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    function createActivity() {
        if (document.getElementById("formCreateActivity").style.display === "none")
            document.getElementById("formCreateActivity").style.display = "block";
        else
            document.getElementById("formCreateActivity").style.display = "none";
    }
</script>


