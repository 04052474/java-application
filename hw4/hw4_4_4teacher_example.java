import java.awt.*;
import java.awt.event.*;

public class hw4_4_4teacher_example extends java.awt.Frame implements ActionListener{
	Button[] button =new Button[6];
	
	public static void main(String[] args){
		new hw4_4_4teacher_example();
	}
	
	public hw4_4_4teacher_example(){
		super("hw4_4_4teacher_example");
		
		setLayout(new FlowLayout());
		
		String[] label={"New","Open","Save","Cut","Copy","Paste"};
		
		for(int i=0;i<6;i++){
			button[i] = new Button (label[i]);
			
			button[i].addActionListener(this);
			
			add(button[i]);
		}
	this.setSize(200, 200);
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
	public void actionPerformed(ActionEvent e){
		String source=null;
		for(int i=0;i<6;i++){
			if(e.getSource().equals(button[i]))
				source="Press" + button[i].getActionCommand() + "button";
		}
		
	//String source="Press" + e.getActionCommand() + "button";
		System.out.println(source);
	}
}