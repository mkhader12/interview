package com.cb.app;

import java.util.List;

import com.cb.client.HttpRestClientThread;
import com.cb.model.Contact;
import com.cb.model.ContactList;
import com.cb.model.Response;
import com.cb.util.JsonUtil;
import com.cb.util.ResponseWriter;

/**
 * @author mkhader
 *
 */
public class Application {
	public ContactList getExistingContacts() {
		return existingContacts;
	}

	public void setExistingContacts(ContactList existingContacts) {
		this.existingContacts = existingContacts;
	}

	public Response getApiResponse() {
		return apiResponse;
	}

	public void setApiResponse(Response apiResponse) {
		this.apiResponse = apiResponse;
	}

	public boolean isExistingContactsCompleted() {
		return existingContactsCompleted;
	}

	public void setExistingContactsCompleted(boolean existingContactsCompleted) {
		this.existingContactsCompleted = existingContactsCompleted;
	}

	public boolean isApiResponseCompleted() {
		return apiResponseCompleted;
	}

	public void setApiResponseCompleted(boolean apiResponseCompleted) {
		this.apiResponseCompleted = apiResponseCompleted;
	}

	ContactList existingContacts =null;
	Response apiResponse = null;
	boolean existingContactsCompleted = false;
	boolean apiResponseCompleted = false;
	private List<Contact> mergeContactList;
	
	public void start() {

		// Send request to server and receive response
		HttpRestClientThread svcClient = new HttpRestClientThread(this);
		svcClient.start();

		
		// Read Existing contacts
		ExistingContactReaderThread ecrt = new ExistingContactReaderThread(this);
		ecrt.start();
		
		ContactMerger cm = new ContactMerger(this);
		synchronized (svcClient) {
			synchronized (ecrt) {
				try {
					ecrt.wait();
					svcClient.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Merge Contacts
				cm.start();
			}
		}
		synchronized (cm) {
			try {
				cm.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JsonUtil jtm = new JsonUtil();
			StringBuffer sb= new StringBuffer("{");
			for (Contact aContact : mergeContactList) {
				sb.append(jtm.transformToJson(aContact)).append(",\n");
			}
			String outputStr = sb.substring(0, sb.lastIndexOf(",")-1);
			outputStr += "}";
			System.out.println("---------Merged contacts -------");
			System.out.println(outputStr);
			ResponseWriter.writeToFile(outputStr);
		}
	}

	public static void main(String[] args) {
		Application app = new Application();
		app.start();
	}

	public void setMergedContacts(List<Contact> newList) {
		this.mergeContactList = newList;
		
	}

}
