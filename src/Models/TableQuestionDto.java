/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author e.bentijani
 */
public class TableQuestionDto {
    private int idQuestion;
    private String question;
    public TableQuestionDto(int idQuestion, Date lastUpdate, String question) {
        this.idQuestion = idQuestion;
        this.question = question;
    }


    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }



    @Override
    public String toString() {
        return "TableQuestionDto{" + "idQuestion=" + idQuestion + ", question=" + question + '}';
    }

    
}
