package com.cj.design_principle.law_of_demeter.question;

public class Student {
    private boolean isPostgraduate;

    public boolean isPostgraduate() {
        return isPostgraduate;
    }

    public void setPostgraduate(boolean postgraduate) {
        isPostgraduate = postgraduate;
    }
}
