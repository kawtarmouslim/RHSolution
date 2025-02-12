package org.example.gestionemploye;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import entites.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

//    public void init() {
//    }
    //constructure
    public UserServlet(){
        userDao=new UserDao();

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        this.doGet(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
            String action = request.getServletPath();
                switch (action) {
                    case "/new":
                        showNewForm(request, response);
                        break;
                    case "/insert":
                        try {
                            insertUser(request,response);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "/delete":
                        try {
                            deleteUser(request,response);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "/edit":
                        try {
                            showEditForm(request, response);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "/update":
//                        try {
//                            updateUser(request, response);
//                        } catch (SQLException e) {
//                            throw new RuntimeException(e);
//                        }
                        break;
                    case "/list":
                        try {
                            listUser(request,response);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;

                    default:

                        break;
                }
    }
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDao.selectAllUsers(); // Récupération des utilisateurs
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    //    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        Long id = Long.parseLong(request.getParameter("id"));
//        String nom = request.getParameter("nom");
//        String prenom = request.getParameter("prenom");
//        String poste = request.getParameter("poste");
//        int salaire = Integer.parseInt(request.getParameter("salaire"));
//        User user = new User(id, nom, prenom, poste,salaire);
//         userDao.updateUser(user);
//        response.sendRedirect("list");
//    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id =Long.parseLong(request.getParameter("id"));
        userDao.deleteUser(id);
        response.sendRedirect("/list");

    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        User existingUser = userDao.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String poste = request.getParameter("poste");
        int salaire = Integer.parseInt(request.getParameter("salaire"));

        User newUser = new User(nom, prenom, poste, salaire);

        userDao.insertUser(newUser);

        response.sendRedirect(request.getContextPath() + "/list");
    }




}