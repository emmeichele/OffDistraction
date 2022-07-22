package app;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class Application {
 
    /**
	 * 	OffDistraction !!!
	 */
	
	public Application() {}
	
//	public static void main(String args[]) throws InterruptedException, IOException {
		
		//Process p = Runtime.getRuntime().exec("ls /Applications");
//		String x = executeCmd();
		
//		JPanel middlePanel = new JPanel ();
		
	//       JFrame frame = new JFrame("OffDistraction");
	//       JTextArea textArea = new JTextArea(x);
	//      textArea.setBounds(100,100,300,300);
	//      textArea.setEditable(false);
	//      textArea.setWrapStyleWord(true);
	//      JScrollPane jScrollPane1 = new JScrollPane(textArea);
	//     jScrollPane1.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        
	//     middlePanel.add (jScrollPane1);
	//     frame.add(middlePanel);
        
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); won't terminate JVM if user thread running
	//     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//     frame.add(textArea);
        //     frame.setSize(500, 600);
	//    frame.pack();
	//   frame.setLayout(null);
	//   frame.setVisible(true);
     
       
        
       
    /*    
        Thread t = new Thread() {
 
            @Override
            public void run() {
                while (true) {
                    System.out.println("User thread is running");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
 
        t.start();
 	*/
    
	private static String name;
	private static String time;
	
	public static void setName(String n) {name=n;}
	public static String getName() {return name;}
	public static void setTime(String h) {time=h;}
	public static String getTime() {return time;}

	

	
}
