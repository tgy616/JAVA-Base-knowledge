package com.tgy.knowledge;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * jdk8日期相关的处理
 *  1、获取今天的日期
 *
 * 2、指定日期，进行相应操作
 *
 * 3、生日检查或者账单日检查
 *
 * 4、获取当前的时间
 *
 * 5、日期前后比较
 *
 * 6、处理不同时区的时间
 *
 * 7、比较两个日期之前时间差
 *
 * 8、日期时间格式解析、格式化
 *
 * 9、java8 时间类与Date类的相互转化
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-10-17 13:51
 **/

public class JDK8DateDeal {
    /**
     * 在java8中，java.time包下主要包含下面几个主要的类：
     *
     * Instant：时间戳
     * Duration：持续时间，时间差
     * LocalDate：只包含日期，比如：2016-10-20
     * LocalTime：只包含时间，比如：23:12:10
     * LocalDateTime：包含日期和时间，比如：2016-10-20 23:14:21
     * Period：时间段
     * ZoneOffset：时区偏移量，比如：+8:00
     * ZonedDateTime：带时区的时间
     * Clock：时钟，比如获取目前美国纽约的时间
     * 以及java.time.format包中的DateTimeFormatter：时间格式化
     */
    public static void main(String[] args) {
        //=1、获取今天的日期
        LocalDate todayDate = LocalDate.now();
        System.out.println("今天的日期："+todayDate);

        //2、指定日期，进行相应操作
        //取2019年10月的第1天
        LocalDate firstDay = todayDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDay);
        //取2019年10月的第1天，另外一种写法
        LocalDate firstDay2 = todayDate.withDayOfMonth(1);
        System.out.println(firstDay2);
        //取2019年10月的最后1天，不用考虑大月，小月，平年，闰年
        LocalDate lastDay = todayDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);
        //当前日期＋1天
        LocalDate tomorrow = todayDate.plusDays(1);
        System.out.println(tomorrow);
        //判断是否为闰年
        boolean isLeapYear = tomorrow.isLeapYear();
        System.out.println(isLeapYear);

        //3、生日检查或者账单日检查
        LocalDate birthday = LocalDate.of(1990, 10, 12);
        MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay today = MonthDay.from(LocalDate.of(2019, 10, 12));
        System.out.println(today.equals(birthdayMd));

        //4、获取当前的时间
        //获取当前的时间
        LocalTime nowTime = LocalTime.now(); //结果14:29:40.558
        // 如果不想显示毫秒
        LocalTime nowTime2 = LocalTime.now().withNano(0); //14:43:14
        //指定时间
        LocalTime time = LocalTime.of(14, 10, 21); //14:10:21
        LocalTime time2 = LocalTime.parse("12:00:01"); // 12:00:01
        //当前时间增加2小时
        LocalTime nowTimePlus2Hour = nowTime.plusHours(2); //16:47:23.144
        //或者
        LocalTime nowTimePlus2Hour2 = nowTime.plus(2, ChronoUnit.HOURS);

        // 5、日期前后比较
        //比较2个日期哪个在前，哪个在后，java8 LocalDate提供了2个方法，isAfter(),isBefore
        LocalDate today2= LocalDate.now();
        LocalDate specifyDate = LocalDate.of(2015, 10, 20);
        System.out.println(today2.isAfter(specifyDate)); //true

        //6、处理不同时区的时间
        //查看当前的时区
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println(defaultZone); //Asia/Shanghai

        //查看美国纽约当前的时间
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime shanghaiTime = LocalDateTime.now();
        LocalDateTime americaDateTime = LocalDateTime.now(america);
        System.out.println(shanghaiTime); //2016-11-06T15:20:27.996
        System.out.println(americaDateTime); //2016-11-06T02:20:27.996 ，可以看到美国与北京时间差了13小时

        //带有时区的时间
        ZonedDateTime americaZoneDateTime = ZonedDateTime.now(america);
        System.out.println(americaZoneDateTime); //2016-11-06T02:23:44.863-05:00[America/New_York]

        //7、比较两个日期之前时间差
        LocalDate today3 = LocalDate.now();
        LocalDate specifyDate3 = LocalDate.of(2015, 10, 2);
        Period period = Period.between(specifyDate, today3);

        System.out.println(period.getDays());  //4
        System.out.println(period.getMonths()); //1
        System.out.println(specifyDate.until(today3, ChronoUnit.DAYS)); //401
        /*
        * 我们可以看到，我们使用Period类比较天数，比较奇怪，他返回的值，并不是2个日期之间总共的天数差，
        * 而是一个相对天数差，比如，5月1日，和10月2日，他比较的是仅仅2个天之间的差，那1号和2号，相差1天，
        * 而实际上，因为中间相差了好几个月，所以真正的天数差肯定不是1天，所以我们可以使用until，
        * 并指明精度单位是days，就可以计算真正的天数差了。
        * */


        //8、日期时间格式解析、格式化
        String specifyDate4 = "20151011";
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate formatted = LocalDate.parse(specifyDate4,formatter);
        System.out.println(formatted);
        //输出 2015-10-11
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY MM dd");
        System.out.println(formatter2.format(LocalDate.now()));
        //结果 2015 10 11

        //9、java8 时间类与Date类的相互转化
        /*在转换中，我们需要注意，因为java8之前Date是包含日期和时间的，而LocalDate只包含日期，LocalTime只包含时间，
        所以与Date在互转中，势必会丢失日期或者时间，或者会使用起始时间。如果转LocalDateTime，那么就不存在信息误差。
        */
        //Date与Instant的相互转化
        Instant instant  = Instant.now();
        Date date = Date.from(instant);
        Instant instant2 = date.toInstant();

        //Date转为LocalDateTime
        Date date2 = new Date();
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(date2.toInstant(), ZoneId.systemDefault());

        //LocalDateTime转Date
        LocalDateTime localDateTime3 = LocalDateTime.now();
        Instant instant3 = localDateTime3.atZone(ZoneId.systemDefault()).toInstant();
        Date date3 = Date.from(instant);

        //LocalDate转Date
        //因为LocalDate不包含时间，所以转Date时，会默认转为当天的起始时间，00:00:00
        LocalDate localDate4 = LocalDate.now();
        Instant instant4 = localDate4.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date4 = Date.from(instant);


