package com.fenjin.cloud.cotrollers;

import com.fenjin.fjtms.core.domain.users.User;
import com.fenjin.fjtms.core.services.users.IUserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserClientService userClientService;

    @PostMapping("/create")
    public void create(User user){

        userClientService.create(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){

        userClientService.delete(id);
    }

    @PutMapping("/edit")
    public void edit(User user){

        userClientService.edit(user);
    }

    @RequestMapping("/list")
    public List<User> list(){

        return userClientService.list();
    }

    @RequestMapping("/get/{id}")
    public User get(@PathVariable("id") String id){

        return userClientService.get(id);
    }


//    配置本地访问地址
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
//    配置微服务访问地址
//    private static final String REST_URL_PREFIX = "http://FENJIN-SERVICES-USERS";
//
//    // 采用RestTemplate的方式访问微服务
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @PostMapping("/add")
//    public boolean add(User user){
//
//        return restTemplate.postForObject(REST_URL_PREFIX + "/user/add", user, Boolean.class);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public boolean delete(@PathVariable("id") Long id){
//
//        return restTemplate.postForObject(REST_URL_PREFIX + "/user/delete", id, Boolean.class);
//    }
//
//    @PutMapping("/update")
//    public User update(User user){
//
//        return restTemplate.postForObject(REST_URL_PREFIX + "/user/update", user, User.class);
//    }
//
//    @GetMapping("/list")
//    public List<User> list(){
//
//        return restTemplate.getForObject(REST_URL_PREFIX + "/user/list", List.class);
//    }
//
//    @GetMapping("/get/{id}")
//    public User get(@PathVariable("id") Long id){
//
//        return restTemplate.getForObject(REST_URL_PREFIX + "/user/get" + id, User.class);
//    }
//
//    @GetMapping("/discovery")
//    public Object discovery(){
//
//        return restTemplate.getForObject(REST_URL_PREFIX + "/user/discovery", Object.class);
//    }
}
