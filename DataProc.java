package max.labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataProc {
	int NumTable;
	char Type;
	int amount;
	int TimeAdd;
	int TimeDel;
	public DataProc(int NumTable, char Type,int amount,int TimeAdd, int TimeDel) {
	       	this.NumTable = NumTable;
			this.Type = Type;
			this.amount = amount;
			this.TimeAdd = TimeAdd;
			this.TimeDel = TimeDel;
	       
	   } 
	public static String[] GetDataAT(String Path ) throws IOException {
		Boolean DebugMode = true;
		String[] settings = new String[10] ;
		String path = "data";
		String filename = "data-autotest.txt";
		
		try {
			File srp = new File(Path);			
			BufferedReader Reader = new BufferedReader(new FileReader(srp));
			String CurrentLine = Reader.readLine();
			
			int i = 0;
			while (CurrentLine != null) {
				settings[i] = CurrentLine;
				i++;
				CurrentLine = Reader.readLine();				
			}
		Reader.close();	
			
		}
		catch (FileNotFoundException e) {
			writeDebug("Файл не найден ", DebugMode);
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			writeDebug("Пустое значение ", DebugMode);
			e.printStackTrace();
		}
		return settings;
				
	}
	public static void writeDebug( String text, Boolean DebugMode) throws IOException {
		if (DebugMode) {
			String path = "resources";
			String filename = "debug.txt"; 
			
			File src = new File(path, filename);
			FileWriter Writer = new FileWriter(src, true);
			
			Writer.append(text);
			Writer.append('\n');
			Writer.append("--------------");
			Writer.append('\n');
			Writer.close();
		}
	}
	
}
