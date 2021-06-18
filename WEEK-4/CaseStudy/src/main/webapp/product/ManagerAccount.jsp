
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Manager Product</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../Home/css/manager.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <script src="/Home/js/sweetalert2.min.js"></script>

    <link rel="stylesheet" href="/Home/css/sweetalert2.min.css">
    <style>
        img{
            width: 200px;
            height: 120px;
        }
        .active-cyan input[type=text] {
            border-bottom: 1px solid #4dd0e1;
            box-shadow: 0 1px 0 0 #4dd0e1;
        }
        .active-cyan .fa, .active-cyan-2 .fa {
            color: #4dd0e1;
        }
    </style>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Manager <b>Account</b></h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Account</span></a>
                    <form class="form-inline active-cyan-4" method="get">
                        <input type="hidden" name="action" value="search">
                        <input name="search" value="${key}" class="form-control form-control-sm mr-3 w-75" type="text" placeholder="Search"
                               aria-label="Search">
                        <input type="submit" value="Search" style="background-color: #5cb85c ; height: 35px ; border-radius: 2px">
                    </form>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${accountList}" var="account">
                <tr>
                    <td>${account.id}</td>
                    <td>${account.username}</td>
                    <td>${account.email}</td>
                    <td>
                        <a href="account?action=edit&id=${account.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                        <a href="#" class="delete" data-toggle="modal" ><i class="material-icons" data-toggle="tooltip" title="Delete" onclick="deleteAccount(${account.id})">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="clearfix">
            <ul class="pagination">
                <c:forEach begin="1" end="${endPage}" var="i">
                    <li class="page-item"><a href="account?index=${i}" class="page-link">${i}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <a href="/index"><button type="button" class="btn btn-primary">Back to home</button>
    </a>
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="account?action=create" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Username</label>
                        <input name="username" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input name="password" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input name="email" type="email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Staff</label>
                        <input name="isSell" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Admin</label>
                        <input name="isAdmin" type="text" class="form-control" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>


<script type="text/javascript">
    $(document).ready(function () {
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Select/Deselect checkboxes
        var checkbox = $('table tbody input[type="checkbox"]');
        $("#selectAll").click(function () {
            if (this.checked) {
                checkbox.each(function () {
                    this.checked = true;
                });
            } else {
                checkbox.each(function () {
                    this.checked = false;
                });
            }
        });
        checkbox.click(function () {
            if (!this.checked) {
                $("#selectAll").prop("checked", false);
            }
        });
    });
</script>
<script>
    const searchButton = document.getElementById('search-button');
    const searchInput = document.getElementById('search-input');
    searchButton.addEventListener('click', () => {
        const inputValue = searchInput.value;
        alert(inputValue);
    });
</script>
<script>
    function deleteAccount(id) {
        Swal.fire({
            title: 'Are you sure?',
            text: "Do you want to remove this account from the list!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire(
                    'Deleted!',
                    'The account has been removed from the list.',
                    'success'
                ).then(() => {
                    window.location.href = "/account?action=delete&id="+ id;
                })
            }
        })
    }
</script>
</body>
</html>