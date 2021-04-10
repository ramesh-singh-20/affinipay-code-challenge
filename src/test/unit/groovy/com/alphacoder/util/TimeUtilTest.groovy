package com.alphacoder.util

import spock.lang.Specification

class TimeUtilTest extends Specification{

    //Positive minutesToAdd test cases starts here.
    def 'Test TimeUtil | addMinutes() | Given time is AM'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= 200

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="12:33 PM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is PM'(){
        given:
        def inputTimeString= "9:13 PM"
        def minutesToAdd= 200

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="12:33 AM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is PM and resulting time greater than 12'(){
        given:
        def inputTimeString= "9:13 PM"
        def minutesToAdd= 320

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="2:33 AM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is AM and resulting time greater than 12'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= 320

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="2:33 PM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is PM and minutes added is equal to 12 hours'(){
        given:
        def inputTimeString= "9:13 PM"
        def minutesToAdd= 720

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="9:13 AM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is PM and minutes added is equal to 24 hours'(){
        given:
        def inputTimeString= "9:13 PM"
        def minutesToAdd= 1440

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="9:13 PM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is AM and minutes added is equal to 12 hours'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= 720

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="9:13 PM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is AM and minutes added is equal to 24 hours'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= 1440

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="9:13 AM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is AM and minutes added is greater than 24 hours'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= 2000

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="6:33 PM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is PM and minutes added is greater than 24 hours'(){
        given:
        def inputTimeString= "10:23 PM"
        def minutesToAdd= 2000

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="7:43 AM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is AM and minutes added is greater than 36 hours'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= 2180

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="9:33 PM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is PM and minutes added is greater than 36 hours'(){
        given:
        def inputTimeString= "10:23 PM"
        def minutesToAdd= 2180

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="10:43 AM"
    }
    def 'Test TimeUtil | addMinutes() | Given time is AM and minutes added is greater than 48 hours'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= 3030

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="11:43 AM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is PM and minutes added is greater than 48 hours'(){
        given:
        def inputTimeString= "10:23 PM"
        def minutesToAdd= 3030

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="12:53 AM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is 12 AM '(){
        given:
        def inputTimeString= "12:13 AM"
        def minutesToAdd= 280

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="4:53 AM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is in PM | minutes greater than 60'(){
        given:
        def inputTimeString= "12:13 PM"
        def minutesToAdd= 290

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="5:03 PM"
    }



    def 'Test TimeUtil | addMinutes() | Given time is in AM | minutes greater than 60'(){
        given:
        def inputTimeString= "12:13 AM"
        def minutesToAdd= 290

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="5:03 AM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is in PM | hours to add zero'(){
        given:
        def inputTimeString= "12:13 PM"
        def minutesToAdd= 20

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="12:33 PM"
    }



    def 'Test TimeUtil | addMinutes() | Given time is in AM | hours to add zero'(){
        given:
        def inputTimeString= "12:13 AM"
        def minutesToAdd= 20

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="12:33 AM"
    }

    def 'Test TimeUtil | addMinutes() | Given time is 12 PM '(){
        given:
        def inputTimeString= "12:13 PM"
        def minutesToAdd= 290

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="5:03 PM"
    }



    //Positive minutesToAdd test cases ends here.


    //Negative minutesToAdd test cases starts here.

    def 'Test TimeUtil | addMinutes() | Given time is AM | minutes are -ve'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= -185

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="6:08 AM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is PM | minutes are -ve'(){
        given:
        def inputTimeString= "9:13 PM"
        def minutesToAdd= -185

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="6:08 PM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is AM | minutes are -ve and hours greater than given time'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= -610

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="11:03 PM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is PM | minutes are -ve and hours greater than given time'(){
        given:
        def inputTimeString= "9:13 PM"
        def minutesToAdd= -610

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="11:03 AM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is AM | minutes are -ve and added hours comes zero'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= -550

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="12:03 AM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is PM | minutes are -ve and added hours comes zero'(){
        given:
        def inputTimeString= "9:13 PM"
        def minutesToAdd= -550

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="12:03 PM"

    }

    def 'Test TimeUtil | addMinutes() | Given time is AM | minutes are -ve and added minutes are -ve'(){
        given:
        def inputTimeString= "9:13 AM"
        def minutesToAdd= -570

        when:
        def result= TimeUtil.addMinutes(inputTimeString, minutesToAdd)

        then:
        result=="11:43 PM"

    }

    //Negative minutesToAdd test cases ends here.
}
