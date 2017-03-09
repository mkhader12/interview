package com.cb.app;

import java.util.ArrayList;
import java.util.List;

import com.cb.model.Contact;
import com.cb.model.ContactList;
import com.cb.model.Response;
import com.cb.model.Results;
import com.cb.util.JsonUtil;
import com.cb.util.ObjectMerger;

public class ContactMerger extends Thread {

	private Application appContext;

	public ContactMerger(Application ctx) {
		this.appContext = ctx;
	}

	@Override
	public void run() {
		JsonUtil jtm = new JsonUtil();
		
		ContactList existingContacts = this.appContext.getExistingContacts();
		Response resp = this.appContext.getApiResponse();
		if (resp != null) {
			List<Results> results = resp.getResults();
			if (results != null && !results.isEmpty()) {
				List<Contact> newList = new ArrayList<Contact>();
				List<Contact> inContacts = null;
				for (Results result : results) {
					inContacts = result.getContacts();
					if (existingContacts != null) {
						// Combine all in coming contacts from service
						newList.addAll(inContacts);

					}
				}
				newList = ObjectMerger.merge(existingContacts.getContacts(), inContacts);
				this.appContext.setMergedContacts(newList);
			}
		}
	}
}
