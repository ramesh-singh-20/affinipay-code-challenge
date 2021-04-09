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

        //Adding the above calculated hours and minutes to the given time's hours and minutes.
        hours= hours+hoursToBeAdded;
        minutes= minutes+minutesToBeAdded;

        //Setting the meridian
        if(hours>= 12 && meridian.equalsIgnoreCase("AM")){
            meridian= "PM";
        }else if(hours>= 12 && meridian.equalsIgnoreCase("PM")){
            meridian= "AM";
        }

        if(hours>12){
            hours= hours%12;
        }

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
}
