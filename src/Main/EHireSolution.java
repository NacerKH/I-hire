/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehiresolution;

import Entities.Question;
import Entities.Test;
import Infrastructure.AppDbContext;
import Repositories.QuestionRepository;
import Repositories.TestRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dhiaeddsn
 */
public class EHireSolution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TestRepository testRepo = TestRepository.GetInstance();

        //Post Test
        ArrayList<Question> listQuest = new ArrayList<>();
        Test test = new Test("oki", 2, 2, new Date(1999, 7, 29), new Date(1999, 7, 29));
        listQuest.add(new Question(2, "yes", 2, "test", "test", "test", new Date(1999, 7, 29), "test", "test", 2, new Date(1999, 7, 29)));
        listQuest.add(new Question(2, "yes", 2, "test", "test", "test", new Date(1999, 7, 29), "test", "test", 2, new Date(1999, 7, 29)));
        test.setQuestions(listQuest);
        testRepo.Post(test);

        //Get All Tests
//        testRepo.GetAll().forEach(t -> System.out.println(t.toString()));
        //Get All Tests
//          System.out.println(testRepo.GetById(12).toString()); 
//        Test test = testRepo.GetById(6); 
//        System.out.println("test before update"); 
//        System.out.println(test.toString()); 
//        System.out.println("test after update"); 
//        test.setTopic("1234");
//        testRepo.Put(test); 
//        System.out.println(testRepo.GetById(6).toString()); 
//        System.out.println("List Before Deleting one item size is " + testRepo.GetAll().size());
        //Delete Test
//          testRepo.Delete(12); 
//        System.out.println("List after Deleting one item size is " + testRepo.GetAll().size()); 
    }

}
