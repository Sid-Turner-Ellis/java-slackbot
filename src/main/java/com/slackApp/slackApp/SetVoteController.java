package com.slackApp.slackApp;

import com.slackApp.slackApp.Election;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SetVoteController {


    @RequestMapping("/slash/setvote")
    public String setVote(@RequestParam("text") String str){
        String[] arrOfStr = str.split("/",4);
        String electionDayString;

        try {

            int month = Integer.parseInt(arrOfStr[0].trim()) - 1;
            int date = Integer.parseInt(arrOfStr[1].trim());
            int hours = Integer.parseInt(arrOfStr[2].trim());
            int voters = Integer.parseInt(arrOfStr[3].trim());




            // change this to be for the users input
            electionDayString = Election.setElectionDT(month,date,hours);
            Election.setNumberOfVoters(voters);


        }
        catch(Exception e) {
            return "Please use the correct format and try again";
        }

        if (isValidDate()){
            return "Vote has been set for " + electionDayString +" You can now use the /vote slash command";
        }
        return "Please set a valid date!";

    }
        public String cunt(){
            String electionDayString = Election.setElectionDT(01,01/01,12);
            Election.setNumberOfVoters(31);

            return "Vote has been set for " + electionDayString + " You can now use the /vote slash command";

    }

    public Boolean isValidDate(){

        if(Election.getElectionDT().getTime() - new Date().getTime() < 0){
            return false;
        }
        return true;
    }
}
