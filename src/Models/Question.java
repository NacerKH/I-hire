/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author e.bentijani
 */
public class Question {
    private int id;
    private String description;
    private String ChoiceA;
    private String ChoiceB;
    private Date createdDate;
    private String choiceC;
    private String choiceD;
    private String rightAnswer;
    private Date updatedDate;
    private Test test;
    private int idTest;
    private float score;

    public Question() {
    }

    public Question(int id, String description, String ChoiceA, String ChoiceB, Date createdDate, String choiceC, String choiceD, String rightAnswer, Date updatedDate, Test test, int idTest, float score) {
        this.id = id;
        this.description = description;
        this.ChoiceA = ChoiceA;
        this.ChoiceB = ChoiceB;
        this.createdDate = createdDate;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.rightAnswer = rightAnswer;
        this.updatedDate = updatedDate;
        this.test = test;
        this.idTest = idTest;
        this.score = score;
    }

    public Question(String description, String ChoiceA, String ChoiceB, Date createdDate, String choiceC, String choiceD, String rightAnswer, Date updatedDate, Test test, int idTest, float score) {
        this.description = description;
        this.ChoiceA = ChoiceA;
        this.ChoiceB = ChoiceB;
        this.createdDate = createdDate;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.rightAnswer = rightAnswer;
        this.updatedDate = updatedDate;
        this.test = test;
        this.idTest = idTest;
        this.score = score;
    }

    public Question(int id, String description, String ChoiceA, String ChoiceB, Date createdDate, String choiceC, String choiceD, String rightAnswer, Date updatedDate, int idTest, float score) {
        this.id = id;
        this.description = description;
        this.ChoiceA = ChoiceA;
        this.ChoiceB = ChoiceB;
        this.createdDate = createdDate;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.rightAnswer = rightAnswer;
        this.updatedDate = updatedDate;
        this.idTest = idTest;
        this.score = score;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChoiceA() {
        return ChoiceA;
    }

    public void setChoiceA(String ChoiceA) {
        this.ChoiceA = ChoiceA;
    }

    public String getChoiceB() {
        return ChoiceB;
    }

    public void setChoiceB(String ChoiceB) {
        this.ChoiceB = ChoiceB;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", description=" + description + ", ChoiceA=" + ChoiceA + ", ChoiceB=" + ChoiceB + ", createdDate=" + createdDate + ", choiceC=" + choiceC + ", choiceD=" + choiceD + ", rightAnswer=" + rightAnswer + ", updatedDate=" + updatedDate + ", test=" + test + ", idTest=" + idTest + '}';
    }

    public void setUpdatedDate(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    

  
}
