package com.fenjin.fjtms.users.controllers;


import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.users.FenjinFjtmsUsers9001Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FenjinFjtmsUsers9001Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class UserControllerTests {

//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    @Transactional//测试环境下将自动进行回滚操作
//    //@Rollback(false)
//    public void getTest() throws Exception {
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/get/4028118169321475016932168a470000");
//        request.("name","laiminghai");
//        mvc.perform(request).
//                andExpect(MockMvcResultMatchers.status().isOk()).
//                andExpect(MockMvcResultMatchers.content().string("{\"code\":200,\"message\":\"操作成功\",\"data\":\"操作成功\"}"));
//    }

//    @LocalServerPort
//    private int port;
//
//    private URL base;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Before
//    public void setUp() throws Exception {
//        String url = String.format("http://localhost:%d/", port);
//        System.out.println(String.format("port is : [%d]", port));
//        this.base = new URL(url);
//    }
//
//    @Test
//    public void getTest() throws Exception {
//
//        User result = this.restTemplate.getForObject(this.base.toString() + "/users/get/4028118169321475016932168a470000", User.class);
//        System.out.println(String.format("测试结果为：%s", result));
//    }

//    @Test
//    public void addTest() throws Exception {
//
//        User user1 = new User();
//        user1.setName("李四");
//        user1.setDatabaseName("clouddb01");
//
//        String result = this.restTemplate.postForObject(this.base.toString() + "/user/add", user1, String.class);
//        System.out.println(String.format("测试结果为：%s", result));
//    }
//
//    @Test
//    public void getAllTest() throws Exception {
//
//        List<User> list = this.restTemplate.getForObject(this.base.toString() + "/user/list", List.class);
//        System.out.println(String.format("测试结果为：%s", list));
//    }
//
//    @Test
//    public void deleteTest() throws Exception {
//
//        this.restTemplate.put(this.base.toString() + "/user/deleteUser/1", Object.class);
//    }

}
