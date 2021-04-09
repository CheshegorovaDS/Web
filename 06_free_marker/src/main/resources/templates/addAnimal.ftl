<#import "addAnimal.ftl" as addAnimal/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Add Animal</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/style.css'/>"/>
</head>
<body>
    <h1>Create an Animal:</h1>

    <div>
        <fieldset>
            <legend>Add Animal</legend>
            <form name="animal" action="" method="POST">
                Name: <@spring.formInput "animalForm.name" "" "text"/>
                <br/>
                Category: <@spring.formInput "animalForm.category" "" "text"/>
                <br/>
                <input type="submit" value="Create" />
            </form>
        </fieldset>
    </div>

    <br/>

    <#if errorMessage??>
    <div style="color:red;font-style:italic;">
        ${errorMessage}
    </div>
    </#if>
</body>
</html>