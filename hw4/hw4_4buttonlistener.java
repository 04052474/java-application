import java.awt.*;
import java.awt.event.*;

public class hw4_4buttonlistener extends java.awt.Frame implements
ActionListener{
	Button button1= new Button();
	Button button2= new Button();
	Button button3= new Button();
	
	Button button4= new Button();
	Button button5= new Button();
	Button button6= new Button();
	
	public static void main(String args[]){
    new hw4_4buttonlistener();
  }
  public hw4_4buttonlistener() {


    // �w�q Layout Manager �� GridLayout
    setLayout(new FlowLayout());
	
	button1.setLabel("New");
	button1.addActionListener(this);
    add(button1);
	button2.setLabel("Open");
	button2.addActionListener(this);
    add(button2);
	button3.setLabel("Save");
	button3.addActionListener(this);
    add(button3);
	
	button4.setLabel("Cut");
	button4.addActionListener(this);
    add(button4);
	button5.setLabel("Copy");
	button5.addActionListener(this);
    add(button5);
	button6.setLabel("Paste");
	button6.addActionListener(this);
    add(button6);
	
	this.setSize(200, 200);
	// Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();

    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;

    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;

    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    // ��ܵ���
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
  
	public void actionPerformed (ActionEvent e){
	if(e.getSource().equals(button1))
		System.out.println("���U" + button1.getActionCommand()+"���s");
	
	if(e.getSource().equals(button2))
			System.out.println("���U" + button2.getActionCommand()+"���s");
	
	if(e.getSource().equals(button3))
			System.out.println("���U" + button3.getActionCommand()+"���s");
	
	
	if(e.getSource().equals(button4))
			System.out.println("���U" + button4.getActionCommand()+"���s");
	
	if(e.getSource().equals(button5))
			System.out.println("���U" + button5.getActionCommand()+"���s");
	
	if(e.getSource().equals(button6))
			System.out.println("���U" + button6.getActionCommand()+"���s");
	}
}