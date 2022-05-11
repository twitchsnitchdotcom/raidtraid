package com.raidtraid.app.data.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raidtraid.app.dto.channel.IndividualChannelPageDTO;
import com.raidtraid.app.dto.homepage.HomePageDTO;
import com.raidtraid.app.dto.raidfinder.RaidFindersDTO;
import com.raidtraid.app.dto.schedule.ScheduleDTO;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;

@Service
public class DataService {

    // create object mapper instance
    ObjectMapper mapper = new ObjectMapper();

    public RaidFindersDTO getRaidFinder() {

        // convert JSON string to Book object
        RaidFindersDTO raidFindersDTO = null;
        try {
            URL resource = getClass().getClassLoader().getResource("data/raidfinder.json");
            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            }
            raidFindersDTO = mapper.readValue(new File(resource.toURI()), RaidFindersDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return raidFindersDTO;
    }

    public IndividualChannelPageDTO getChannelPage(){
        // convert JSON string to Book object
        IndividualChannelPageDTO individualChannelPageDTO = null;
        try {
            URL resource = getClass().getClassLoader().getResource("data/channel-single-page.json");
            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            }
            individualChannelPageDTO = mapper.readValue(new File(resource.toURI()), IndividualChannelPageDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return individualChannelPageDTO;
    }

    public HomePageDTO getHomePage(){
        // convert JSON string to Book object
        HomePageDTO homePageDTO = null;
        try {
            URL resource = getClass().getClassLoader().getResource("data/homepage.json");
            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            }
            homePageDTO = mapper.readValue(new File(resource.toURI()), HomePageDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return homePageDTO;
    }

    public ScheduleDTO getSchedule(){
        // convert JSON string to Book object
        ScheduleDTO scheduleDTO = null;
        try {
            URL resource = getClass().getClassLoader().getResource("data/calendar.json");
            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            }
            scheduleDTO = mapper.readValue(new File(resource.toURI()), ScheduleDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleDTO;
    }
}
