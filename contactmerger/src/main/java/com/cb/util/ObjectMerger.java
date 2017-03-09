package com.cb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cb.model.Contact;

public class ObjectMerger {

	public static List<Contact> merge(List<Contact> existingElemList, List<Contact> newElementList) {
		Logger appLog = Logger.getGlobal();
		List<Contact> newList = new ArrayList<Contact>();
		if (existingElemList != null && newElementList != null) {
			boolean elementMerged = false;
			for (Contact aNewElement : newElementList) {
				elementMerged = false;
				for (Contact anExistingElement : existingElemList) {
					if (aNewElement.equals(anExistingElement)) {
						String matchStr = "Merging record of " + aNewElement.getFirstName() + " "
								+ aNewElement.getLastName();
						appLog.log(Level.INFO, matchStr);
						anExistingElement.merge(aNewElement);
						elementMerged = true;
						break;
					}
				}
				// If contact is not merged, create a new contact in the
				// existing list
				if (!elementMerged) {
					String newElementStr = "Found new record of " + aNewElement.getFirstName() + " "
							+ aNewElement.getLastName();
					appLog.log(Level.INFO, newElementStr);
					newList.add(aNewElement);
				}
			}
			if (newList.size() > 0) {
				newList.addAll(0, existingElemList);
			}
		}

		return newList;
	}

}
