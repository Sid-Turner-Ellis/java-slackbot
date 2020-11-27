package com.slackApp.slackApp;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


@Component
public class SheetsController {
    RestTemplate rt;
    ArrayList<Object> formResponses;
    private float percentage;

    public String getJSON(){
        rt = new RestTemplate();
        formResponses = rt.getForObject(URL, ArrayList.class);
        percentage = (((float)formResponses.size() / (float)Election.getNumberOfVoters()) * 100);
        return Math.round(percentage) + "% have voted!";
    }
}
