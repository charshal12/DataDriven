package com.datadriven.rough;

import java.util.Date;

public class TimeStampImpl {

    public static void main(String[] args) {
        Date d = new Date();

        String dateTimeStamp = "SS_"+d.toString().replace(":","_").replace(" ","_")+".jpg";
        System.out.println(dateTimeStamp);
        System.out.println(d);
        System.out.println(System.getProperty("user.dir"));


    }
}
