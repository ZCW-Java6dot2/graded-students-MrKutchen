package io.zipcoder;

import java.util.*;

public class Classroom {
    Student [] students;

    public Classroom(int maxNumberOfStudents){
        students = new Student[maxNumberOfStudents];
    }

    public Classroom (Student[] student){
        students = student;
    }

    public Classroom(){
        students = new Student[30];
    }

    public Student[] getStudents(){
        return students;
    }

    public Double getAverageExamScore(){
        Double AverageExamScoreOfClass = 0.0;
        for (Student student : students) {
            AverageExamScoreOfClass += student.getAverageExamScore();
        }
        return AverageExamScoreOfClass / students.length;
    }

    public void addStudent(Student student){
        for (int i = 0; i < students.length; i++){
            if(students[i] == null){
                students[i] = student;
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName){
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                student.setFirstName(null);
                student.setLastName(null);
                for (int j = 0; j < student.getNumberOfExams(); j++) {
                    student.setExamScore(j, 0);
                }
                break;
            } else {
                System.out.println("Student is not longer present.");
            }
        }

        List<Student> studentList = Arrays.asList(students);
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if (student1.getFirstName() == null && student2.getFirstName() == null) {
                    return 0;
                }
                if (student1.getFirstName() == null) {
                    return 1;
                }
                if (student2.getFirstName() == null) {
                    return -1;
                }
                return student1.getLastName().compareTo(student2.getLastName());
            }
        });

    }

    public Student[] studentsByScore(){
        List<Student> studentList = new ArrayList<>(Arrays.asList(getStudents()));
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                int result = student2.getAverageExamScore().compareTo(student1.getAverageExamScore());
                if (result == 0) {
                    result = student1.getLastName().compareTo(student2.getLastName());
                }
                return result;
            }
        });
        return studentList.toArray(new Student[0]);
    }

    public Map<Student, String> getGradeBook(){
        Student[] sortedArr = this.studentsByScore();
        int numOfStudents = sortedArr.length;
        HashMap<Student, String> gradedBook = new HashMap<>();
        for (int i = 0; i < numOfStudents;i++){
            if (i <= (0.10 * numOfStudents)){
                gradedBook.put(sortedArr[i],"A");
            }
            else if (i >= (int)(0.11 * numOfStudents) && i <= (0.29 * numOfStudents)) {
                gradedBook.put(sortedArr[i],"B");
            }
            else if(i >= (0.30*numOfStudents) && i <= (0.50 * numOfStudents)) {
                gradedBook.put(sortedArr[i],"C");
            }
            else if(i >= (0.51*numOfStudents) && i <= (0.89 * numOfStudents)) {
                gradedBook.put(sortedArr[i],"D");
            }
            else{
                gradedBook.put(sortedArr[i],"F");
            }
        }
        return gradedBook;
    }
}

