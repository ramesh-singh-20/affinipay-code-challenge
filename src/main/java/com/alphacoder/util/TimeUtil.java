package com.alphacoder.util;

public class TimeUtil {
    public static String addMinutes(String time, int minutesToAdd){

        //Splitting time and meridian parts.
        String [] splitTimeMeridian= time.split(" ");

        //Splitting hours and minutes from the time part.
        String [] splitHoursMinutes= splitTimeMeridian[0].split(":");
        String meridian= splitTimeMeridian[1];

        String hoursString= splitHoursMinutes[0];
        String minutesString= splitHoursMinutes[1];

        //Converting hours and minutes to integer values.
        int hours= Integer.valueOf(hoursString);
        int minutes= Integer.valueOf(minutesString);

        //Converting the given minutesToAdd into hours and minutes that needs to be added in the given input time.
        int hoursToBeAdded= (minutesToAdd)/60;
        int minutesToBeAdded= (minutesToAdd)%60;

        //Converting the hour part into 24 hour format.
        if(meridian.equalsIgnoreCase("AM")){
            if(hours== 12){
                hours= 0;
            }
        }else if(meridian.equalsIgnoreCase("PM")){
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

        if(minutes<0){
            hours= hours-1;
            minutes = 60- Math.abs(minutes);
        }

        hours= hours%24;

        if(hours<0){
            hours= 24-Math.abs(hours);
        }

        if(hours<12){
            meridian= "AM";
        }else if(hours>=12){
            meridian= "PM";
        }

        hours= mapTwentyFourHourToTwelveHourFormat(hours);

        //Getting the String values for the hours and minutes.
        hoursString= String.valueOf(hours);
        minutesString= String.valueOf(minutes);

        //Making sure minutesString is 2 digits.
        if(minutes<10){
            minutesString= "0"+minutesString;
        }

        //returning back the timeString.
        return hoursString+":"+minutesString+ " "+meridian;
    }

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
