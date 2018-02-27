package com.circleci.TestJavaTempProject;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	
    	File files=new File(System.getProperty("user.dir"));
    	
    	for(File f:files.listFiles())
    	{
    		 System.out.println("files "+f.getCanonicalFile().getCanonicalPath());
    	}
       
    }
}
