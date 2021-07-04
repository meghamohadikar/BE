import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;  
import java.io.FileWriter; 
 
public class ReadFileInByteArrayWithFileInputStream {
     
    public static void main(String[] args) {

    File file = new File("C:/Users/mmohadik/my files/UC-b2fc1b6c-0998-4603-85f1-00a82f528180.pdf");

        FileInputStream fin = null;
        try {
			FileWriter fout = new FileWriter("C:/Users/mmohadik/Documents/workspace-sts-3.9.11.RELEASE/data2.txt");
            // create FileInputStream object
            fin = new FileInputStream(file);
 
            byte fileContent[] = new byte[(int)file.length()];
             
            // Reads up to certain bytes of data from this input stream into an array of bytes.
            fin.read(fileContent);
            //create string from byte array
            String s = new String(fileContent);
            System.out.println("File content: " + s);
			fout.write(s);    
			fout.close();
             
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
        catch (IOException ioe) {
            System.out.println("Exception while reading file " + ioe);
        }
        finally {
            // close the streams using close method
            try {
                if (fin != null) {
                    fin.close();
					 
                }
            }
            catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }
        }
    }
}