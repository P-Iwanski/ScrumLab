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
                <a class="nav-link" href="/app/dashboard">
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

        <div class="m-4 p-4 width-medium">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <a href="/app/recipe/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj przepis</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app/plan/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title" >dodaj plan</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app/recipe/plan/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj przepis do planu</span>
                        </a>
                    </div>
                </div>

                <div class="dashboard-alerts">
                    <div class="alert-item alert-info">
                        <i class="fas icon-circle fa-info-circle"></i>
                        <span class="font-weight-bold">${numberOfRecipes} przepisów</span>
                    </div>
                    <div class="alert-item alert-light">
                        <i class="far icon-calendar fa-calendar-alt"></i>
                        <span class="font-weight-bold">${numberOfPlans} planów</span>
                    </div>
                </div>
            </div>
            <div class="m-4 p-4 border-dashed">
                <h2 class="dashboard-content-title">
                    <span>Ostatnio dodany plan:</span> ${nameOfLastPlan}
                </h2>

                        <table class="table">
                            <thead>
                            <tr class="d-flex">
                                <th class="col-2">Poniedziałek</th>
                                <th class="col-8"></th>
                                <th class="col-2"></th>
                            </tr>
                            </thead>
                            <c:forEach var="item" items="${arrayOfLastPlan}">
                            <c:if test="${item.dayName.equals('poniedziałek')}">
                            <tbody>
                            <tr class="d-flex">
                                <td class="col-2">${item.mealName}</td>
                                <td class="col-8">${item.recipeName}</td>
                                <td class="col-2">
                                    <a href='<c:url value="/app/recipe/details?id=${item.recipeId}"/>' class="btn btn-primary rounded-0">Szczegóły</a>
                                </td>
                            </tr>
                            </tbody>
                            </c:if>
                            </c:forEach>
                        </table>


                <table class="table">
                    <thead>
                    <tr class="d-flex">
                        <th class="col-2">Wtorek</th>
                        <th class="col-8"></th>
                        <th class="col-2"></th>
                    </tr>
                    </thead>
                    <c:forEach var="item" items="${arrayOfLastPlan}">
                        <c:if test="${item.dayName.equals('wtorek')}">
                            <tbody>
                            <tr class="d-flex">
                                <td class="col-2">${item.mealName}</td>
                                <td class="col-8">${item.recipeName}</td>
                                <td class="col-2">
                                    <a href='<c:url value="/app/recipe/details?id=${item.recipeId}"/>' class="btn btn-primary rounded-0">Szczegóły</a>
                                </td>
                            </tr>
                            </tbody>
                        </c:if>
                    </c:forEach>
                </table>
                        <table class="table">
                            <thead>
                            <tr class="d-flex">
                                <th class="col-2">Środa</th>
                                <th class="col-8"></th>
                                <th class="col-2"></th>
                            </tr>
                            </thead>
                            <c:forEach var="item" items="${arrayOfLastPlan}">
                                <c:if test="${item.dayName.equals('środa')}">
                            <tbody>
                            <tr class="d-flex">
                                <td class="col-2">${item.mealName}</td>
                                <td class="col-8">${item.recipeName}</td>
                                <td class="col-2">
                                    <a href='<c:url value="/app/recipe/details?id=${item.recipeId}"/>' class="btn btn-primary rounded-0">Szczegóły</a>
                                </td>
                            </tr>
                            </tbody>
                            </c:if>
                            </c:forEach>
                        </table>

                <table class="table">
                    <thead>
                    <tr class="d-flex">
                        <th class="col-2">Czwartek</th>
                        <th class="col-8"></th>
                        <th class="col-2"></th>
                    </tr>
                    </thead>
                    <c:forEach var="item" items="${arrayOfLastPlan}">
                        <c:if test="${item.dayName.equals('czwartek')}">
                            <tbody>
                            <tr class="d-flex">
                                <td class="col-2">${item.mealName}</td>
                                <td class="col-8">${item.recipeName}</td>
                                <td class="col-2">
                                    <a href='<c:url value="/app/recipe/details?id=${item.recipeId}"/>' class="btn btn-primary rounded-0">Szczegóły</a>
                                </td>
                            </tr>
                            </tbody>
                        </c:if>
                    </c:forEach>
                </table>
                <table class="table">
                    <thead>
                    <tr class="d-flex">
                        <th class="col-2">Piątek</th>
                        <th class="col-8"></th>
                        <th class="col-2"></th>
                    </tr>
                    </thead>
                    <c:forEach var="item" items="${arrayOfLastPlan}">
                        <c:if test="${item.dayName.equals('piątek')}">
                            <tbody>
                            <tr class="d-flex">
                                <td class="col-2">${item.mealName}</td>
                                <td class="col-8">${item.recipeName}</td>
                                <td class="col-2">
                                    <a href='<c:url value="/app/recipe/details?id=${item.recipeId}"/>' class="btn btn-primary rounded-0">Szczegóły</a>
                                </td>
                            </tr>
                            </tbody>
                        </c:if>
                    </c:forEach>
                </table>
                <table class="table">
                    <thead>
                    <tr class="d-flex">
                        <th class="col-2">Sobota</th>
                        <th class="col-8"></th>
                        <th class="col-2"></th>
                    </tr>
                    </thead>
                    <c:forEach var="item" items="${arrayOfLastPlan}">
                        <c:if test="${item.dayName.equals('sobota')}">
                            <tbody>
                            <tr class="d-flex">
                                <td class="col-2">${item.mealName}</td>
                                <td class="col-8">${item.recipeName}</td>
                                <td class="col-2">
                                    <a href='<c:url value="/app/recipe/details?id=${item.recipeId}"/>' class="btn btn-primary rounded-0">Szczegóły</a>
                                </td>
                            </tr>
                            </tbody>
                        </c:if>
                    </c:forEach>
                </table>
                <table class="table">
                    <thead>
                    <tr class="d-flex">
                        <th class="col-2">Niedziela</th>
                        <th class="col-8"></th>
                        <th class="col-2"></th>
                    </tr>
                    </thead>
                    <c:forEach var="item" items="${arrayOfLastPlan}">
                        <c:if test="${item.dayName.equals('niedziela')}">
                            <tbody>
                            <tr class="d-flex">
                                <td class="col-2">${item.mealName}</td>
                                <td class="col-8">${item.recipeName}</td>
                                <td class="col-2">
                                    <a href='<c:url value="/app/recipe/details?id=${item.recipeId}"/>' class="btn btn-primary rounded-0">Szczegóły</a>
                                </td>
                            </tr>
                            </tbody>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>