//************************************************************************************
        //LocalDateTime 获取年月日时分秒，等于LocalDate+LocalTime
        LocalDate localDate = LocalDate.now(); //获取当前年月日
        LocalTime localTime= LocalTime.now();//只会获取几点几分几秒
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1_ = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime localDateTime2_ = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime3_ = localDate.atTime(localTime);
        LocalDateTime localDateTime4_ = localTime.atDate(localDate);
        System.out.println(localDate);
//      Instant 获取秒数
        Instant instantX = Instant.now();
        long currentSecond = instantX.getEpochSecond();
        long currentMilli = instant.toEpochMilli();//个人觉得如果只是为了获取秒数或者毫秒数，使用System.currentTimeMillis()来得更为方便

        /*******************
        SpringBoot中应用LocalDateTime

        将LocalDateTime字段以时间戳的方式返回给前端 添加日期转化类

        public class LocalDateTimeConverter extends JsonSerializer<LocalDateTime> {

            @Override
            public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeNumber(value.toInstant(ZoneOffset.of("+8")).toEpochMilli());
            }
        }
        并在

                LocalDateTime
        字段上添加

        @JsonSerialize(using = LocalDateTimeConverter.class)
        注解，如下：

        @JsonSerialize(using = LocalDateTimeConverter.class)
        protected LocalDateTime gmtModified;
        将LocalDateTime字段以指定格式化日期的方式返回给前端 在

        LocalDateTime
                字段上添加

        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
        注解即可，如下：

        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
        protected LocalDateTime gmtModified;
        对前端传入的日期进行格式化 在

        LocalDateTime
                字段上添加

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        注解即可，如下：

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        protected LocalDateTime gmtModified;
        **/

    }



















}
