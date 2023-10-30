package com.cj.codeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/code")
public class CodeController {
    private final Map<Long, Object> codes = new HashMap<>();
    {
        Map<String, Object> code1 = new HashMap<>();
        code1.put("code_id", 1);
        code1.put("code_name", "两数之和");
        code1.put("code_type", "哈希表/...");
        Map<String, Object> code2 = new HashMap<>();
        code2.put("code_id", 2);
        code2.put("code_name", "三树之和");
        code2.put("code_type", "哈希表/双指针/...");
        codes.put(1L, code1);
        codes.put(2L, code2);
    }
    @GetMapping("/v1/{codeId}")
    public Object getCode(@PathVariable("codeId") Long codeId) {
        return codes.getOrDefault(codeId, new HashMap<>());
    }
}
