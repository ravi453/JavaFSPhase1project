package lockedpackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe 
{
	static final String projectFilesPath = "D:\\LockedMeFiles";
	static final String errorMessage = "Some error occured. Please Contact : admin@lockedme.com";

	public static void main(String[] args) 
	{
		mainCallMethod();   
	    
	}
	
	public static void mainCallMethod()
	{
		Scanner obj = new Scanner(System.in);
	    int choice=1;
	    
	    while(choice>0 && choice<4)
	    {
	    	try
	    	{
	    	displayMenu();
	    	System.out.println("Enter your Choice:");
	    	
	    	choice=Integer.parseInt(obj.nextLine());
	    	
	    	switch(choice)
	    	{
	    	case 1:getAllFiles();
	    	break;
	    	case 2:getBusinessOperations();
	    	break;
	    	case 3:exitProgram();
	    	break;
	    	default:System.out.println("Invalid Option : Please Enter Number between 1 to 3.");
	    	break;
	    	}
	    	}
	    	catch(NumberFormatException Ex)
	    	{
	    		System.out.println("Please Enter Number between 1 to 3 Not Characters.");
	    	}
	    	catch(Exception Ex)
	    	{
	    		System.out.println(errorMessage);
	    	}
	    
	    }
		obj.close();
		
	}
	
	public static void displayMenu()
	{
		System.out.println("*********************************************************");
		System.out.println("\t\t    Welcome to Lockedme.com");
		System.out.println("\t\t Developed by RAVI KANT BHARTI");
		System.out.println("*********************************************************");
		System.out.println("\t\t 1. Display all the files in the Directory");
		System.out.println("\t\t 2. Business-level Operations");
		System.out.println("\t\t 3. Exit from the Application");
	}
	
	public static void subDisplayMenu()
	{
		System.out.println("\t\t 1. Add a new file in the Directory");
        System.out.println("\t\t 2. Delete a file from the Directory");
        System.out.println("\t\t 3. Search a file in the Directory");
        System.out.println("\t\t 4. Go Back to the main Menu");
	}
	
	/**
	 * This function will return all the files from the project Directory
	 */
	public static void getAllFiles()
	{
		try
		{
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			
			if(listOfFiles.length==0)
				System.out.println("No Files found in the Directory");
			else
			{
				for(var l:listOfFiles)
				{
					System.out.println(l.getName());
				}
			}
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
		
	}
	
	/**
	 * This method will create the files in the directory
	 */
	@SuppressWarnings("resource")
	public static void createFiles()
	{
		try
		{
			Scanner obj = new Scanner(System.in);
			
			String filename;
			
			System.out.println("Enter file name with extension(like abc.txt) that you want to Create");
			filename = obj.nextLine();
			
			File file = new File(projectFilesPath+ "\\"+ filename);
			if(file.exists())
				System.out.println("File already exist with the same name.");
			else
			{	
			int linesCount;
			System.out.println("Enter how many lines that you want to write in the file");
			linesCount=Integer.parseInt(obj.nextLine());
			
			FileWriter myWriter = new FileWriter(projectFilesPath+ "\\"+ filename);
		 	
			for(int i=1;i<=linesCount;i++)
			{
			    System.out.println("Enter the lines that you want to write in the file");
			    myWriter.write(obj.nextLine()+"\n");
		    }
			System.out.println("File Created and "+ linesCount+" Lines written Successfully");
			
			myWriter.close();
			}	
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
			
	}
	
	/**
	 * This method will delete file based on provided file name
	 */
	
	public static void deleteFiles()
	{
		@SuppressWarnings("resource")
		Scanner obj = new Scanner(System.in);
		try
		{
			String filename;
			
			System.out.println("Enter the file name with extension(like abc.txt) to be deleted");
			
			filename = obj.nextLine();
			
			File file = new File(projectFilesPath+ "\\"+ filename);
			
			if(file.exists())
			{
				file.delete();
				System.out.println("File deleted Successfully : "+ filename);
			}
			else
				System.out.println("File do not exist");
	      }
		  catch(Exception Ex)
		  {
			  System.out.println(errorMessage);
		  }
		
		
	}
	
	/**
	 * This method will search files from the directory
	 */
	public static void searchFiles()
	{
		@SuppressWarnings("resource")
		Scanner obj = new Scanner(System.in);
		try
		{
			String filename;
			
			System.out.println("Enter the file name to be searched");
			
			filename = obj.nextLine();
			
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			
			LinkedList<String> filenames = new LinkedList<String>();
			
			for(var l:listOfFiles)
				filenames.add(l.getName());
			
			if(filenames.contains(filename))
				System.out.println("File is available : "+ filename);		
			else
				System.out.println("File is not available");
			
	      }
		  catch(Exception Ex)
		  {
			  System.out.println(errorMessage);
		  }
		
	}


     public static void exitProgram()
     {
    	 System.out.println("Application CLOSED Successfully");
    	 System.exit(0);
     }
     
     public static void goBackProgram()
     {
    	 System.out.println("Backed to the Main Menu");
    	 mainCallMethod();
     }
     
     
}