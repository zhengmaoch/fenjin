package com.fenjin.fjtms.core;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName: RequestBodyList
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-14 15:17
 */
@Data
public class RequestBodyList<T> implements Serializable {

    private List<T> lists = new ArrayList<>();
}
