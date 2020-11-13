package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void nullaryConstructorTest(){
        //Given
        Classroom newClassroom = new Classroom();
        Student[] expectedStudentsArr = new Student[30];

        //When
        Student[] actualStudentArr = newClassroom.getStudents();

        //Then
        Assert.assertEquals(expectedStudentsArr,actualStudentArr);
    }

    @Test
    public void studentConstructorTest(){
        //Given
        Student student1 = new Student("Peter", "Kutchen", new Double[0]);
        Student student2 = new Student("Andrew", "Kutchen", new Double[0]);
        Student[] expectedStudentsArr = {student1,student2};

        //When
        Classroom newClassroom = new Classroom(expectedStudentsArr);
        Student[] actualStudentArr = newClassroom.getStudents();

        //Then
        Assert.assertEquals(expectedStudentsArr,actualStudentArr);
    }

    @Test
    public void maxConstructorTest(){
        //Given
        Student[] expectedStudentsArr = new Student[1000];

        //When
        Classroom newClassroom = new Classroom(1000);
        Student[] actualStudentArr = newClassroom.getStudents();

        //Then
        Assert.assertEquals(expectedStudentsArr,actualStudentArr);
    }

    @Test
    public void getAvgExamTest(){
        //Given
        Double[] student1Exams = {100.0, 90.0,100.0};
        Double[] student2Exams = {100.0, 100.0, 75.0};
        Student student1 = new Student("Peter", "Kutchen", student1Exams);
        Student student2 = new Student("Andrew", "Kutchen", student2Exams);
        Student[] expectedStudentsArr = {student1,student2};
        Double expectedAvg = (100.0+90.0+100.0+100.0+100.0+75.0)/6.0;

        //When
        Classroom newClassroom = new Classroom(expectedStudentsArr);
        Double actualAvg = newClassroom.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAvg ,actualAvg,0.0001);
    }

    @Test
    public void removeStudentTest(){
        //Given
        Double[] student1Exams = {100.0, 90.0,100.0};
        Double[] student2Exams = {100.0, 100.0, 75.0};
        Student student1 = new Student("Peter", "Kutchen", student1Exams);
        Student student2 = new Student("Andrew", "Kutchen", student2Exams);
        Student[] StudentsArr = {student1,student2};
        Student[] expectedStudentsArr = {student1, student2};
        //When
        Classroom newClassroom = new Classroom(StudentsArr);
        newClassroom.removeStudent("Andrew", "Kutchen");
        Student[] actualStudentArr = newClassroom.getStudents();

        //Then
        Assert.assertEquals(expectedStudentsArr ,actualStudentArr);
    }

    @Test
    public void sortStudentExamsTest(){
        //Given
        Double[] juliannKutchen = {90.0, 90.0, 90.0};
        Double[] amyKutchen = {100.0, 100.0, 100.0};
        Double[] timKutchen = {80.0, 80.0, 80.0};
        Double[] andrewKutchen = {60.0, 60.0, 60.0};
        Double[] peterKutchen = {70.0, 70.0, 70.0};
        Double[] trudyKutchen = {50.0, 50.0, 50.0};
        Student student1 = new Student("Juliann", "Kutchen", juliannKutchen);
        Student student2 = new Student("Amy", "Kutchen", amyKutchen);
        Student student3 = new Student("Tim", "Kutchen", timKutchen);
        Student student4 = new Student("Andrew", "Kutchen", andrewKutchen);
        Student student5 = new Student("Trudy", "Kutchen", peterKutchen);
        Student student6 = new Student("Trudy", "Kutchen", trudyKutchen);
        Student[] StudentsArr = {student1,student2,student3,student4,student5, student6};
        Student[] expectedSortedArr = {student2, student1, student3, student5, student4, student6};

        //When
        Classroom newClassroom = new Classroom(StudentsArr);
        Student[] actualSortedArr = newClassroom.studentsByScore();

        //Then
        Assert.assertEquals(expectedSortedArr ,actualSortedArr);
    }

    @Test
    public void getGradeBookTest(){
        //Given
        Double[] juliannKutchen = {90.0, 90.0, 90.0};
        Double[] amyKutchen = {100.0, 100.0, 100.0};
        Double[] timKutchen = {80.0, 80.0, 80.0};
        Double[] andrewKutchen = {60.0, 60.0, 60.0};
        Double[] peterKutchen = {70.0, 70.0, 70.0};
        Double[] trudyKutchen = {50.0, 50.0, 50.0};
        Student student1 = new Student("Juliann", "Kutchen", juliannKutchen);
        Student student2 = new Student("Amy", "Kutchen", amyKutchen);
        Student student3 = new Student("Tim", "Kutchen", timKutchen);
        Student student4 = new Student("Andrew", "Kutchen", andrewKutchen);
        Student student5 = new Student("Trudy", "Kutchen", peterKutchen);
        Student student6 = new Student("Trudy", "Kutchen", trudyKutchen);
        Student[] StudentsArr = {student1,student2,student3,student4,student5, student6};
        Student[] expectedSortedArr = {student2, student1, student3, student5, student4, student6};
        String expectedGrade = "A";
        //When
        Classroom newClassroom = new Classroom(StudentsArr);
        String actualGrade = newClassroom.getGradeBook().get(student2);

        //Then
        Assert.assertEquals(expectedGrade ,actualGrade);
    }
}