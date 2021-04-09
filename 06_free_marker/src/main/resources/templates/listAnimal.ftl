<#import "listAnimal.ftl" as listAnimal/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Animal List</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/style.css'/>"/>
</head>
<body>
    <h1>Animal List</h1>
    <a href="addAnimal">Add Animal</a>
    <br/><br/>
    <div>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Category</th>
            </tr>
            <#list animals as animal>
            <tr>
                <td>${animal.name}</td>
                <td>${animal.category}</td>
            </tr>
            </#list>
        </table>
    </div>
</body>
</html>