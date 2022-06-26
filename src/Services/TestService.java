/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Question;
import Models.Test;
import Utils.AppDbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class TestService{

    Connection Connection;

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    private TestService() {
        Connection = AppDbContext.GetInstance().GetDbConnection();
    }
    private static TestService instance = new TestService();
    private static QuestionService instancequestionRepo = new QuestionService();

    public static TestService GetInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<Test> GetAll() {
        ArrayList<Test> resultList = new ArrayList();
        try {
            String req = "SELECT * FROM test";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                try {
                    Test test = InitTest(result);
                    ArrayList<Question> questionList = instancequestionRepo.GetAllByIdTest(test.getId());
                    test.setQuestions(questionList);
                    resultList.add(test);
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
    public Test GetById(int id) {
        try {
            String req = "SELECT * FROM Test WHERE Id = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {

                try {
                    Test test = InitTest(result);
                    ArrayList<Question> questionList = instancequestionRepo.GetAllByIdTest(test.getId());
                    test.setQuestions(questionList);
                    return test;
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
    public int Post(Test model) {
         int idtest=-1;
        try {
            String req = "INSERT INTO `test`(`topic`, `totalQuestions`, `duration`, `createdDate`, `updatedDate`)"
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement ps = Connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, model.getTopic());
            ps.setInt(2, model.getTotalQuestions());
            ps.setInt(3, model.getDuration());
            ps.setDate(4, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setDate(5, new java.sql.Date(model.getUpdatedDate().getTime()));
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idq = generatedKeys.getInt(1);
                    idtest=idq;
                    model.getQuestions().forEach(q -> {
                        q.setIdTest(idq);
                        instancequestionRepo.Post(q);
                    });
                } else {
                    System.err.println("Creating test failed, no ID obtained.");
                    return idtest;
                }
            }
            return idtest;
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }
        return idtest;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Put">
    public boolean Put(Test model) {

        try {
            String req = "UPDATE `test` SET topic = ?, totalQuestions = ? , duration = ?, createdDate = ?, updatedDate = ?"
                    + "WHERE Id = " + model.getId();

            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setString(1, model.getTopic());
            ps.setInt(2, model.getTotalQuestions());
            ps.setInt(3, model.getDuration());
            ps.setDate(4, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setDate(5, new java.sql.Date(model.getUpdatedDate().getTime()));
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
            if (instancequestionRepo.DeleteTestQuestion(id) == true) {
                String req = "DELETE FROM test WHERE Id = ? ; ";
                PreparedStatement ps = Connection.prepareStatement(req);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("done");
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Other Methods">
    
    // <editor-fold defaultstate="collapsed" desc="InitTest">
    private Test InitTest(ResultSet result) {
        try {
            return new Test(
                    result.getInt("Id"),
                    result.getString("topic"),
                    result.getInt("totalQuestions"),
                    result.getInt("duration"),
                    result.getDate("createdDate"),
                    result.getDate("updatedDate"));
        } catch (SQLException ex) {
            System.err.println("[Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // </editor-fold>
}
