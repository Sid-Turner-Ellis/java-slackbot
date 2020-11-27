package com.slackApp.slackApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
public class VoteController {

    private String timeToExpireStr;
    private String percOfVotes;
    SheetsController sc;

    @RequestMapping("/slash/vote")
    public String VoteDetails(){
        if(Election.getElectionDT() != null){
            // get the expiry timer
            timeToExpireStr = getTimeToExpire();

            // get the percentage of people that have voted
            sc = new SheetsController();
            percOfVotes = sc.getJSON();

            // return details
            return "Vote! " + timeToExpireStr + " left. " + percOfVotes;
        }

        return "You haven't set the vote yet!";
    }

    public String getTimeToExpire(){
        HashMap<String, String> timesMap = new HashMap<String, String>();
        String timeToExpire = "";
        long msLeft = Election.getElectionDT().getTime() - new Date().getTime();
        long minutesLeft = (msLeft / 1000) / 60;
        int daysLeft = (int)(minutesLeft / 1440);
        minutesLeft -= (daysLeft * 1440);
        int hoursLeft = (int)minutesLeft / 60;
        minutesLeft -= (hoursLeft * 60);
        int finalMinutesLeft = (int)minutesLeft;

        int index = 1;

        timesMap.put("day",Integer.toString(daysLeft));
        timesMap.put("hour",Integer.toString(hoursLeft));
        timesMap.put("minute",Integer.toString(finalMinutesLeft));

        for (String key : timesMap.keySet()) {
            if(timesMap.get(key).length() > 1){
                timeToExpire += timesMap.get(key) + " " + key + "s ";
            }else{
                timeToExpire += timesMap.get(key) + " " + key + " ";
            }
            if(index == 2){
                timeToExpire += "and ";
            }
            index++;
        }
        return timeToExpire;
    }
}

