package com.dusanweb.sna.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DataParserJson {
		
	public JsonWrapper readJson() {

		String filePath = "C:\\Users\\Utilisateur\\eclipse-workspace\\safety-net-alerts-2\\src\\main\\resources\\json\\data.json";	
		String dataFile = null;
		
		try {
			dataFile = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		//!!!! "can not use as Creator" !!!!
        objectMapper.findAndRegisterModules();
		
        JsonWrapper data = new JsonWrapper();
		
		try {
			data = objectMapper.readValue(dataFile, JsonWrapper.class);
			log.info("JSON deserialized with success");
		} catch (Exception e) {
			log.info("Error when deserializing JSON", e);
		}
		return data;
	}
	
}
