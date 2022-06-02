/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Entities.Question;
import Infrastructure.AppDbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionRepository {

    Connection Connection;

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    QuestionRepository() {
        Connection = AppDbContext.GetInstance().GetDbConnection();
    }
    private static QuestionRepository instance = new QuestionRepository();

    public static QuestionRepository GetInstance() {
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
            String req = "INSERT INTO `question`(`questionOrder`, `title`, `questionDuration`, `description`, `ChoiceA`, `ChoiceB`, `createdDate`, `choiceC`, `ChoiceD`, `rightAnswer`, `updatedDate`,`idTest`)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setInt(1, model.getOuestionOrder());
            ps.setString(2, model.getTitle());
            ps.setFloat(3, model.getOuestionDuration());
            ps.setString(4, model.getDescription());
            ps.setString(5, model.getChoiceA());
            ps.setString(6, model.getChoiceB());
            ps.setDate(7, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setString(8, model.getChoiceC());
            ps.setString(9, model.getChoiceD());
            ps.setInt(10, model.getOuestionOrder());
            ps.setDate(11, new java.sql.Date(model.getUpdatedDate().getTime()));
            ps.setInt(12, model.getIdTest());

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
            String req = "UPDATE `question` SET questionOrder = ?, title = ? , questionDuration = ?, description = ?, ChoiceA = ?, ChoiceB = ?, createdDate = ?, choiceC = ?, ChoiceD = ?, rightAnswer = ?, updatedDate = ?, idTest = ?"
                    + "WHERE Id = " + model.getId();

            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setInt(1, model.getOuestionOrder());
            ps.setString(2, model.getTitle());
            ps.setFloat(3, model.getOuestionDuration());
            ps.setString(4, model.getDescription());
            ps.setString(5, model.getChoiceA());
            ps.setString(6, model.getChoiceB());
            ps.setDate(7, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setString(8, model.getChoiceC());
            ps.setString(9, model.getChoiceD());
            ps.setInt(10, model.getOuestionOrder());
            ps.setDate(11, new java.sql.Date(model.getUpdatedDate().getTime()));
            ps.setInt(12, model.getIdTest());
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

    // <editor-fold defaultstate="collapsed" desc="DeleteTestQuestion(">
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
    // <editor-fold defaultstate="collapsed" desc="InitUser">
    private Question InitQuestion(ResultSet result) {
        try {
            return new Question(
                    result.getInt("questionOrder"),
                    result.getString("title"),
                    result.getFloat("questionDuration"),
                    result.getString("description"),
                    result.getString("choiceA"),
                    result.getString("choiceB"),
                    result.getDate("createdDate"),
                    result.getString("choiceC"),
                    result.getString("choiceD"),
                    result.getInt("questionOrder"),
                    result.getDate("updatedDate"),
                    result.getInt("idTest"));

        } catch (SQLException ex) {
            System.err.println("[Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // </editor-fold>
}
