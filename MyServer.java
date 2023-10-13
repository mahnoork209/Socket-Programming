import java.io.*; 
import java.net.*; 
public class MyServer { 
	public static void main(String[] args) 
	{ 
		try { 
			ServerSocket ss = new ServerSocket(1234); 
			
			// establishes connection 
			Socket soc = ss.accept(); 
			
			// invoking input stream 
			DataInputStream dis = new DataInputStream(ss.getInputStream()); 
			
			String str = (String)dis.readUTF(); 
			
			System.out.println("message= " + str); 
			
			// closing socket 
			ss.close(); 
			
		} // for catching Exception in run time 
		catch (Exception e) { 
			System.out.println(e); 
		} 
	} 
}
