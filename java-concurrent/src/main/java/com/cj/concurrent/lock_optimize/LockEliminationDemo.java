package com.cj.concurrent.lock_optimize;

public class LockEliminationDemo {
    public static void main(String[] args) {

    }
    public String concatString(String a, String b) {
        StringBuffer sb = new StringBuffer();
        sb.append(a);
        sb.append(b);
        return sb.toString();
    }
    public int calSum(int ...a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
