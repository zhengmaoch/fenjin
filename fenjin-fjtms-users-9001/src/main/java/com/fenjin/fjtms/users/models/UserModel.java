package com.fenjin.fjtms.users.models;

import com.fenjin.fjtms.core.domain.users.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName: UserModel
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-13 16:15
 */
@Data
@EqualsAndHashCode
public class UserModel extends User {

    private List<String> roleIds = new ArrayList<>();
}
