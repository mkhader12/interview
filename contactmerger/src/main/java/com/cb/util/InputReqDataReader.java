package com.cb.util;

import com.cb.model.Messages;
import com.cb.model.Request;
import com.cb.reader.TestRequestReader;
import com.cb.ref.GeneralConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InputReqDataReader {
	public String getRequestJson(String rawRequest)
	{
		try {
			ObjectMapper mapper = getObjectMapper();
			Request req = this.getRequests(rawRequest);
			return mapper.writeValueAsString(req);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public Request getRequests(String rawRequest) {
		if (rawRequest != null && rawRequest.length() > 0) {
			rawRequest.trim();
			String[] requestStrings = rawRequest.split(GeneralConstants.RequestDivideString);

			Request req = new Request(String.valueOf(System.currentTimeMillis()));
			ObjectMapper mapper = getObjectMapper();
			// I could have used Arrays.asList since I am trying to eliminate
			// blanks I want to iterate thru
			Messages inputMsg = null;
			for (String aString : requestStrings) {
				aString = aString.trim();
				if (!aString.isEmpty()) {
					JsonUtil jtjm = new JsonUtil();
					inputMsg = (Messages) jtjm.transformToPojos(aString, Messages.class);
					inputMsg.setMessageId(String.valueOf(System.currentTimeMillis()));
					inputMsg.setUserId(String.valueOf(System.currentTimeMillis()));
					req.addMessage(inputMsg);
				}
			}

			return req;
		}
		return null;
	}

	protected ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}

	public static void main(String[] args) {
		InputReqDataReader irdr = new InputReqDataReader();
		irdr.getInputJson();
		//System.out.println(splitValue.size());
	}

	public String getInputJson() {
		TestRequestReader trr = new TestRequestReader();
		String rawValue = trr.readFile();
		InputReqDataReader rd = new InputReqDataReader();
		String retValue = rd.getRequestJson(rawValue);
		return retValue;
	}

}
