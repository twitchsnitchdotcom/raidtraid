package com.raidtraid.app.data.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raidtraid.app.dto.RaidFindersDTO;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

@Service
public class RaidService {

    public RaidFindersDTO readFile() {
        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();



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

        // print book
        System.out.println(raidFindersDTO);

        return raidFindersDTO;
    }
}
