//Code to read data file and Calculate Min/Max/Mean

	
	import java.io.*;
	public class ReadDataFile {
	   public static void main(String[] args) {         
	      //Specify the path of the file here
	      File file = new File("C:\\Users\\akshb\\Downloads\\SalaryData.txt");
	      BufferedInputStream bis = null;
	      FileInputStream  fis= null;

	      try
	      {
	          //FileInputStream to read the file
	          fis = new FileInputStream(file);

	          /*Passed the FileInputStream to BufferedInputStream
	           *For Fast read using the buffer array.*/
	          bis = new BufferedInputStream(fis);

	          /*available() method of BufferedInputStream
	           * returns 0 when there are no more bytes
	           * present in the file to be read*/
	          String S="";
	          float total = 0;
	          int numS = 0;		
	          float min = 1000000000.00f;
	          float max = 0.00f;
	          float bin[] = new float[5];
	          while( bis.available() > 0 ){             	
	              //System.out.println((char)bis.read());
	        	  char c = (char)bis.read();
	        	  if (c != '\n' || bis.available() == 0) {
	        		  S=S+c;
	        	  } else {
	        		  float f = Float.parseFloat(S);
	        		  total += f;
	        		  numS += 1;
	        		  //System.out.println(f);
	        		  bin[numS-1] = f;
	        		  S="";
	        		  if (f < min) {
	        			  min = f;
	        		  } 
	        		  if (f > max) {
	        			  max = f;
	        		  }
	        	  }
	        	 
	          }
	          float f = Float.parseFloat(S);
    		  total += f;
    		  numS += 1;
    		  bin[numS-1] = f;
    		  S="";
    		  if (f < min) {
    			  min = f;
    		  } 
    		  if (f > max) {
    			  max = f;
    		  }
	          float mean = total/numS;
	          System.out.println("Mean:"+ mean);
	          System.out.println("Min Value:" + min);
	          System.out.println("Max Value:" + max);
	         // System.out.println(bin);
	       }catch(FileNotFoundException fnfe)
	        {
	            System.out.println("The specified file not found" + fnfe);
	        }
	        catch(IOException ioe)
	        {
	            System.out.println("I/O Exception: " + ioe); 
	        }
	        finally
	        {
	            try{
	               if(bis != null && fis!=null)
	               {
	       	          fis.close();
	                  bis.close();
	               }      
	             }catch(IOException ioe)
	              {
	                  System.out.println("Error in InputStream close(): " + ioe);
	              }         
	        }
	    
	     
	   }
	}
