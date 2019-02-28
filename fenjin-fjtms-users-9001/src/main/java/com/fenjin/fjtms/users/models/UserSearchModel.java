package com.fenjin.fjtms.users.models;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Data
@ApiModel(value = "UserSearchModel", description = "用户查询条件对象")
public class UserSearchModel implements Serializable {

    public List<String> selectedCustomerRoleIds;
    public Date searchCreatedFrom;
    public Date searchCreatedTo;
    public String searchEmail;
    public String searchUsername;
    public String searchFullname;
    public String searchDepartmentId;
    public String searchPhone;
    public String searchIpAddress;
    public Date searchLastActivityFrom;

    public UserSearchModel(){
        selectedCustomerRoleIds = new ArrayList<>();
    }
}
