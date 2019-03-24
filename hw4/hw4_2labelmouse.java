import java.awt.*;
import java.awt.event.*;

public class hw4_2labelmouse extends java.awt.Frame implements
	MouseListener,
	MouseMotionListener{

  public static void main(String args[]){
    new hw4_2labelmouse();
  }
  
  // �غc�禡
  public hw4_2labelmouse() {
    super("hw4_2labelmouse");
	this.addMouseListener(this);
	this.addMouseMotionListener(this);
	
    final int row = 1;    // �C
    final int column = 3; // ��

    // �w�q Layout Manager �� GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.Label label;
	
	 // �غc�禡 1
    label = new Label();
    // �]�wLabel���O����ܤ�r
    label.setText("�V�����");
    // �]�wLabel���O������覡�A�V�����
    label.setAlignment(Label.LEFT);
    add(label);
	
    // �]�w�ƹ�����
    label = new Label("mouse", Label.CENTER);
    // ��ܳs�u�]��Ρ^���ƹ�����
    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
	label.addMouseListener(this);
	label.addMouseMotionListener(this);
    add(label);
	
	// �غc�禡 3
    // �]�wLabel���O������覡�A�V�k���
    label = new Label("�V�k���", Label.RIGHT);
    add(label);
	
    // �]�w�������j�p
    this.setSize(250, 200);

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
	   //MouseListener������k
	  public void mouseClicked(MouseEvent e){
		  System.out.println("mouseClicked");
	  }
	  public void mouseEntered(MouseEvent e){
		  System.out.println("mouseEntered");
	  }
	  public void mouseExited(MouseEvent e){
		  System.out.println("mouseExited");
	  }
	  public void mousePressed(MouseEvent e){
		  if (e.getButton() == MouseEvent.BUTTON1) {
				System.out.println("left button");
			}
			if (e.getButton() == MouseEvent.BUTTON2) {
				System.out.println("middle button");
			}
			if (e.getButton() == MouseEvent.BUTTON3) {
				System.out.println("right button");
			}
	  }
	  public void mouseReleased(MouseEvent e){
		  System.out.println("mouseReleased");
	  }
	  
	  //MouseMotionListener������k
	  public void mouseDragged(MouseEvent e){
		  System.out.println("mouseDragged:"+"x: " + e.getX() + ", y: " + e.getY());
	  }
	  public void mouseMoved(MouseEvent e){
		  System.out.println("mouseMoved"+"x: " + e.getX() + ", y: " + e.getY());
	  }
}
