package cn.java.emp;

import java.time.LocalDateTime;

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

    public static void main(String args[]){
        System.out.println(getYearMonthDay());
    }
}
