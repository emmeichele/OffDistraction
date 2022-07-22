package app;

import java.util.ArrayList;

public class Admin {
	
	public Admin() {}
	
	private static String password;
	private static boolean lock = false;
	private static ArrayList <Admin> admins = new ArrayList<Admin>();
	
	public static void setAdmins(Admin ex) {admins.add(ex);}
	
	public static Admin getAdmins(int i) { //finire get and setter dell'admin
		
		
		
		
		return admins.get(i);
	}
	
	public String getPassword() {return password;}
	public void setPassword(String pw) {
		
		System.out.println("la password è stata settata: " + password);
		password=pw;
	}
	
	public boolean getlock() {return lock;}
	public void setlock(boolean state) { lock = state;}
}
