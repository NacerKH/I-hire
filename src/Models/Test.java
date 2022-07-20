/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author e.bentijani
 */
public class Test {
    int id ;
    String topic;
    int totalQuestions;
    int duration;
    Date createdDate;
    Date updatedDate;
    ArrayList<Question> questions; 
    int idOffre;
    public Test() {
   List <Question> questions = new ArrayList <Question>();

    }

    public Test(int id) {
        this.id = id;
    }

    public Test(String topic, int totalQuestions, int duration, Date createdDate, Date updatedDate, ArrayList<Question> questions) {
        this.topic = topic;
        this.totalQuestions = totalQuestions;
        this.duration = duration;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.questions = questions;
    }

    public Test(String topic, int totalQuestions, int duration, Date createdDate, Date updatedDate) {
        this.topic = topic;
        this.totalQuestions = totalQuestions;
        this.duration = duration;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Test(int id, String topic, int totalQuestions, int duration, Date createdDate, Date updatedDate, ArrayList<Question> questions, int idOffre) {
        this.id = id;
        this.topic = topic;
        this.totalQuestions = totalQuestions;
        this.duration = duration;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.questions = questions;
        this.idOffre = idOffre;
    }

    public Test(int id, String topic, int totalQuestions, int duration, Date createdDate, Date updatedDate) {
        this.id = id;
        this.topic = topic;
        this.totalQuestions = totalQuestions;
        this.duration = duration;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    
    public Test(int id, String topic, int totalQuestions, int duration, Date createdDate, Date updatedDate, ArrayList<Question> questions) {
        this.id = id;
        this.topic = topic;
        this.totalQuestions = totalQuestions;
        this.duration = duration;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.questions = questions;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Test{" + "id=" + id + ", topic=" + topic + ", totalQuestions=" + totalQuestions + ", duration=" + duration + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", questions=" + questions + '}';
    }


    
}
