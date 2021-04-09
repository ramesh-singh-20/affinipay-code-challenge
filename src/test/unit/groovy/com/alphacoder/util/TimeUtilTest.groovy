package com.alphacoder.util

import spock.lang.Specification

class TimeUtilTest extends Specification{

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
}