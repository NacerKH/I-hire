/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author e.bentijani
 */
public class TableQuestionDto {
    private int idQuestion;
    private int lastUpdate;
    private int question;

    public TableQuestionDto(int idQuestion, int lastUpdate, int question) {
        this.idQuestion = idQuestion;
        this.lastUpdate = lastUpdate;
        this.question = question;
    }



    public int getNbQuestion() {
        return idQuestion;
    }

    public void setNbQuestion(int nbQuestion) {
        this.idQuestion = nbQuestion;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

     @Override
    public String toString() {
        return "TableQuestionDto{" + "idQuestion=" + idQuestion + ", lastUpdate=" + lastUpdate + ", question=" + question + '}';
    } 
    
}
