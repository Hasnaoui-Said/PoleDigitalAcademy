<div class="container m-3">
    <div class="card p-4">
        <div class="modal-body">
            <form action="participant" method="post">
                <div class="row">
                    <div class="col-6 mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp">
                        <div id="emailHelps" class="form-text d-none">error</div>
                    </div>
                </div>
                <div class="modal-footer mb-0">
                    <button type="submit" name="save" class="btn btn-primary">save</button>
                </div>
            </form>
        </div>
    </div>
</div>