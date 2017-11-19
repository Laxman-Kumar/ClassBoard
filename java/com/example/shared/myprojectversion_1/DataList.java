package com.example.shared.myprojectversion_1;


import java.util.ArrayList;
import java.util.List;

public class DataList {
  //  static String[] sem5_subjects = {"select subject","SE", "AAD", "CN", "MAP", "WAD", "BI", "CCE", "UED", "DSM"};

    static private ArrayList<List<String>> sub;
    static private ArrayList<String> sem;
    static ArrayList<String> club;

    static ArrayList<String> getSemesterList(){
        sem = new ArrayList<>();
        sem.add("Select semester");
        sem.add("Sem 1");
        sem.add("Sem 2");
        sem.add("Sem 3");
        sem.add("Sem 4");
        sem.add("Sem 5");
        sem.add("Sem 6");
        sem.add("Sem 7");
        sem.add("Sem 8");
        return sem;
    }

    static ArrayList<String> getClubName(){

        club = new ArrayList<>();
        club.add("select club");
        club.add("Academics Club");
        club.add("Cultural Club");
        club.add("Debate/ Elocution Club");
        club.add("General");
        club.add("Science & Tech Club");
        club.add("Sports Club");
        club.add("Student Publication");

        return club;

    }


    static private ArrayList<String> getSemesterZero(){
        ArrayList<String> semsubjects = new ArrayList<>();
        semsubjects.add(" ");
        return semsubjects;

    }
    static private ArrayList<String> getSemester1(){
        ArrayList<String> sem1_subjects = new ArrayList<>();
        sem1_subjects.add("Basic Electronics");
        sem1_subjects.add("Calculus");
        sem1_subjects.add("Digital Electronics");
        sem1_subjects.add("Essentials of Software Foundation & Programming - I");
        sem1_subjects.add("Internet Programming");

        return sem1_subjects;
    }
    static private ArrayList<String> getSemester2(){
        ArrayList<String> sem2_subjects = new ArrayList<>();
        sem2_subjects.add("Aptitude Skill Building");
        sem2_subjects.add("Basics of Communication System");
        sem2_subjects.add("Basics of Operating System and Scripting");
        sem2_subjects.add("Computer Organisation");
        sem2_subjects.add("Essentials of Software Foundation & Programming - II");
        sem2_subjects.add("Linear Algebra");

        return sem2_subjects;
    }
    static private ArrayList<String> getSemester3(){
        ArrayList<String> sem3_subjects = new ArrayList<>();
        sem3_subjects.add("Application Development - I");
        sem3_subjects.add("Applied Engineering Mathematics");
        sem3_subjects.add("Data Structures");
        sem3_subjects.add("Database Management System");
        sem3_subjects.add("Economics for Engineers");
        sem3_subjects.add("Object Oriented Programming");

        return sem3_subjects;
    }
    static private ArrayList<String> getSemester4(){
        ArrayList<String> sem4_subjects = new ArrayList<>();
        sem4_subjects.add("Application Development - II");
        sem4_subjects.add("Functional Programming");
        sem4_subjects.add("Microprocessor & Microcontroller");
        sem4_subjects.add("Operating Systems");
        sem4_subjects.add("Probability & Statistics");
        sem4_subjects.add("Technical Communication");
        sem4_subjects.add("Web Technology");

        return sem4_subjects;
    }
    static private ArrayList<String> getSemester5(){
        ArrayList<String> sem5_subjects = new ArrayList<>();

        sem5_subjects.add("Algorithm Analysis & Design");
        sem5_subjects.add("Business Intelligence");
        sem5_subjects.add("Cloud Computing Essentials");
        sem5_subjects.add("Computer Networks");
        sem5_subjects.add("Data Science and Analytics");
        sem5_subjects.add("Mobile Application Programming");
        sem5_subjects.add("Software Engineering");
        sem5_subjects.add("User Experience Design");
        sem5_subjects.add("Web Application Development");

        return sem5_subjects;
    }
    static private ArrayList<String> getSemester6(){
        ArrayList<String> sem6_subjects = new ArrayList<>();
        sem6_subjects.add("ndasd");
        sem6_subjects.add("sdsd");

        return sem6_subjects;
    }
    static private ArrayList<String> getSemester7(){
        ArrayList<String> sem7_subjects = new ArrayList<>();
        sem7_subjects.add("Advanced Big Data Analytics");
        sem7_subjects.add("Advanced Business Intelligence");
        sem7_subjects.add("Big Data Application Development");
        sem7_subjects.add("Cloud Application Development");
        sem7_subjects.add("Compiler Design");
        sem7_subjects.add("Internet Of Things");
        sem7_subjects.add("Machine Learning");
        sem7_subjects.add("Mobile Application Development");
        sem7_subjects.add("R Programming");
        sem7_subjects.add("Service Oriented Computing");
        sem7_subjects.add("Swift Programming");
        sem7_subjects.add("Virtualisation");


        return sem7_subjects;
    }
    static private ArrayList<String> getSemester8(){
        ArrayList<String> sem8_subjects = new ArrayList<>();
        sem8_subjects.add("ndasd");
        sem8_subjects.add("sdsd");

        return sem8_subjects;
    }

    static List<String> getSubject(int i){

        sub = new ArrayList<List<String>>();
        sub.add(getSemesterZero());
        sub.add(getSemester1());
        sub.add(getSemester2());
        sub.add(getSemester3());
        sub.add(getSemester4());
        sub.add(getSemester5());
        sub.add(getSemester6());
        sub.add(getSemester7());
        sub.add(getSemester8());
        return sub.get(i);
    }
}
