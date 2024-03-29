package com.telusinternational.challenge.components;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class VisitCounter {
    public void countVisit()
    {
    	try {
			
			DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date dateCurrent = new Date();
			String dateCurrentS = formatter.format(dateCurrent);
			FileWriter fw = new FileWriter("VisitCounter.txt",true);
			
			//Read file to get last line
			BufferedReader br = new BufferedReader(new FileReader("VisitCounter.txt"));
			String lastLine = "";
			String sCurrentLine;
			String newLine;
			
			StringBuilder sb = new StringBuilder();
			
			while((sCurrentLine = br.readLine()) != null) {
				
				lastLine = sCurrentLine;
			}
			
			br = new BufferedReader(new FileReader("VisitCounter.txt"));

			while((sCurrentLine = br.readLine()) != null) {
				
				if(lastLine.equals(sCurrentLine)) 
				{
					
					String[] dateOld = lastLine.split("\\|");
					String oldDate = dateOld[0];
					
					
					if(dateCurrentS.equals(oldDate)) {
						int countDay = Integer.parseInt(dateOld[1]);
						countDay++;
						
						sb.append(oldDate+"|"+countDay);
						sb.append("\n");
					}
					else {
						
						sb.append(oldDate+"|"+dateOld[1]);
						sb.append("\n");
						sb.append(dateCurrentS+"|"+1);
						sb.append("\n");
					}
				}
				else {
					sb.append(sCurrentLine);
					sb.append("\n");	
				}
			}
			
			//If file has not lines
			if(lastLine == "") {
				newLine = dateCurrentS+"|"+"1";
				fw.write(newLine);	
			}
			else {
				FileWriter fws = new FileWriter("VisitCounter.txt");
				fws.write(sb.toString());
				fws.close();
			}
			
			fw.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    
    public String getCounter()
    {
    	String counterVisits = "";
    	
    	try {
    		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date dateCurrent = new Date();
			String dateCurrentS = formatter.format(dateCurrent);
			String sCurrentLine;
			
    		BufferedReader br = new BufferedReader(new FileReader("VisitCounter.txt"));
    		
    		while((sCurrentLine = br.readLine()) != null) {
    			String[] currentData = sCurrentLine.split("\\|");
				String currentDate = currentData[0];
				if(dateCurrentS.equals(currentDate)) {
					counterVisits = currentData[1];
				}
    		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return counterVisits;
    }
    
}
