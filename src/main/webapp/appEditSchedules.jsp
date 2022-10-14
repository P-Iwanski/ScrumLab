<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="/fragments/meta.jsp" %>
</head>

<body>
    <header class="page-header">
        <nav class="navbar navbar-expand-lg justify-content-between">
            <a href="/" class="navbar-brand main-logo main-logo-smaller">
                Zaplanuj <span>Jedzonko</span>
            </a>
         <div class="d-flex justify-content-around">
             <h4 class="text-light mr-3">${name}</h4>
             <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
         </div>
        </nav>
    </header>

    <section class="dashboard-section">
        <div class="row dashboard-nowrap">
                <ul class="nav flex-column long-bg">
                        <li class="nav-item">
                            <a class="nav-link" href="/dashboard">
                                <span>Pulpit</span>
                                <i class="fas fa-angle-right"></i>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/app/recipe/list">
                                <span>Przepisy</span>
                                <i class="fas fa-angle-right"></i>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/app/plan/list">
                                <span>Plany</span>
                                <i class="fas fa-angle-right"></i>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/app-edit-user-data.html">
                                <span>Edytuj dane</span>
                                <i class="fas fa-angle-right"></i>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="/app-edit-password.html">
                                <span>Zmień hasło</span>
                                <i class="fas fa-angle-right"></i>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/super-admin-users.html">
                                <span>Użytkownicy</span>
                                <i class="fas fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>


            <div class="m-4 p-3 width-medium">
                <div class="dashboard-content border-dashed p-3 m-4 view-height">
                    <!-- fix action, method -->
                    <!-- add name attribute for all inputs -->
                    <form method="post">
                    <div class="row border-bottom border-3 p-1 m-1">
                        <div class="col noPadding">
                            <h3 class="color-header text-uppercase">NOWY PLAN</h3>
                        </div>
                        <div class="col d-flex justify-content-end mb-2">
                            <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
                        </div>
                    </div>

                    <div class="schedules-content">

                            <div class="form-group row">
                                <label for="planName" class="col-sm-2 label-size col-form-label">
                                    Nazwa planu
                                </label>
                                <div class="col-sm-10">
                                    <input class="form-control" name = "planName" id="planName" value="${plan.name}" placeholder="Nazwa planu">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="planDescription" class="col-sm-2 label-size col-form-label">
                                    Opis planu
                                </label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" name="planDescription" id="planDescription" ><c:out value="${plan.description}" />
                                    </textarea>
                                </div>
                            </div>

                    </div>
                    </form>
                </div>
            </div>
        </div>
    </section>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>