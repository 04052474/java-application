import java.awt.*;
import java.awt.event.*;

public class hw2_1 extends java.awt.Frame{
	public static void main(String args[]){
		new hw2_1();
	}
	
	public hw2_1(){
		super("hw2_1");
		
		FlowLayout flowlayout= new FlowLayout(FlowLayout.CENTER);
		flowlayout.setHgap(5);
		flowlayout.setVgap(5);
		
		setLayout(flowlayout);
		
		Button button1=new Button("OK");
		Button button2=new Button("cancel");
		Button button3=new Button("yes");
		Button button4=new Button("no");
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		
		this.setSize(400,400);
		
		// Center the frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();

		if (frameSize.height > screenSize.height)
		  frameSize.height = screenSize.height;

		if (frameSize.width > screenSize.width)
		  frameSize.width = screenSize.width;

		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		// Εγ¥άµψµ΅		
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}