/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Question;
import Utils.AppDbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionService {

    Connection Connection;

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
   QuestionService() {
        Connection = AppDbContext.GetInstance().GetDbConnection();
    }
    private static QuestionService instance = new QuestionService();

    public static QuestionService GetInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<Question> GetAll() {
        ArrayList<Question> resultList = new ArrayList<Question>();
        try {
            String req = "SELECT * FROM question";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                try {
                    resultList.add(InitQuestion(result));
                } catch (Exception ex) {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return resultList;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GetAllByIdTest">
    public ArrayList<Question> GetAllByIdTest(int id) {
        ArrayList<Question> resultList = new ArrayList<Question>();
        try {
            String req = "SELECT * FROM question WHERE idTest = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                try {
                    resultList.add(InitQuestion(result));
                } catch (Exception ex) {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return resultList;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GetById">
    public Question GetById(int id) {
        try {
            String req = "SELECT * FROM question WHERE Id = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {

                try {
                    return InitQuestion(result);
                } catch (Exception ex) {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Post">
    public boolean Post(Question model) {
        try {
            String req = "INSERT INTO `question`( `description`, `ChoiceA`, `ChoiceB`, `createdDate`, `choiceC`, `ChoiceD`, `rightAnswer`, `updatedDate`,`idTest`,`score`)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = Connection.prepareStatement(req);
            ps.setString(1, model.getDescription());
            ps.setString(2, model.getChoiceA());
            ps.setString(3, model.getChoiceB());
            ps.setDate(4, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setString(5, model.getChoiceC());
            ps.setString(6, model.getChoiceD());
            ps.setString(7, model.getRightAnswer());
            ps.setDate(8, new java.sql.Date(model.getUpdatedDate().getTime()));
            ps.setInt(9, model.getIdTest());
            ps.setFloat(10, model.getScore());

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Put">
    public boolean Put(Question model) {

        try {
            String req = "UPDATE `question` SET  description = ?, ChoiceA = ?, ChoiceB = ?, createdDate = ?, choiceC = ?, ChoiceD = ?, rightAnswer = ?, updatedDate = ?, score = ?"
                    + "WHERE Id = " + model.getId();

            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setString(1, model.getDescription());
            ps.setString(2, model.getChoiceA());
            ps.setString(3, model.getChoiceB());
            ps.setDate(4, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setString(5, model.getChoiceC());
            ps.setString(6, model.getChoiceD());
            ps.setString(7, model.getRightAnswer());
            ps.setDate(8, new java.sql.Date(model.getUpdatedDate().getTime()));
           ps.setFloat(9, model.getScore());
           // ps.setInt(9, model.getIdTest());

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Delete">
    public boolean Delete(int id) {

        try {
            String req = "DELETE FROM question WHERE Id = ? ; ";
            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DeleteTestQuestion">
    public boolean DeleteTestQuestion(int id) {

        try {
            String req = "DELETE FROM question  WHERE idTest = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Other Methods">
    
    // <editor-fold defaultstate="collapsed" desc="InitQuestion">
    private Question InitQuestion(ResultSet result) {
        try {
            return new Question(
                    result.getInt("id"),
                    result.getString("description"),
                    result.getString("choiceA"),
                    result.getString("choiceB"),
                    result.getDate("createdDate"),
                    result.getString("choiceC"),
                    result.getString("choiceD"),
                    result.getString("rightAnswer"),
                    result.getDate("updatedDate"),
                    result.getInt("idTest"),
                    result.getFloat("score"));

        } catch (SQLException ex) {
            System.err.println("[Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // </editor-fold>
}
