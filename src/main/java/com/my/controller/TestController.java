package com.my.controller;

import com.my.common.RedisCacheManager;
import com.my.dto.IdDto;
import com.my.dto.KvPair;
import com.my.dto.Student;
import com.my.mybatis.dao.StudentDao;
import com.my.result.ResponseEntity;
import com.my.result.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisCacheManager redisCacheManager;

    @RequestMapping(value = "/test_get", method = RequestMethod.GET)
    public ResponseEntity testGet() {
        return ResponseEntity.ok();
    }

    @RequestMapping(value = "/test_get_param", method = RequestMethod.GET)
    public ResponseEntity testGet(@RequestParam(value = "id", defaultValue = "10") long id) {
        return ResponseEntity.successWithData(id);
    }

    @RequestMapping(value = "/test_get_param_v1", method = RequestMethod.GET)
    public ResponseEntity testGet(IdDto idDto) {
        return ResponseEntity.successWithData(idDto.getId());
    }

    @RequestMapping(value = "/test_get_path/{id}", method = RequestMethod.GET)
    public ResponseEntity testGetPath(@PathVariable("id") long id) {
        return ResponseEntity.successWithData(id);
    }

    @RequestMapping(value = "/test_post", method = RequestMethod.POST)
    public ResponseEntity<Person> testPost(IdDto idDto) {
        return ResponseEntity.successWithData(new Person("test"));
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity testUpload(@RequestPart("pic") MultipartFile pic, IdDto idDto) throws IOException {
        pic.transferTo(new File("pic " + pic.getOriginalFilename()));
        return ResponseEntity.successWithData(idDto.getId());
    }

    @RequestMapping(value = "/test_raw_mysql", method = RequestMethod.POST)
    public ResponseEntity testRawSql(@RequestBody Student student) {
        String sql = "insert into student(name, age) values (?, ?)";
        jdbcOperations.update(sql, student.getName(), student.getAge());
        return ResponseEntity.ok();
    }

    @RequestMapping(value = "/test_mybatis_get_student_v1", method = RequestMethod.GET)
    public ResponseEntity testMybatisGetStudentV1(IdDto idDto) {
        return ResponseEntity.successWithData(studentDao.select(54));
    }

    @RequestMapping(value = "/test_set_redis", method = RequestMethod.POST)
    public ResponseEntity testSetRedis(@RequestBody KvPair kvPair) {
        stringRedisTemplate.opsForValue().set(kvPair.getKey(), kvPair.getValue());

        return ResponseEntity.successWithData(stringRedisTemplate.opsForValue().get(kvPair.getKey()));
    }

    @RequestMapping(value = "/test_redis_manager", method = RequestMethod.POST)
    public ResponseEntity testRedisManager(@RequestBody KvPair kvPair) {
        redisCacheManager.set(kvPair.getKey(), kvPair.getValue());

        return ResponseEntity.successWithData(redisCacheManager.get(kvPair.getKey()));
    }
}
