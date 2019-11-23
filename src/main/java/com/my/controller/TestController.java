package com.my.controller;

import com.my.dto.IdDto;
import com.my.result.ResponseEntity;
import com.my.result.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value = "/test_get", method = RequestMethod.GET)
    public ResponseEntity test_get() {
        return ResponseEntity.ok();
    }

    @RequestMapping(value = "/test_get_param", method = RequestMethod.GET)
    public ResponseEntity test_get(@RequestParam(value = "id", defaultValue = "10") long id) {
        return ResponseEntity.successWithData(id);
    }

    @RequestMapping(value = "/test_get_param_v1", method = RequestMethod.GET)
    public ResponseEntity test_get(IdDto idDto) {
        return ResponseEntity.successWithData(idDto.getId());
    }

    @RequestMapping(value = "/test_get_path/{id}", method = RequestMethod.GET)
    public ResponseEntity test_get_path(@PathVariable("id") long id) {
        return ResponseEntity.successWithData(id);
    }

    @RequestMapping(value = "/test_post", method = RequestMethod.POST)
    public ResponseEntity<Student> test_post(IdDto idDto) {
        return ResponseEntity.successWithData(new Student("test"));
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity test_upload(@RequestPart("pic") MultipartFile pic, IdDto idDto) throws IOException {
        pic.transferTo(new File("pic " + pic.getOriginalFilename()));
        return ResponseEntity.successWithData(idDto.getId());
    }
}
