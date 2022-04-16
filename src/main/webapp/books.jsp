<%-- 
    Document   : index
    Created on : Apr 11, 2022, 7:51:24 AM
    Author     : nikita
--%>

<%@page import="com.mycompany.bookshop.DAO.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Page</title>
    </head>
    <body>
        <script type="text/javascript">
            
            function call_add_form() 
            {
              window.location.href = './AddBookServlet';
            }
            
             function call_update_form(book_id) 
            {
              window.location.href = './EditBookServlet?book_id='+book_id;

            }
            
            function delete_book()
              {
               let isConfirmed = confirm("Are you sure you want to delete the book? \nThis action is irreversible.");
               if (isConfirmed === false) 
                {
                 window.location.reload();
                }
              }
        </script>
        
        <h2>Books Table</h2>
   
      <input type="submit" name="add_book" onclick="call_add_form()" value="Add book"/>

          <table id="admin_goods_table" cellspacing="2" border="1" cellpadding="5">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Author</th>
    <th>Genre</th>
    </thead>
    <tr>
    <c:forEach items="${all_books}" var="book">
        <tr>
            <td>${book.getBookId()}</td>
            <td>${book.getName()}</td>
            <td>${book.getPrice()}</td>
            <td>${book.getAuthorName()}</td>
            <td>${book.getGenreName()}</td>

            <td><input class="edit_button" type="submit" value="Update" onclick="(call_update_form(${book.getBookId()}))"/>
            </td>
             <form method="post"  action="./BookServlet">
                 <td><input name="book_id" type="hidden" value="${book.getBookId()}"/></td>
                 <td><input  type="submit" value="Delete" onclick="delete_book()"/>
                </td>
            </form>
          </tr>
    </c:forEach>   
    
    </tr>
    </table>

    
  
      

        
    </body>
</html>


    
<%--       
<form:form method="post" action="${pageContext.request.contextPath}/admin/books/delete_book/${book.getBookId()}">

<%    
    ArrayList<Book> allBooks = (ArrayList<Book>) request.getAttribute("all_books");

for(Book book : allBooks) {
    out.println(book.getBookId());
    out.println(book.getName());
    out.println(book.getPrice());
    out.println(book.getAuthorId());
    }
    %>
<c:forEach items="${allBooks}" var="book">
        <tr>
            <td>${book.getBookId()}</td>
            <td>${book.getName()}</td>
            <td>${book.getPrice()}</td>
            <td>${books.getAuthorId()}</td>
          </tr>
    </c:forEach>   
 <c:forEach items="${all_books}" var="book">
        <tr>
            <td>${book.goodId}</td>
            <td>${book.name}</td>
            <td>${book.category}</td>
            <td>${books.subcategory}</td>
          </tr>
    </c:forEach>    

<c:forEach items="${getAllGoods}" var="good">
        <tr>
            <td>${good.goodId}</td>
            <td>${good.name}</td>
            <td>${good.category}</td>
            <td>${good.subcategory}</td>
            <td>${good.trademark}</td>
            <td>${good.countryName}</td>
            <td>${good.price}</td>
            <td>${good.amount}</td>
            <td>${good.goodDescription}</td>
            <td><fmt:formatDate value="${good.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><fmt:formatDate value="${good.updatedAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>

            <td><input class="edit_button" type="submit" value="Update" onclick="(call_update_form(${good.goodId}))"/>
            </td>
            <div id="update_form_div_${good.goodId}" style="display: none"></div>

            <form:form method="post" action="${pageContext.request.contextPath}/admin/goods/delete_good/${good.goodId}">
                <td><input class="delete_button" type="submit" value="Delete" onclick="delete_good(${good.goodId})"/>
                </td>
            </form:form>

        </tr>
    </c:forEach>    



<%=request.getAttribute("tom_name")%>  --%>