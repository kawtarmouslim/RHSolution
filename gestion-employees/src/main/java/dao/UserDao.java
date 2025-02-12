package dao;

import entites.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/gestion-employe";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
  //  private static final  String  INSERT_USERS_SQL  =  " INSERT INTO employe "  +  "   (nom, prenom, poste,salaire) VALEURS "  +
     //       " (?, ?, ? ,?); " ;

    private  static  final  String  SELECT_USER_BY_ID  =  " select id, nom, prenom, poste,salaire from les employe where id =? " ;
    //private  static  final  String  SELECT_ALL_USERS  =  " select * from  employe " ;
   // private  static  final  String  DELETE_USERS_SQL  =  " delete  employe where id = ?; " ;
    private  static  final  String  UPDATE_USERS_SQL  =  " update  employe set nom = ?, prenom = ?, poste =?,salaire=? where id = ?; " ;

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.out.println("Erreur SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver non trouvé: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        String sql = "INSERT INTO employe (nom, prenom, poste, salaire) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getPoste());
            preparedStatement.setInt(4, user.getSalaire());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getPoste());
            statement.setInt(4, user.getSalaire());
            statement.setLong(5, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public User selectUser(Long id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String poste = rs.getString("poste");
                int salaire = rs.getInt("salaire");

                user = new User(id, nom, prenom, poste,salaire);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return user;
    }

    public List< User > selectAllUsers() {
        List < User > users = new ArrayList< >();

        String sql = "select * from employe";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String poste = rs.getString("poste");
                int salaire = rs.getInt("salaire");
                users.add(new User(id, nom, prenom, poste,salaire));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return users;
    }
    public void deleteUser(Long id) {
        String query = "delete from employe where id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

