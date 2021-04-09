<#import "start.ftl" as start/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/style.css'/>"/>
</head>
<body>
    <h1>Welcome</h1>
    <#if message??>
    <h2>${message}</h2>
    </#if>

</body>
</html>