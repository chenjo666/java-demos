package com.cj.design_pattern.Filter.template;

import java.util.List;

public interface IFilter {
    List<Role> filter(List<Role> roles);

}
