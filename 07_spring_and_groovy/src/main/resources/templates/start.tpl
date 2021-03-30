yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('Animal List')
    }
    body {
        h2 ('A Groovy View with Spring Boot')

        h3 ("Message: $message")

        table (border: "1")  {
            tr {
               th("Name")
               th("Category")
            }
            animals.each { animal ->
                tr {
                   td("$animal.name")
                   td("$animal.category")
                }
            }
        }
    }
}