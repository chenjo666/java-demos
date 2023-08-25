package com.cj.design_principle.law_of_demeter.solution;

import java.util.List;

public class Clazz {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getPostgraduateCnt() {
        int ans = 0;
        for (Student student : students) {
            if (student.isPostgraduate()) {
                ans++;
            }
        }
        return ans;
    }
}
