package com.fenjin.fjtms.core.domain.users;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @version 1.0
 * @ClassName: UserRoles
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-12 14:54
 */
@Entity
@Table(name = "userroles")
@Accessors(chain = true)
@Data
public class UserRoles implements Serializable {

    @Basic
    @Column(name = "UserId")
    private String userId;

    @Basic
    @Column(name = "RoleId")
    private String roleId;
}
