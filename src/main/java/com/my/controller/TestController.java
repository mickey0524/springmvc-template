package com.my.controller;

import com.my.dto.IdDto;
import com.my.result.ResponseEntity;
import com.my.result.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value = "/test_get", method = RequestMethod.GET)
    public ResponseEntity test() {
        return ResponseEntity.ok();
    }

    @RequestMapping(value = "/test_post", method = RequestMethod.POST)
    public ResponseEntity<Student> test(@RequestBody IdDto idDto) {
        return ResponseEntity.successWithData(new Student("test"));
    }
}
