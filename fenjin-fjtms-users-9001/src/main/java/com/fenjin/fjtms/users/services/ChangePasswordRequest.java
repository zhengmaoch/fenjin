package com.fenjin.fjtms.users.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 * @ClassName: ChangePasswordRequest
 * @Descriprion: TODO(修改密码请求对象)
 * @author: changzhengmao
 * @date: 2019-03-07 09:01
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ChangePasswordRequest implements Serializable {

    public String userId;
    public boolean validateRequest;
    public String oldPassword;
    public String newPassword;
}
