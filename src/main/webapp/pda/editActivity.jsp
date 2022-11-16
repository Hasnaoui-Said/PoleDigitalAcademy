<%@ page import="java.util.stream.Collectors" %>
<% int id=(Integer) request.getAttribute("edit"); %>
<jsp:useBean id="activity" class="next.pda.entity.Activity" scope="request"></jsp:useBean>
<jsp:useBean id="responsablesListEdit" type="java.util.ArrayList<next.pda.entity.Responsable>" scope="request"></jsp:useBean>
<jsp:useBean id="exercisesListEdit" type="java.util.ArrayList<next.pda.entity.Exercice>" scope="request"></jsp:useBean>

<%
    List<Long> getActEx_id = activity.getExercices().stream().map(ex -> ex.getExercice_id()).collect(Collectors.toList());
%>
<div class="" id="formUpdateActivity">
    <div class="card p-4 mb-3">
        <div class="modal-body">
            <form action="activity?update=<%=id%>" method="post">
                <div class="row">
                    <div class="col-6 mb-3 d-none">
                        <label for="id" class="form-label">id</label>
                        <input type="text" class="form-control" id="id" name="id" value="<%=activity.getId()%>" aria-describedby="idHelp">
                        <div id="idHelps" class="form-text d-none">error</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 mb-3">
                        <label for="title" class="form-label">Title</label>
                        <input type="text" class="form-control" id="title" value="<%=activity.getTitle()%>"  name="title" aria-describedby="titleHelp">
                        <div id="titleHelps" class="form-text d-none">error</div>
                    </div>
                    <div class="col-6 mb-3">
                        <label for="description">Description</label>
                        <textarea class="form-control" placeholder="Leave a comment here" id="description" name="description"><%=activity.getDescription()%> </textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 mb-3">
                        <label for="dateDebut" class="form-label">date debut</label>
                        <input type="date" class="form-control" id="dateDebut"  value="<%=activity.getDateDebut()%>" name="dateDebut" aria-describedby="dateDebutHelp">
                        <div id="dateDebutHelps" class="form-text d-none">error</div>
                    </div>
                    <div class="col-6 mb-3">
                        <label for="dateFin" class="form-label">date fin</label>
                        <input type="date" class="form-control" id="dateFin"  value="<%=activity.getDateFin()%>"  name="dateFin" aria-describedby="dateFinHelp">
                        <div id="dateFinHelps" class="form-text d-none">error</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 mb-3">
                        <label for="type" class="form-label">Type</label>

                        <select class="form-select" id="type" name="type" aria-label="Select a manager" aria-describedby="typeHelp">
                            <option disabled selected></option>
                            <% for (TypesActivity type: TypesActivity.values()){%>
                            <option <%= (type == activity.getType())? "selected": "" %> value="<%=type%>"><%=type%></option>
                            <% } %>
                        </select>
                        <div id="typeHelps" class="form-text d-none">error</div>
                    </div>
                    <div class="col-6 mb-3">
                        <label for="status" class="form-label">Status</label>
                        <select class="form-select" id="status" name="status" aria-label="Select a manager" aria-describedby="statusHelp">
                            <option value="True" selected>True</option>
                            <option value="false">False</option>
                        </select>
                        <div id="statusHelps" class="form-text d-none">error</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 mb-3">
                        <label for="exercises" class="form-label">exercises</label>
                        <select class="form-select" multiple id="exercises" name="exercises" aria-label="Select a manager" aria-describedby="exercisesHelp">
                            <option disabled selected></option>
                            <% for (Exercice exercice: exercisesListEdit ) {%>
                            <option value="<%=exercice.getExercice_id()%>"
                                    <%=(getActEx_id.contains(exercice.getExercice_id()) == true)? "selected": ""%>
                            ><%=exercice.getExercice_id()%> - <%=exercice.getTitle()%></option>
                            <% } %>
                        </select>
                        <div id="exercisesHelps" class="form-text d-none">error</div>
                    </div>
                    <div class="col-6 mb-3">
                        <label for="responsable" class="form-label">responsable</label>
                        <select class="form-select" id="responsable" name="responsable" aria-label="Select a manager" aria-describedby="responsableHelp">
                            <option disabled selected></option>
                            <% for (Responsable resp: responsablesListEdit ) {%>
                            <option value="<%=resp.getId()%>"
                                    <%=(activity.getResponsables() != null && resp.getId() == activity.getResponsables().getId())? "selected": ""%>
                            ><%=resp.getId() + " - " + resp.getFirstName() + " "+resp.getLastName()%></option>
                            <% } %>
                        </select>
                        <div id="responsableHelps" class="form-text d-none">error</div>
                    </div>
                </div>
                <div class="modal-footer mb-0 mt-4">
                    <a href="activity" class="nav-link btn btn-muted my-0 mx-5 p-0">Cancel</a>
                    <button type="submit" name="update" class="btn btn-warning">update</button>
                </div>
            </form>
        </div>
    </div>
</div>