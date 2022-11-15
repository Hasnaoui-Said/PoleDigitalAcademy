<% int id=(Integer) request.getAttribute("edit"); %>
<jsp:useBean id="activity" class="next.pda.entity.Activity" scope="request"></jsp:useBean>
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
                            <option disabled selected></option>
                            <option value="1">responsable1</option>
                            <option value="2">responsable2</option>
                            <option value="3">responsable3</option>
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