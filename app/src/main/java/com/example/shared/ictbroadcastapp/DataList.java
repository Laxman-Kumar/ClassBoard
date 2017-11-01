package com.example.shared.ictbroadcastapp;


import java.util.ArrayList;
import java.util.List;

public class DataList {
  //  static String[] sem5_subjects = {"select subject","SE", "AAD", "CN", "MAP", "WAD", "BI", "CCE", "UED", "DSM"};

    static private ArrayList<List<String>> sub;
    static private ArrayList<String> sem;

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

    static private ArrayList<String> getSemesterZero(){
        ArrayList<String> semsubjects = new ArrayList<>();
        semsubjects.add(" ");
        return semsubjects;

    }
    static private ArrayList<String> getSemester1(){
        ArrayList<String> sem1_subjects = new ArrayList<>();
        sem1_subjects.add("select subject");
        sem1_subjects.add("ndasd");
        sem1_subjects.add("sdsd");

        return sem1_subjects;
    }
    static private ArrayList<String> getSemester2(){
        ArrayList<String> sem2_subjects = new ArrayList<>();
        sem2_subjects.add("ndasd");
        sem2_subjects.add("sdsd");

        return sem2_subjects;
    }
    static private ArrayList<String> getSemester3(){
        ArrayList<String> sem3_subjects = new ArrayList<>();
        sem3_subjects.add("ndasd");
        sem3_subjects.add("sdsd");

        return sem3_subjects;
    }
    static private ArrayList<String> getSemester4(){
        ArrayList<String> sem4_subjects = new ArrayList<>();
        sem4_subjects.add("ndasd");
        sem4_subjects.add("sdsd");

        return sem4_subjects;
    }
    static private ArrayList<String> getSemester5(){
        ArrayList<String> sem5_subjects = new ArrayList<>();
        sem5_subjects.add("ndasd");
        sem5_subjects.add("sdsd");

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
        sem7_subjects.add("ndasd");
        sem7_subjects.add("sdsd");

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
