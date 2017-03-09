package com.cb.app;

import com.cb.model.ContactList;
import com.cb.reader.ContactFileReader;

public class ExistingContactReaderThread extends Thread {
	
	private Application appContext;

	public ExistingContactReaderThread(Application ctx) {
		this.appContext = ctx;
	}

	@Override
	public void run() {
		try {
			ContactFileReader cf = new ContactFileReader();
			ContactList existingContacts = cf.getContacts();
			this.appContext.setExistingContacts(existingContacts);
			this.appContext.setExistingContactsCompleted(true);
		} catch (Exception e) {
			this.appContext.setExistingContactsCompleted(true);
			e.printStackTrace();
		}
	}

}
