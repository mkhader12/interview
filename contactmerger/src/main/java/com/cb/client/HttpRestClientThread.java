package com.cb.client;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import com.cb.app.Application;
import com.cb.model.Response;
import com.cb.model.Results;
import com.cb.ref.GeneralConstants;
import com.cb.util.InputReqDataReader;
import com.cb.util.JsonUtil;
 
/**
 * @author mkhader
 * 
 */
 
public class HttpRestClientThread extends Thread {
	private Application appContext;

	public HttpRestClientThread(Application ctx) {
		this.appContext = ctx;
	}
 
	public Response getResponse(String apiUrl) {
		System.out.println("Requested URL: " + apiUrl);
		StringBuilder sb = new StringBuilder();
		HttpURLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(apiUrl);
			urlConn = (HttpURLConnection) url.openConnection();
			InputReqDataReader irdr = new InputReqDataReader();
			String requestJson = irdr.getInputJson();
			if (urlConn != null)
			{
				urlConn.setReadTimeout(60 * 1000);
				urlConn.setDoInput(true);
				urlConn.setDoOutput(true);

				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Accept", "application/json");
				urlConn.setRequestProperty("Content-Type", "application/json");
				urlConn.setRequestProperty("Cache-Control", "no-cache");
				urlConn.setRequestProperty("X-CB-ApiKey", GeneralConstants.APIKey);
				urlConn.setRequestProperty("body", requestJson);

				DataOutputStream wr = new DataOutputStream(urlConn.getOutputStream());
				wr.writeChars(requestJson);
				wr.flush();
				wr.close();
				
			}
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (Exception e) {
			InputStream er = urlConn.getErrorStream();
			in = new InputStreamReader(er, Charset.defaultCharset());
			BufferedReader bufferedReader = new BufferedReader(in);
			try {
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();	
				System.out.println(sb.toString());
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException("Exception while calling URL:" + apiUrl, e);
		}
		JsonUtil jtjm = new JsonUtil();
		Response resp = (Response) jtjm.transformToPojos(sb.toString(), Response.class);

		return resp;
	}

	@Override
	public void run() {
		try {
			Response resp = getResponse(GeneralConstants.APIUrl);
			this.appContext.setApiResponseCompleted(true);
			List<Results> results = resp.getResults();
			this.appContext.setApiResponse(resp);
		} catch (Exception e) {
			this.appContext.setApiResponseCompleted(true);
			e.printStackTrace();
		}
		
	}
}