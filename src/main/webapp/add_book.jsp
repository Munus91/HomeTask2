<%-- 
    Document   : add_book
    Created on : Apr 14, 2022, 4:12:07 PM
    Author     : nikita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <script type="text/javascript">
            
                  
          
        </script>
        
        
        
        <h1>Add Book</h1>
        
        <form id="add_new_good_form" method="post" action="./AddBookServlet">
    <div id="input_fields">
        <h3>ADD BOOK: </h3>
        <br/> <label >Book ID: </label><br/> <input type="text" name="book_id" />                                                                               
        <br/> <label >Book name: </label><br/><input type="text" name="book_name"/>   
        <br/> <label >Price: </label><br/> <input name="book_price" type="number" step="0.01"/>
        <br/> <label >Author ID: </label><br/> <input name="book_author" type="text"/>
        
        
        
    </label><br/>
    </div>
    
    <div id="button_fields">
        <input type="submit" value="Ok"/>
        <input type="button" value="Cancel" onclick="window.location.href=history.back();"/>
    </div>
</form>
        
    </body>
</html>
