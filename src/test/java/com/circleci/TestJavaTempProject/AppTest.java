package com.circleci.TestJavaTempProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

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
    
	public static void downloadExtension(String extensionName) {
		
		 String file = System.getProperty("user.dir") + "/ExtensionResouces/CRX";
		
		 System.out.println("System.getProperty(user.dir) :"+System.getProperty("user.dir"));
		 String	filePath = file.replace("CRX", "letznav_editor.crx");
		System.out.println("filePath "+filePath);
		try {
			URL url = new URL("https://letznav-testing.herokuapp.com/api/public/admin/extensions/editor/letznav_editor.crx");
			ReadableByteChannel rbc = Channels.newChannel(url.openStream());
			FileOutputStream fos = new FileOutputStream(filePath);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			rbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
