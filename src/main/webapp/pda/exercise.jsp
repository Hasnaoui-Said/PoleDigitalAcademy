<jsp:useBean id="exercises" type="java.util.ArrayList<next.pda.entity.Exercice>" scope="request"></jsp:useBean>

<div class="container">
    <div class="d-flex justify-content-end align-items-center m-4">
        <div>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#createActivity">
                Create Exercise
            </button>
        </div>
    </div>

    <div class="">
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
                        <button type="submit" name="save" class="btn btn-primary">Save</button>
                    </div>
                </form>
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
                <button class="btn btn-primary shadow-none"><span class="material-symbols-outlined">search</span></button>
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
                    <th scope="col">date</th>
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
                    <td><%="titre"%></td>
                    <td><%=exercises.get(i).getAnnee()%></td>
                    <td><%=exercises.get(i).getDateDebut()%></td>
                    <td><%=exercises.get(i).getDateFin()%></td>
                    <td><%=exercises.get(i).getStatus()%></td>
                    <td class="d-flex gap-1 justify-content-between" colspan="2">
                        <div class="nav-item"><button class="btn btn-white p-0 m-0"  data-bs-toggle="modal" data-bs-target="#createActivity"><span class="material-symbols-outlined">Edit</span></button></div>
                        <div class="nav-item"><a class="nav-link" href="activity?delete=<%=exercises.get(i).getExercice_id()%>"><span class="material-symbols-outlined">Delete</span></a></div>
                        <div class="nav-item"><a class="nav-link" href="activity?info=<%=exercises.get(i).getExercice_id()%>"><span class="material-symbols-outlined">info</span></a></div>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>

</script>
<!-- Modal
<div class="modal fade" id="createActivity" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="1" aria-labelledby="createActivityLabel" aria-hidden="false">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="createActivityLabel">Create new Exercise</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="activity" method="post">
                    <div class="mb-3">
                        <label for="title" class="form-label">Title</label>
                        <input type="text" class="form-control" id="title" name="title" aria-describedby="titleHelp">
                        <div id="titleHelps" class="form-text d-none">error</div>
                    </div>
                    <div class="mb-3">
                        <label for="dateDebut" class="form-label">date debut</label>
                        <input type="date" class="form-control" id="dateDebut" name="dateDebut" aria-describedby="dateDebutHelp">
                        <div id="dateDebutHelps" class="form-text d-none">error</div>
                    </div>
                    <div class="mb-3">
                        <label for="dateFin" class="form-label">date fin</label>
                        <input type="date" class="form-control" id="dateFin" name="dateFin" aria-describedby="dateFinHelp">
                        <div id="dateFinHelps" class="form-text d-none">error</div>
                    </div>
                    <div class="mb-3">
                        <label for="description">Description</label>
                        <textarea class="form-control" placeholder="Leave a comment here" id="description" name="description"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="responsable" class="form-label">exercise</label>
                        <select class="form-select" id="responsable" name="responsable" aria-label="Select a manager" aria-describedby="responsableHelp">
                            <option selected></option>
                            <option value="1">responsable1</option>
                            <option value="2">responsable2</option>
                            <option value="3">responsable3</option>
                        </select>
                        <div id="responsableHelps" class="form-text d-none">error</div>
                    </div>
                    <div class="mb-3">
                        <label for="exercise" class="form-label">exercise</label>
                        <select class="form-select" multiple id="exercise" name="exercise" aria-label="Select a manager" aria-describedby="exerciseHelp">
                            <option selected disabled></option>
                            <option value="1">m1</option>
                            <option value="2">m2</option>
                            <option value="3">m3</option>
                        </select>
                        <div id="exerciseHelps" class="form-text d-none">error</div>
                    </div>
                    <div class="modal-footer mb-0">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" name="save" class="btn btn-primary">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
-->