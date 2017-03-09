package com.cb.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cb.ref.GeneralConstants;

public class AppFileReader {

	public String readFile() {
		Logger appLog = Logger.getGlobal();
		StringBuffer fileContent = new StringBuffer();
		BufferedReader br = null;
		try {
			String fileName = getFileName();
			appLog.log(Level.INFO, "Reading file " + fileName);

			br = new BufferedReader(new FileReader(fileName));
			String aLine;
			int lc = 0;

			while ((aLine = br.readLine()) != null) {
				fileContent.append(aLine);
				lc++;
			}

			appLog.log(Level.INFO, "Total " + lc + " lines read from the file " + fileName);
			if (br != null) {
				br.close();
			}

		} catch (FileNotFoundException e) {
			// Generally I have better error handling
			// For this exercise I leave just like that
			// e.printStackTrace();
			appLog.log(Level.SEVERE, e.getMessage(), e);

		} catch (IOException e) {
			// Generally I have better error handling
			// For this exercise I leave just like that
			// e.printStackTrace();
			appLog.log(Level.SEVERE, e.getMessage(), e);
		}
		return fileContent.toString();
	}

	public String getFileName() {
		return GeneralConstants.WebRequestFragments;
	}

}
