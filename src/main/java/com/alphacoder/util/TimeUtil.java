package com.alphacoder.util;

public class TimeUtil {
    public static String addMinutes(String time, int minutesToAdd){

        //Splitting time and meridiem parts.
        String [] splitTimeMeridiem= time.split(" ");

        //Splitting hours and minutes from the time part.
        String [] splitHoursMinutes= splitTimeMeridiem[0].split(":");
        String meridiem= splitTimeMeridiem[1];

        String hoursString= splitHoursMinutes[0];
        String minutesString= splitHoursMinutes[1];

        //Converting hours and minutes to integer values so that arithmetic operations can be performed on them.
        int hours= Integer.valueOf(hoursString);
        int minutes= Integer.valueOf(minutesString);

        //Converting the given minutesToAdd into hours and minutes that needs to be added in the given input time.
        int hoursToBeAdded= (minutesToAdd)/60;
        int minutesToBeAdded= (minutesToAdd)%60;

        /*Converting the hour part into 24 hour format.
        if given time is AM no need to do anything except when hour is 12, change it to 0.
        if given time is PM add 12 hours to given hour except when hour is 12.
         */
        if(meridiem.equalsIgnoreCase("AM")){
            if(hours== 12){
                hours= 0;
            }
        }else if(meridiem.equalsIgnoreCase("PM")){
            if(hours!=12){
                hours+=12;
            }
        }

        //Adding the above calculated hours and minutes to the given time's hours and minutes.
        hours= hours+hoursToBeAdded;
        minutes= minutes+minutesToBeAdded;

        //Checking if minutes are greater than 60, if yes convert them to hours.
        if(minutes>59){
            hours=hours+(minutes/60);
            minutes= minutes%60;
        }

        /*Checking if minutes are less than 0, if yes subtract 1 from hour and absolute value of
        minutes will be subtracted from 60. This will be applicable only in case minutesToAdd is -ve.
        */
        if(minutes<0){
            hours= hours-1;
            minutes = 60- Math.abs(minutes);
        }

        //The calculated hour should be within 0-23 range.
        hours= hours%24;

        /*
        This will be applicable only in case minutesToAdd is -ve. If calculated hours becomes less than 0, subtract
        the absolute value of hour from 24.
         */
        if(hours<0){
            hours= 24-Math.abs(hours);
        }

        //Setting the meridiem part of the resulting time string.
        if(hours<12){
            meridiem= "AM";
        }else if(hours>=12){
            meridiem= "PM";
        }

        //Getting the 12 hour format since hour is in 24 hour format.
        hours= mapTwentyFourHourToTwelveHourFormat(hours);

        //Getting the String values for the hours and minutes, since return time should be string.
        hoursString= String.valueOf(hours);
        minutesString= String.valueOf(minutes);

        //Making sure minutesString is 2 digits. If not prepending a '0' to it.
        if(minutes<10){
            minutesString= "0"+minutesString;
        }

        //returning back the timeString.
        return hoursString+":"+minutesString+ " "+meridiem;
    }

    /*
    @Input: twentyHourFormat: Hour in 24 hour format
    @return: TwelveHour Format hour for the given 24 hour format hour
     */
    private static int mapTwentyFourHourToTwelveHourFormat(int twentyHourFormat){
        switch (twentyHourFormat){
            case 0:
            case 12:
                return 12;
            case 1:
            case 13:
                return 1;
            case 2:
            case 14:
                return 2;
            case 3:
            case 15:
                return 3;
            case 4:
            case 16:
                return 4;
            case 5:
            case 17:
                return 5;
            case 6:
            case 18:
                return 6;
            case 7:
            case 19:
                return 7;
            case 8:
            case 20:
                return 8;
            case 9:
            case 21:
                return 9;
            case 10:
            case 22:
                return 10;
            case 11:
            case 23:
                return 11;
            default:
                return -1;
        }
    }
}
