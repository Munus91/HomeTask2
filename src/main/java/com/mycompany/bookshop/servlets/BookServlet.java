package com.mycompany.bookshop.servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.bookshop.DAO.Book;
import com.mycompany.bookshop.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Starting servlet with main page which contains info about books
 * @author nikita
 */
public class BookServlet extends HttpServlet {

   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.Displays all books
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              System.out.println("GET IN BOOK SERVLET");

              List<Book> books = getAllBooks();
              request.setAttribute("all_books", books);

              getServletContext().getRequestDispatcher("/books.jsp").forward(request, response);
                      
    }

    /**
     * Handles the HTTP <code>POST</code> method.Processing POST when deleting book
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           String bookId = request.getParameter("book_id");
           List<Book> books = getAllBooks();
           request.setAttribute("all_books", books);
           
           System.out.println("POST IN BOOK SERVLET");
           System.out.println("DELETING BOOK WITH ID:"+bookId);
           deleteBook(bookId);
       
           doGet(request, response);


    }
    
    /**
     * Method creates connection and making delete in database
     * @param id 
     */
    public void deleteBook(String id){
        try {
		Connection conn = DataSource.getConnection();
                Statement statement = conn.createStatement();
                String SQL = "DELETE FROM books WHERE book_id="+id;
                ResultSet rs = statement.executeQuery(SQL);
             
		rs.close();
                statement.close();
                conn.close();
        }catch(Exception e){
			e.printStackTrace();
		}

    }
    
    /**
     * Method creates connection and get all books from database
     * @param id 
     */
    public List<Book> getAllBooks(){
        List<Book> allBooks =null;
        try {
		Connection conn = DataSource.getConnection();
                Statement statement = conn.createStatement();
               // String SQL = "SELECT * from books";
               String SQL= "SELECT b.book_id, b.book_name, b.price, a.author_name,g.genre_name FROM books AS b JOIN authors AS a ON b.author_id=a.author_id JOIN genres AS g ON b.genre_id=g.genre_id;";
                ResultSet rs = statement.executeQuery(SQL);
                
                allBooks= new ArrayList<>();
                Book book;
                while (rs.next()) {
                    book=new Book();
                    book.setBookId(rs.getLong("book_id"));
                    book.setName(rs.getString("book_name"));
                    book.setPrice(rs.getBigDecimal("price"));
                    book.setAuthorName(rs.getString("author_name"));
                    book.setGenreName(rs.getString("genre_name"));
                    allBooks.add(book);
                } 

		rs.close();
                statement.close();
                conn.close();
        }catch(Exception e){
			e.printStackTrace();
		}
        return allBooks;
    }

  
}
