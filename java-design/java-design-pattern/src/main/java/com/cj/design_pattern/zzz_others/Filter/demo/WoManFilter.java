package com.cj.design_pattern.zzz_others.Filter.demo;

import java.util.LinkedList;
import java.util.List;

public class WoManFilter implements IHumanFilter {
    @Override
    public List<Human> humanFilter(List<Human> humans) {
        List<Human> ans = new LinkedList<>();
        for (Human human : humans) {
            if (human.getGender().equals("女")) {
                ans.add(human);
            }
        }
        return ans;
    }
}
