package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {


    @Test
    public void studentConstructorTest() {
        //Given
        String expectedFirstName = "Peter";
        String expectedLastName = "Kutchen";
        Double[] expectedExamScores = {100.0, 85.0, 96.0, 86.0};
        String expectedExamScoresString = "Exam Scores:\n\tExam 1 -> 100\n\tExam 2 ->  85\n\tExam 3 ->  96\n\tExam 4 ->  86\n";

        //When
        Student newStudent = new Student(expectedFirstName, expectedLastName, expectedExamScores);
        String actualFirstName = newStudent.getFirstName();
        String actualLastName = newStudent.getLastName();
        String actualExamScores = newStudent.getExamScores();

        //Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedExamScoresString, actualExamScores);
    }

    @Test
    public void setFirstNameTest() {
        //Given
        String expectedFirstName = "Babe";

        //When
        Student newStudent = new Student("", "", new Double[1]);
        newStudent.setFirstName(expectedFirstName);
        String actualFirstName = newStudent.getFirstName();

        //Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    public void setLastNameTest() {
        //Given
        String expectedLastName = "Ruth";

        //When
        Student newStudent = new Student("", "", new Double[1]);
        newStudent.setLastName(expectedLastName);
        String actualLastName = newStudent.getLastName();

        //Then
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void getNumberOfExamsTest() {
        //Given
        Integer expectedNumExams = 10;
        Double[] expectedExams = {100.0, 95.0, 93.0, 85.0, 100.0, 89.0, 98.0, 76.0, 89.0, 87.0};

        //When
        Student newStudent = new Student("", "", expectedExams);
        Integer actualNumExams = newStudent.getNumberOfExams();

        //Then
        Assert.assertEquals(expectedNumExams, actualNumExams);
    }

    @Test
    public void getExamScoresTest() {
        // : Given
        String firstName = "Peter";
        String lastName = "Kutchen";
        Double[] examScores = {100.0, 95.0, 89.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void addExamScoreTest() {
        //Given
        Double expectedExam = 100.0;
        String expectedString = "Exam Scores:\n\tExam 1 -> 100\n";

        //When
        Student newStudent = new Student("", "", new Double[0]);
        newStudent.addExamScore(expectedExam);
        String actualExamScores = newStudent.getExamScores();

        //Then
        Assert.assertEquals(expectedString, actualExamScores);
    }

    @Test
    public void getAverageExamScoreTest() {
        Double [] exams = {100.0, 90.0, 75.0, 100.0};
        Double expectedAvg = (100.0 + 90.0 + 75.0 + 100.0) / 4.0;
        //When
        Student newStudent = new Student("", "", exams);
        Double actualAvg = newStudent.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAvg, actualAvg);
    }

    @Test
    public void toStringTest() {
        //Given
        String expectedFirstName = "Peter";
        String expectedLastName = "Kutchen";
        Double[] expectedExamScores = {100.0, 100.0, 100.0, 100.0};
        String expectedReport = "Student Name: Peter Kutchen\n> Average Score: 100.0\n> Exam Scores:\n\tExam 1 -> 100\n\tExam 2 -> 100\n\tExam 3 -> 100\n\tExam 4 -> 100\n";

        //When
        Student newStudent = new Student (expectedFirstName, expectedLastName,expectedExamScores);
        String actualReport = newStudent.toString();

        //Then
        Assert.assertEquals(expectedReport, actualReport);
    }
}