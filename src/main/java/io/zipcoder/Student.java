package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExams() {
        return examScores.size();
    }

    public String getExamScores() {
        StringBuilder examScoresOutput = new StringBuilder("Exam Scores:\n");
        for (int i = 0; i < examScores.size(); i++) {
            examScoresOutput.append(String.format("\tExam %d -> %3.0f\n", i + 1, examScores.get(i)));
        }
        return examScoresOutput.toString();
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber, newScore);
    }

    public Double getAverageExamScore() {
        Double averagedExamScore = 0.0;
        for (Double x : examScores) {
            averagedExamScore += x;
        }
        return averagedExamScore / examScores.size();
    }

    @Override
    public String toString() {
        return String.format("Student Name: %s %s\n> Average Score: %3.1f\n", getFirstName(), getLastName(), getAverageExamScore()) + "> " + getExamScores();
    }
}

