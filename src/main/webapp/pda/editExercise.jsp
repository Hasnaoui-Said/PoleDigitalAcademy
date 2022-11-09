<% int id=(Integer) request.getAttribute("edit"); %>
<jsp:useBean id="exercise" class="next.pda.entity.Exercice" scope="request"></jsp:useBean>
<div class="" id="formUpdateActivity">
    <div class="card p-4 mb-3">
        <div class="modal-body">
            <div class="modal-body">
                <form action="exercise?update=<%=id%>" method="post">
                    <div class="row">
                        <div class="col-6 mb-3 d-none">
                            <label for="id" class="form-label">id</label>
                            <input type="text" class="form-control" id="id" value="<%=exercise.getExercice_id()%>" name="id" aria-describedby="idHelp">
                            <div id="idHelps" class="form-text d-none">error</div>
                        </div>
                        <div class="col-6 mb-3">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" class="form-control" id="title" name="title" aria-describedby="titleHelp">
                            <div id="titleHelps" class="form-text d-none">error</div>
                        </div>
                        <div class="col-6 mb-3">
                            <label for="annee" class="form-label">Annee</label>
                            <input type="date" class="form-control" id="annee" value="<%=exercise.getAnnee()%>" name="annee" aria-describedby="anneeHelp">
                            <div id="anneeHelps" class="form-text d-none">error</div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6 mb-3">
                            <label for="dateDebut" class="form-label">date debut</label>
                            <input type="date" class="form-control" id="dateDebut" value="<%=exercise.getDateDebut()%>" name="dateDebut" aria-describedby="dateDebutHelp">
                            <div id="dateDebutHelps" class="form-text d-none">error</div>
                        </div>
                        <div class="col-6 mb-3">
                            <label for="dateFin" class="form-label">date fin</label>
                            <input type="date" class="form-control" id="dateFin" value="<%=exercise.getDateFin()%>" name="dateFin" aria-describedby="dateFinHelp">
                            <div id="dateFinHelps" class="form-text d-none">error</div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6 mb-3">
                            <label for="status" class="form-label">Status</label>
                            <select class="form-select" id="status" name="status" aria-label="Select a manager" aria-describedby="statusHelp">
                                <option selected></option>
                                <option value="1">status1</option>
                                <option value="2">status2</option>
                                <option value="3">status3</option>
                            </select>
                            <div id="statusHelps" class="form-text d-none">error</div>
                        </div>
                    </div>
                    <div class="modal-footer mb-0">
                        <button type="submit" name="update" class="btn btn-warning">Update</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>