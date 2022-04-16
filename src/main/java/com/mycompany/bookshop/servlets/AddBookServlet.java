/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bookshop.servlets;

import com.mycompany.bookshop.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet to process Add book form
 * @author nikita
 */
public class AddBookServlet extends HttpServlet {

    /**
     * Method creates connection and making add book in database
     * @param book_id
     * @param book_name
     * @param book_price
     * @param author_id 
     */
    public void addBook(String book_id,String book_name,String book_price,String author_id){
        try {
		Connection conn = DataSource.getConnection();
                Statement statement = conn.createStatement();
                              
                String BEGIN_TRANSACTION="BEGIN TRANSACTION;";
                String SQL = "INSERT INTO books VALUES("+book_id+",'"+book_name+"',"+book_price+","+author_id+");";
                String COMMIT_TRANSACTION="COMMIT;";
                
                statement.execute(BEGIN_TRANSACTION+SQL+COMMIT_TRANSACTION);
           
                statement.close();
                conn.close();
        }catch(Exception e){
			e.printStackTrace();
		}

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                getServletContext().getRequestDispatcher("/add_book.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.Processing POST when adding book
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

        addBook(bookId,bookName,bookPrice,bookAuthor);
        
        response.sendRedirect("./BookServlet");
    

    }

    
}
