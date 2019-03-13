package com.fenjin.fjtms.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @ClassName: DateUtils
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-13 21:08
 */
public class DateUtils {

    public static String toString(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static Date toDate(String date) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(date);
    }
}
