import java.io.*; 
import java.net.*; 
public class MyClient { 
    public static void main(String[] args) 
    { 
        try { 
            
            // initializing Socket 
            Socket soc = new Socket("localhost", 1234); 
            
            DataOutputStream d = new DataOutputStream( 
                soc.getOutputStream()); 
            
            // message to display 
            d.writeUTF("Hello My name is Mishal!!");          
         
            d.flush(); 
            
            // closing DataOutputStream 
            d.close(); 
            
            // closing socket 
            soc.close(); 
        } 
        
        // to initialize Exception in run time 
        catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
}
