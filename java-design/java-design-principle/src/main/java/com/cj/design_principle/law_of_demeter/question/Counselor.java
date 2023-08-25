package com.cj.design_principle.law_of_demeter.question;

import java.util.ArrayList;
import java.util.List;

public class Counselor {

    List<Clazz> clazzes;

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }
	
    public List<Integer> getPostgraduateCntByClazzes() {
        List<Integer> ans = new ArrayList<>();
        for (Clazz clazz : clazzes) {
            int cnt = 0;
            List<Student> students = clazz.getStudents();
            for (Student student : students) {
                if (student.isPostgraduate()) {
                    cnt++;
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}
