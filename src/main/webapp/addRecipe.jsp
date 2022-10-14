<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <%@ include file="/fragments/meta.jsp" %>
  <title>Contact</title>
  <%@ include file="/fragments/headerFixed.jsp" %>
</head>

<section class="dashboard-section">
  <div class="row dashboard-nowrap">
    <ul class="nav flex-column long-bg">
      <li class="nav-item">
        <a class="nav-link" href="">
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
        <a class="nav-link" href="">
          <span>Edytuj dane</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="">
          <span>Zmień hasło</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="">
          <span>Użytkownicy</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
    </ul>

    <div class="m-4 p-3 width-medium text-color-darker">
      <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <form action="/app/recipe/add" method="post">
          <div class="mt-4 ml-4 mr-4">
            <div class="row border-bottom border-3">
              <div class="col"><h3 class="color-header text-uppercase">Nowy przepis</h3></div>
              <div class="col d-flex justify-content-end mb-2">
                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
              </div>
            </div>

            <table class="table borderless">
              <tbody>
              <tr class="d-flex">
                <th scope="row" class="col-2">Nazwa Przepisu</th>
                <td class="col-7">

                  <input name="name" class="w-100 p-1" value="">
                </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Opis przepisu</th>
                <td class="col-7"><textarea name="description" class="w-100 p-1" rows="5"></textarea></td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Przygotowanie (minuty)</th>
                <td class="col-3">
                  <input name="preparationTime" class="p-1" type="number" value="">
                </td>
              </tr>
              </tbody>
            </table>

            <div class="row d-flex">
              <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Sposób
                przygotowania</h3></div>
              <div class="col-2"></div>
              <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Składniki</h3></div>
            </div>
            <div class="row d-flex">
              <div class="col-5 p-4">
                <textarea name="preparation" class="w-100 p-1" rows="10"></textarea>
              </div>
              <div class="col-2"></div>

              <div class="col-5 p-4">
                <textarea name="ingredients" class="w-100 p-1" rows="10"></textarea>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

</section>



</body>
</html>