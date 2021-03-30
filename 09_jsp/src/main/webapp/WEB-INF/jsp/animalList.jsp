<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Animal List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  </head>
  <body>
    <h1>Animal List</h1>

    <br/><br/>
    <div>
      <table border="1">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Category</th>
        </tr>
        <c:forEach  items="${animals}" var ="animal">
        <tr>
          <td>${animal.id}</td>
          <td>${animal.name}</td>
          <td>${animal.category}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </body>

</html>