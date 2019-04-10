import java.awt.*;
import java.awt.event.*;

public class mid2_2 extends java.awt.Frame{
	public static void main(String args[]){
		new mid2_2();
	}
	
	public mid2_2(){
		super("mid2_2");
		
		FlowLayout flowlayout= new FlowLayout(FlowLayout.CENTER);
		flowlayout.setHgap(5);
		flowlayout.setVgap(5);
		
		setLayout(flowlayout);
		
		Button button1=new Button("OK");
		Button button2=new Button("cancel");
		Button button3=new Button("yes");
		Button button4=new Button("no");
		Button button5=new Button("wow");
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		this.setSize(400,400);
		
		// Center the frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();

		if (frameSize.height > screenSize.height)
		  frameSize.height = screenSize.height;

		if (frameSize.width > screenSize.width)
		  frameSize.width = screenSize.width;

		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		// Aa¢DU£go£g!		
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}