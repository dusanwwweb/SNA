//package com.dusanweb.sna.utils;
//
//import com.dusanweb.sna.model.Firestation;
//import com.dusanweb.sna.service.FirestationService;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//
//@Component
//public class FirestationParser {
//
//	@Bean
//	CommandLineRunner runner(FirestationService firestationService){
//	    return args -> {
//			// read JSON and load json
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//			//!!!! "can not use as Creator" !!!!
//	        mapper.findAndRegisterModules();
//	        
//			TypeReference<List<Firestation>> typeReference = new TypeReference<List<Firestation>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");
//			
//			try {
//				List<Firestation> firestations = mapper.readValue(inputStream,typeReference);
//				firestationService.saveAllUsers(firestations);
//				System.out.println("Firestations Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save firestations: " + e.getMessage());
//			}
//	    };
//	}
//}
//
//
//
