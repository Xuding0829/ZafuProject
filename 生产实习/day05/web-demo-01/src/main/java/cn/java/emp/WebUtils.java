package cn.java.emp;

import java.time.LocalDateTime;

//工具类
//目的返回字符串 当前年/月/日
//今天         2024/6/30
public class WebUtils {
    public static String getYearMonthDay() {
        //如何得到当前的日期
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        int monthValue = localDateTime.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        String yearMonthDay = year + "/" + monthValue + "/" + dayOfMonth + "/";
        return yearMonthDay;
    }
}
