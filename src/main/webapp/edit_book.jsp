<%-- 
    Document   : edit_book
    Created on : Apr 14, 2022, 7:22:14 PM
    Author     : nikita
--%>

<%@page import="com.mycompany.bookshop.DAO.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Book</title>
    </head>
    <body>
        <h1>Edit Book</h1>
        
         <form method="post" action="./EditBookServlet">
    <div id="input_fields">
        <h3>Edit BOOK: </h3>
        <br/> <label >Book ID: </label><br/> <input type="text" name="book_id" value=${book_id} >                                                                               
        <br/> <label >Book name: </label><br/><input type="text" name="book_name"value=${book_name}>   
        <br/> <label >Price: </label><br/> <input name="book_price" type="number" step="0.01"value=${book_price}>
        <br/> <label >Author ID: </label><br/> <input name="book_author" type="text"value=${book_author}>
    </label><br/>
    </div>
    
    <div id="button_fields">
        <input type="submit" value="Ok"/>
        <input type="button" value="Cancel" onclick="window.location.href=history.back();"/>
    </div>
</form>
        
    </body>
</html>


<%--
        <br/> <label >Book ID: </label><br/> <input type="text" name="book_id" value=${modifiedBook.getBookId()}/>                                                                               
        
       <br/> <label >Book ID: </label><br/> <input type="text" name="book_id" value=${mb_id} >                                                                               

--%>