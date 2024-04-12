package org_library_pathhelper;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;
public class pathHelper {
	public static String completePath="";
	public static Properties p=new Properties();
//	public static final String filePath="C:\\Adv_java_project\\questionbank";
 public pathHelper() 
 {
	 try {
	    Path currentDirectoryPath=FileSystems.getDefault().getPath("");
		String currentDirectoryName=currentDirectoryPath.toAbsolutePath().toString();
		completePath=currentDirectoryName+"\\src\\resources\\db.properties";
//		System.out.println(completePath);
		FileInputStream finf=new FileInputStream(completePath);
        p.load(finf);
	 }
	 catch(Exception ex)
	 {
		 System.out.println("error is "+ex);
	 }
 }
}