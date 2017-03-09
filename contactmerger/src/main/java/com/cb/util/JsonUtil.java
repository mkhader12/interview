package com.cb.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public String transformToJson(Object obj) {
		String resp = null;
		if (obj != null) {
			ObjectMapper mapper = getObjectMapper();
			try {
				resp = mapper.writeValueAsString(obj);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return resp;
	}

	public Object transformToPojos(String jsonStr, Class<?> classType) {
		Logger appLog = Logger.getGlobal();

		Object retVal = null;
		ObjectMapper mapper = getObjectMapper();
		try {
			retVal = mapper.readValue(jsonStr, classType);
			appLog.log(Level.INFO, "Json to Java object completed");

		} catch (JsonParseException e) {
			// e.printStackTrace();
			appLog.log(Level.SEVERE, e.getMessage(), e);

		} catch (JsonMappingException e) {
			// e.printStackTrace();
			appLog.log(Level.SEVERE, e.getMessage(), e);
		} catch (IOException e) {
			// e.printStackTrace();
			appLog.log(Level.SEVERE, e.getMessage(), e);
		}
		return retVal;
	}

	protected ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}

	// public static void main(String[] args) {
	// JsonToJavaMapper jtjm = new JsonToJavaMapper();
	// TestResponseReader trr = new TestResponseReader();
	// String jsonStr = trr.readFile();
	// //Response resp = (Response) jtjm.transformResponse(jsonStr,
	// Response.class);
	//
	// ContactFileReader cf = new ContactFileReader();
	// jsonStr = cf.readFile();
	// ContactList conts = (ContactList) jtjm.transformResponse(jsonStr,
	// ContactList.class);
	//
	// System.out.println("done");
	//
	// }

}
