package exer;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.AbstractDocument.BranchElement;

public abstract class FileEx {
	private static final String PATHFILE = "D://FileEx/newfile.txt";
	public static final File FILEXAMPLE = new File("D://FileEx/newfile.txt");
	public static File file = new File("D://FileEx/");
	//1. Write a Java program to get a list of all file/directory names from the given. Go to the editor

	public static void getListFile() {
		//File file = new File("D://FileEx/");
		List<String> listaFileNames = Arrays.asList(file.list());
		Iterator<String> it = listaFileNames.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());

		}

	}

	//2. Write a Java program to get specific files by extensions from a specified folder

	public static void getExtFile(String suffix) {
		List<String> lista = Arrays.asList(file.list());



		for (String string : lista) {
			if (string.endsWith(suffix)) {
				System.out.println(string);
			}
		}
	}

	//3. Write a Java program to check if a file or directory specified by pathname exists or not
	public static boolean pathExist() {
		File file2 = new File("D://FileEx/novo");
		return file2.exists();
	}

	//4. Write a Java program to check if a file or directory has read and write permission.

	public static void checkPermicionsFile() {
		if(file.canRead()) {
			System.out.println("can read :" +file.getAbsolutePath());
		}

		if(file.canWrite()) {
			System.out.println("can write :" +file.getAbsolutePath());
		}


	}

	//5. Write a Java program to check if given pathname is a directory or a file

	public static void isADirOrFile(File file) {

		if(file.isDirectory())System.out.println("� diretorio");
		if(file.isFile())System.out.println("� diretorio");	

	}
	//7. Write a Java program to get last modified time of a file
	public static void lastModifidFile() {



		Date d = new Date(file.lastModified());
		System.out.println(d.toGMTString());
	}
	//8. Write Java program to read input from java console. 
	public static void readInput() {
		File file = new File("D://FileEx/newfile.txt");

	}
	//11. Write a Java program to read a file content line by line

	public static void readFile() throws IOException  {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File("D://FileEx/newfile.txt")));

			String str ="";
			String str2 ="";
			while (str  != null) {
				str = reader.readLine();

				System.out.println(str);
			}

			reader.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro");
		}
	}
	//12. Write a Java program to read a plain text file.

	public static StringBuilder read(File file) throws IOException {
		
		StringBuilder strData = new StringBuilder();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine())!= null) {
				strData.append(line+"\n");
			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("Unable to read the file.");
		}
		finally {
			if(br!=null) br.close();
			
		}
		System.out.println(strData);
		return strData;
	}
	//14. Write a Java program to store text file content line by line into an array.
	public static List<String> contentFileToArray(File file){
	
		List<String> text =  new ArrayList<>();

		FileReader reader =  null;
		BufferedReader br = null;
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			String line = null;
			while ((line = br.readLine())!=null) {
				text.add(line);
				
			}

			System.out.println(text.toString());
			
		} catch (IOException|NullPointerException e) {
			
			e.printStackTrace();

		}finally {
			if (reader!= null && br !=null) {
				try {
					reader.close();
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return text;

	}
	
	public static void whrtiteToFile(File file, String str, boolean append) {
		FileWriter fr = null;
		
		
		try {
			
			fr = new FileWriter(file,append);
			
			//bw = new BufferedWriter(fr);
			
			fr.write(str+"\n");
			System.out.println("Escreveu");
			//contentFileToArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null) {
					fr.close();
					
				}
				contentFileToArray(file);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	//17. Write a Java program to read first 3 lines from a file. Go to the editor
	public static void read3Lines(File file) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		
		
		
		try {
			fr = new FileReader(file);
			br= new BufferedReader(fr);
			int  count = 0;
			List<String> lista= new ArrayList<>();
			String lines=null;
			while (((lines = br.readLine())!=null) ) {
				count++;
				
				//System.out.println(count);
				//System.out.println(lines);
				lista.add(lines);
				if(count == 3)break;
			}
			System.out.println(lista);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(br!=null) {
				br.close();
				fr.close();
			}
		}
		
	}
}

