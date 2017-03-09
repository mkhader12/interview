package com.cb.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.cb.ref.GeneralConstants;

public class ResponseWriter {
	public static void writeToFile(String str)
	{
		try {
			FileWriter fw = new FileWriter(new File(GeneralConstants.outputFile));
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
