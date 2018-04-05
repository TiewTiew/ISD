/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Donor;
import model.MemberService;
import model.Staff;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
    @PersistenceContext EntityManager em;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DonorService donorService = new DonorService(em);

        Donor donor = donorService.findDonorByDonorId(DonorId);

        if (donor != null && donor.getDonorPassword().equals(password)){
                request.getSession().setAttribute("donor", donor);
                response.sendRedirect("viewevent"); // redirect to home page
        } else {
            RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            request.setAttribute("error", "Invalid Username/Password");
            Dispatcher.forward(request,response);
        }
    }
}
