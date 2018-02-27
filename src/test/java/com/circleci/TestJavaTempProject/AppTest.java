package com.circleci.TestJavaTempProject;

import java.io.File;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	
      File files=new File(System.getProperty("user.dir"));
  	for(File f:files.listFiles())
	{
		if(f.isDirectory())
		{
			printfileNames(f);
			
		}
		
			System.out.println("Top level files "+f.getAbsolutePath());
		
	}
  	
    	
    	
        assertTrue( true );
    }
    
    public static void printfileNames(File folder)
    {
    	for(File f:folder.listFiles())
    	{
    		if(f.isDirectory())
    		{
    			printfileNames(f);
    			
    		}
    		
    		 try {
				System.out.println("Inner files "+f.getCanonicalFile().getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
