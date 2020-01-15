package com.tgy.classloaderdemo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-25 17:50
 **/

public class TestOffen {
    public static void main(String[] args) throws ParseException {
        Date date1=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start = sdf.format(date1);
        System.out.println(start);
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDate localDate = date.plusYears(99l);
        System.out.println(localDate);
        String lastTime=start.substring(10,start.length());
        System.out.println(lastTime);
        Date d = sdf.parse(start);
        System.out.println(d);

        BigDecimal bigDecimal=new BigDecimal(123455.55);
        System.out.println(bigDecimal.divide(BigDecimal.valueOf(100)));
        System.out.println(bigDecimal.doubleValue()/100);
    }
}
