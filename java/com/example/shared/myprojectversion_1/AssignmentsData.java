package com.example.shared.myprojectversion_1;

public class AssignmentsData {

    private String uid,subject,assignmentNo,description,postedBy,Semester;

    public AssignmentsData() {
    }

    public AssignmentsData(String uid, String subject, String assignmentNo, String description, String postedBy, String semester) {
        this.uid = uid;
        this.subject = subject;
        this.assignmentNo = assignmentNo;
        this.description = description;
        this.postedBy = postedBy;
        Semester = semester;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAssignmentNo() {
        return assignmentNo;
    }

    public void setAssignmentNo(String assignmentNo) {
        this.assignmentNo = assignmentNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }
}
