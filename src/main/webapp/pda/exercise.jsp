<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="next.pda.enu.StatusExercice" %>
<jsp:useBean id="exercises" type="java.util.ArrayList<next.pda.entity.Exercice>" scope="request"></jsp:useBean>

<div class="container">
    <div class="d-flex justify-content-end align-items-center m-4">
        <div>
            <button type="button" onclick="createExercise()" class="btn btn-primary"
                    <%= (request.getAttribute("edit") != null)? "disabled": ""  %> id="createActivity">
                Create Exercise
            </button>
        </div>
    </div>

    <% if (request.getAttribute("edit") != null) { %>
    <%@include file="editExercise.jsp" %>
    <% } else {%>
    <div class="" id="formCreateExercise" style="display: none">
        <div class="card p-4 mb-3">
            <div class="modal-body">
                <form action="exercise" method="post">
                    <div class="row">
                        <div class="col-6 mb-3">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" class="form-control" id="title" name="title" aria-describedby="titleHelp">
                            <div id="titleHelps" class="form-text d-none">error</div>
                        </div>
                        <div class="col-6 mb-3">
                            <label for="annee" class="form-label">Annee</label>
                            <input type="date" class="form-control" id="annee" name="annee" aria-describedby="anneeHelp">
                            <div id="anneeHelps" class="form-text d-none">error</div>
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
                            <label for="status" class="form-label">Status</label>
                            <select class="form-select" id="status" name="status" aria-label="Select a manager" aria-describedby="statusHelp">
                                <% for (StatusExercice status: StatusExercice.values()){%>
                                <option value="<%=status%>"><%=status%></option>
                                <% } %>
                            </select>
                            <div id="statusHelps" class="form-text d-none">error</div>
                        </div>
                    </div>
                    <div class="modal-footer mb-0">
                        <a href="exercise" class="nav-link btn btn-muted my-0 mx-5 p-0">Cancel</a>
                        <button type="submit" name="save" class="btn btn-primary">Save</button>
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
                <% for (StatusExercice status: StatusExercice.values()) {%>
                <li><a class="dropdown-item" href="?<%=status%>"><%=status%></a></li>
                <% } %>
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
                    <th scope="col">Annee</th>
                    <th scope="col">date debut</th>
                    <th scope="col">date fin</th>
                    <th scope="col">Status</th>
                    <th scope="col" colspan="2" class="text-end">Actions</th>
                </tr>
                </thead>
                <tbody class="table-group-divider">

                <% for (int i=0; i<exercises.size();i++){%>
                <tr>
                    <td><%=exercises.get(i).getExercice_id()%></td>
                    <td><%=exercises.get(i).getTitle()%></td>
                    <td><%=exercises.get(i).getAnnee()%></td>
                    <td><%=new SimpleDateFormat("yyyy-MM-dd").format(exercises.get(i).getDateDebut())%></td>
                    <td><%=exercises.get(i).getDateFin()%></td>
                    <td><%=exercises.get(i).getStatus()%></td>
                    <td class="d-flex gap-1 justify-content-between" colspan="2">
                        <div class="nav-item"><a class="nav-link" href="exercise?edit=<%=exercises.get(i).getExercice_id()%>"><span class="material-symbols-outlined">Edit</span></a></div>
                        <div class="nav-item"><a class="nav-link" href="exercise?delete=<%=exercises.get(i).getExercice_id()%>"><span class="material-symbols-outlined">Delete</span></a></div>
                        <div class="nav-item"><a class="nav-link" href="exercise?info=<%=exercises.get(i).getExercice_id()%>"><span class="material-symbols-outlined">info</span></a></div>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    function createExercise() {
        if (document.getElementById("formCreateExercise").style.display === "none")
            document.getElementById("formCreateExercise").style.display = "block";
        else
            document.getElementById("formCreateExercise").style.display = "none";
    }
</script>


