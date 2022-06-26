/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author e.bentijani
 */
public class Question {
    private int id;
    private int ouestionOrder;
    private String title;
    private float ouestionDuration;
    private String description;
    private String ChoiceA;
    private String ChoiceB;
    private Date createdDate;
    private String choiceC;
    private String choiceD;
    private int rightAnswer;
    private Date updatedDate;
    private Test test;
    private int idTest;

    public Question() {
    }

    public Question(int id, int ouestionOrder, String title, float ouestionDuration, String description, String ChoiceA, String ChoiceB, Date createdDate, String choiceC, String choiceD, int rightAnswer, Date updatedDate, Test test, int idTest) {
        this.id = id;
        this.ouestionOrder = ouestionOrder;
        this.title = title;
        this.ouestionDuration = ouestionDuration;
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
    }

    public Question(int id, int ouestionOrder, String title, float ouestionDuration, String description, String ChoiceA, String ChoiceB, Date createdDate, String choiceC, String choiceD, int rightAnswer, Date updatedDate, int idTest) {
        this.id = id;
        this.ouestionOrder = ouestionOrder;
        this.title = title;
        this.ouestionDuration = ouestionDuration;
        this.description = description;
        this.ChoiceA = ChoiceA;
        this.ChoiceB = ChoiceB;
        this.createdDate = createdDate;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.rightAnswer = rightAnswer;
        this.updatedDate = updatedDate;
        this.idTest = idTest;
    }

    public Question(int ouestionOrder, String title, float ouestionDuration, String description, String ChoiceA, String ChoiceB, Date createdDate, String choiceC, String choiceD, int rightAnswer, Date updatedDate, int idTest) {
        this.ouestionOrder = ouestionOrder;
        this.title = title;
        this.ouestionDuration = ouestionDuration;
        this.description = description;
        this.ChoiceA = ChoiceA;
        this.ChoiceB = ChoiceB;
        this.createdDate = createdDate;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.rightAnswer = rightAnswer;
        this.updatedDate = updatedDate;
        this.idTest = idTest;
    }

    public Question(int ouestionOrder, String title, float ouestionDuration, String description, String ChoiceA, String ChoiceB, Date createdDate, String choiceC, String choiceD, int rightAnswer, Date updatedDate) {
        this.ouestionOrder = ouestionOrder;
        this.title = title;
        this.ouestionDuration = ouestionDuration;
        this.description = description;
        this.ChoiceA = ChoiceA;
        this.ChoiceB = ChoiceB;
        this.createdDate = createdDate;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.rightAnswer = rightAnswer;
        this.updatedDate = updatedDate;
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOuestionOrder() {
        return ouestionOrder;
    }

    public void setOuestionOrder(int ouestionOrder) {
        this.ouestionOrder = ouestionOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getOuestionDuration() {
        return ouestionDuration;
    }

    public void setOuestionDuration(float ouestionDuration) {
        this.ouestionDuration = ouestionDuration;
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

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
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

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", ouestionOrder=" + ouestionOrder + ", title=" + title + ", ouestionDuration=" + ouestionDuration + ", description=" + description + ", ChoiceA=" + ChoiceA + ", ChoiceB=" + ChoiceB + ", createdDate=" + createdDate + ", choiceC=" + choiceC + ", choiceD=" + choiceD + ", rightAnswer=" + rightAnswer + ", updatedDate=" + updatedDate + ", test=" + test + ", idTest=" + idTest + '}';
    }

    

  
}
