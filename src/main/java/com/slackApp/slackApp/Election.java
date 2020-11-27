package com.slackApp.slackApp;

import java.util.Date;

public class Election {
    private static Date electionDT;
    private static int numberOfVoters;



    // getter and setter for the time of the election
    public static String setElectionDT(int months,int date, int hours){
        Election.electionDT = new Date();
        Election.electionDT.setMonth(months);
        Election.electionDT.setDate(date);
        Election.electionDT.setHours(hours);
        return Election.electionDT.toGMTString();
    }

    public static Date getElectionDT(){
        if(Election.electionDT != null) {
            return Election.electionDT;
        }else {
            return null;
        }
    }




    // getter and setter for the number of voters
    public static void setNumberOfVoters(int numberOfVoters){
        Election.numberOfVoters = numberOfVoters;
    }

    public static int getNumberOfVoters() {
        return numberOfVoters;
    }
}
