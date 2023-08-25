package com.cj.design_principle.law_of_demeter.question;

import java.util.List;

public class Clazz {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
