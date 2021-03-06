import java.awt.*;
import java.awt.event.*;

public class hw2_2 extends java.awt.Frame{
	public static void main(String args[]){
		new hw2_2();
	}
	
	public hw2_2(){
		super("hw2_2 borderlayout");
		
		BorderLayout borderlayout= new BorderLayout();
		
		setLayout(borderlayout);
		
		Button button1=new Button("EAST");
		Button button2=new Button("SOUTH");
		Button button3=new Button("NORTH");
		Button button4=new Button("WEST");
		Button button5=new Button("CENTER");
		
		add(button1,BorderLayout.EAST);
		add(button2,BorderLayout.SOUTH);
		add(button3,BorderLayout.NORTH);
		add(button4,BorderLayout.WEST);
		add(button5,BorderLayout.CENTER);
		
		this.setSize(400,400);
		
		// Center the frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();

		if (frameSize.height > screenSize.height)
		  frameSize.height = screenSize.height;

		if (frameSize.width > screenSize.width)
		  frameSize.width = screenSize.width;

		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		

		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}