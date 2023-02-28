package issat.malek.tpbase;

import java.sql.*;
public class StudentDao {
   Statement statement= null;
   Connection connection = null;

    public StudentDao() {
        Dao dao = new Dao();
        this.connection = dao.getConnection();
        try {
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insertStudent(int c, String nom, String prenom, double moy) {
        try {
            String req = "insert into etudiant values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, c);
            preparedStatement.setString(2, nom);
            preparedStatement.setString(3, prenom);
            preparedStatement.setDouble(4, moy);
            int a = preparedStatement.executeUpdate();
            if (a > 0) {
                System.out.println("Insertion réussie");
            } else {
                System.out.println("Insertion non réussie");
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insertion non réussie: "+e.getMessage());
        }
    }
    public void deleteStudent(int c){
        try {
            String req = "delete from etudiant where cne=?";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, c);
            int a = preparedStatement.executeUpdate();
            if (a > 0) {
                System.out.println("Suppression réussie");
            } else {
                System.out.println("Suppression non réussie");
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Suppression non réussie: "+e.getMessage());
        }

    }
    public void updateStudent(int c, String nom, String prenom, double moy) {
        try {
            String req = "update etudiant set nom=?, prenom=?, moy=? where numcin=?";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setDouble(3, moy);
            preparedStatement.setInt(4, c);
            int a = preparedStatement.executeUpdate();
            if (a > 0) {
                System.out.println("Modification réussie");
            } else {
                System.out.println("Modification non réussie");
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Modification non réussie: "+e.getMessage());
        }
    }
    public void selectStudent() {
        String req = "select * from etudiant";
        try{
            ResultSet resultSet = statement.executeQuery(req);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getDouble(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Selection non réussie: "+e.getMessage());
        }
    }
    public void selectStudent(int c) {
        String req = "select * from etudiant where numcin="+c;

        try{
            ResultSet resultSet = statement.executeQuery(req);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getDouble(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Selection non réussie: "+e.getMessage());
        }
    }
    public ResultSet select(String req){
        try{
            ResultSet resultSet = statement.executeQuery(req);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Selection non réussie: "+e.getMessage());
            return null;
        }
    }
    public void showResult(ResultSet req){
        try{
            while (req.next()){
                System.out.println(req.getInt(1)+" "+req.getString(2)+" "+req.getString(3)+" "+req.getDouble(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Selection non réussie: "+e.getMessage());
        }
    }
}
