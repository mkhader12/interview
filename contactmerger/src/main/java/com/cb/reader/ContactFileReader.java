package com.cb.reader;

import com.cb.model.ContactList;
import com.cb.ref.GeneralConstants;
import com.cb.util.JsonUtil;

public class ContactFileReader extends AppFileReader {
	@Override
	public String getFileName() {
		return GeneralConstants.ExistingContacts;
	}

	public ContactList getContacts() {
		ContactFileReader cf = new ContactFileReader();
		String jsonStr = cf.readFile();
		JsonUtil jtjm = new JsonUtil();
		ContactList cnts = (ContactList) jtjm.transformToPojos(jsonStr, ContactList.class);
		return cnts;
	}

}
