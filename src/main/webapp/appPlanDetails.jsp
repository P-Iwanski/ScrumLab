<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="/fragments/meta.jsp" %>
    <title>Plan Details</title>
</head>

<body>
<%@ include file="/fragments/appMenuAndHeader.jsp" %>

<div class="m-4 p-3 width-medium ">
    <div class="dashboard-content border-dashed p-3 m-4">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">SZCZEGÓŁY PLANU</h3>
            </div>
            <div class="col d-flex justify-content-end mb-2 noPadding">
                <a href="/app/plan/list" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
            </div>
        </div>

        <div class="schedules-content">
            <div class="schedules-content-header">
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Nazwa planu
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">${plan.name}</p>
                    </div>
                </div>
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Opis planu
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">${plan.description}</p>
                    </div>
                </div>
            </div>


            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Poniedziałek</th>
                    <th class="col-7"></th>
                    <th class="col-1"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="recipe" items="${recipePlan}">
                    <c:if test="${recipe.dayName.equals('poniedziałek')}">
                        <tbody class="text-color-lighter">
                        <tr class="d-flex">
                            <td class="col-2">${recipe.mealName}</td>
                            <td class="col-7">${recipe.recipeName}</td>
                            <td class="col-1 center">
                                <a href='<c:url value="/app/plan/details/delete?id=${recipe.recipeId}"/>' class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Czy na pewno chcesz usunąć przepis z planu?')">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href='<c:url value="/app/recipe/details?id=${recipe.recipeId}"/>'
                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
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
                    <th class="col-7"></th>
                    <th class="col-1"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="recipe" items="${recipePlan}">
                    <c:if test="${recipe.dayName.equals('wtorek')}">
                        <tbody class="text-color-lighter">
                        <tr class="d-flex">
                            <td class="col-2">${recipe.mealName}</td>
                            <td class="col-7">${recipe.recipeName}</td>
                            <td class="col-1 center">
                                <a href='<c:url value="/app/plan/details/delete?id=${recipe.recipeId}"/>' class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Czy na pewno chcesz usunąć przepis z planu?')">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href='<c:url value="/app/recipe/details?id=${recipe.recipeId}"/>'
                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
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
                    <th class="col-7"></th>
                    <th class="col-1"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="recipe" items="${recipePlan}">
                    <c:if test="${recipe.dayName.equals('środa')}">
                        <tbody class="text-color-lighter">
                        <tr class="d-flex">
                            <td class="col-2">${recipe.mealName}</td>
                            <td class="col-7">${recipe.recipeName}</td>
                            <td class="col-1 center">
                                <a href='<c:url value="/app/plan/details/delete?id=${recipe.recipeId}"/>' class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Czy na pewno chcesz usunąć przepis z planu?')">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href='<c:url value="/app/recipe/details?id=${recipe.recipeId}"/>'
                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
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
                    <th class="col-7"></th>
                    <th class="col-1"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="recipe" items="${recipePlan}">
                    <c:if test="${recipe.dayName.equals('czwartek')}">
                        <tbody class="text-color-lighter">
                        <tr class="d-flex">
                            <td class="col-2">${recipe.mealName}</td>
                            <td class="col-7">${recipe.recipeName}</td>
                            <td class="col-1 center">
                                <a href='<c:url value="/app/plan/details/delete?id=${recipe.recipeId}"/>' class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Czy na pewno chcesz usunąć przepis z planu?')">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href='<c:url value="/app/recipe/details?id=${recipe.recipeId}"/>'
                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
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
                    <th class="col-7"></th>
                    <th class="col-1"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="recipe" items="${recipePlan}">
                    <c:if test="${recipe.dayName.equals('piątek')}">
                        <tbody class="text-color-lighter">
                        <tr class="d-flex">
                            <td class="col-2">${recipe.mealName}</td>
                            <td class="col-7">${recipe.recipeName}</td>
                            <td class="col-1 center">
                                <a href='<c:url value="/app/plan/details/delete?id=${recipe.recipeId}"/>' class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Czy na pewno chcesz usunąć przepis z planu?')">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href='<c:url value="/app/recipe/details?id=${recipe.recipeId}"/>'
                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
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
                    <th class="col-7"></th>
                    <th class="col-1"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="recipe" items="${recipePlan}">
                    <c:if test="${recipe.dayName.equals('sobota')}">
                        <tbody class="text-color-lighter">
                        <tr class="d-flex">
                            <td class="col-2">${recipe.mealName}</td>
                            <td class="col-7">${recipe.recipeName}</td>
                            <td class="col-1 center">
                                <a href='<c:url value="/app/plan/details/delete?id=${recipe.recipeId}"/>' class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Czy na pewno chcesz usunąć przepis z planu?')">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href='<c:url value="/app/recipe/details?id=${recipe.recipeId}"/>'
                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
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
                    <th class="col-7"></th>
                    <th class="col-1"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="recipe" items="${recipePlan}">
                    <c:if test="${recipe.dayName.equals('niedziela')}">
                        <tbody class="text-color-lighter">
                        <tr class="d-flex">
                            <td class="col-2">${recipe.mealName}</td>
                            <td class="col-7">${recipe.recipeName}</td>
                            <td class="col-1 center">
                                <a href='<c:url value="/app/plan/details/delete?id=${recipe.recipeId}"/>' class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Czy na pewno chcesz usunąć przepis z planu?')">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href='<c:url value="/app/recipe/details?id=${recipe.recipeId}"/>'
                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                            </td>
                        </tr>
                        </tbody>
                    </c:if>
                </c:forEach>
            </table>


        </div>
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