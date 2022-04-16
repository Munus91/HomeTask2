/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bookshop.servlets;

import com.mycompany.bookshop.DAO.Book;
import com.mycompany.bookshop.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 *Servlet to process edit book form
 * @author nikita
 */
public class EditBookServlet extends HttpServlet {

    /**
     * Method creates connection and making search by id in database
     * @param book_id
     * @return 
     */
    public Book getBookById(String book_id){
        Book book=null;
        try {
		Connection conn = DataSource.getConnection();
                Statement statement = conn.createStatement();
                          
                String SQL = "SELECT book_id,book_name,price,author_id FROM books WHERE book_id="+book_id +";";

                ResultSet rs = statement.executeQuery(SQL);
                while(rs.next()){
                    book=new Book();
                    book.setBookId(rs.getLong("book_id"));
                    book.setName(rs.getString("book_name"));
                    book.setPrice(rs.getBigDecimal("price"));
                    book.setAuthorId(rs.getLong("author_id"));                
                }
                System.out.println("getBookByID:"+book.getBookId());
                System.out.println("getBookByID Book NAME:"+book.getName());

		rs.close();
                statement.close();
                conn.close();
        }catch(Exception e){
			e.printStackTrace();
		}

        return book;
    }
    
    /**
     * Method creates connection and making update in database
     * @param book_id
     * @param book_name
     * @param book_price
     * @param author_id 
     */
    public void editBook(String book_id,String book_name,String book_price,String author_id){
        try {
		Connection conn = DataSource.getConnection();
                Statement statement = conn.createStatement();
                
                String BEGIN_TRANSACTION="BEGIN TRANSACTION;";
                String COMMIT_TRANSACTION="COMMIT;";
                
                String SQL = "UPDATE books SET book_id="+book_id+",book_name='"+book_name+"', price="+book_price+",author_id="+author_id+"WHERE book_id="+book_id+";";
                //statement.executeUpdate(SQL);
                statement.execute(BEGIN_TRANSACTION+SQL+COMMIT_TRANSACTION);
                statement.close();
                conn.close();
        }catch(Exception e){
			e.printStackTrace();
		}

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.Loads separate page with parameters to edit
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                      String book_id=request.getParameter("book_id");
                      
                      Book modifiedBook=getBookById(book_id);
                      
                      request.setAttribute("book_id", modifiedBook.getBookId());
                      request.setAttribute("book_name", modifiedBook.getName());
                      request.setAttribute("book_price", modifiedBook.getPrice());
                      request.setAttribute("book_author", modifiedBook.getAuthorId());

      getServletContext().getRequestDispatcher("/edit_book.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.Getting parameters from edit form.Writing to database.
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
        String bookName = request.getParameter("book_name");
        String bookPrice = request.getParameter("book_price");
        String bookAuthor = request.getParameter("book_author");
        
        System.out.println("POST IN EDIT BOOK SERVLET");

        editBook(bookId,bookName,bookPrice,bookAuthor);
        response.sendRedirect("./BookServlet");

    }

    
}
