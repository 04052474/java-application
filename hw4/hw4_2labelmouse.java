import java.awt.*;
import java.awt.event.*;

public class hw4_2labelmouse extends java.awt.Frame implements
	MouseListener,
	MouseMotionListener{

  public static void main(String args[]){
    new hw4_2labelmouse();
  }
  
  // 建構函式
  public hw4_2labelmouse() {
    super("hw4_2labelmouse");
	this.addMouseListener(this);
	this.addMouseMotionListener(this);
	
    final int row = 1;    // 列
    final int column = 3; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.Label label;
	
	 // 建構函式 1
    label = new Label();
    // 設定Label類別之顯示文字
    label.setText("向左對齊");
    // 設定Label類別之對齊方式，向左對齊
    label.setAlignment(Label.LEFT);
    add(label);
	
    // 設定滑鼠指標
    label = new Label("mouse", Label.CENTER);
    // 選擇連線（手形）之滑鼠指標
    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
	label.addMouseListener(this);
	label.addMouseMotionListener(this);
    add(label);
	
	// 建構函式 3
    // 設定Label類別之對齊方式，向右對齊
    label = new Label("向右對齊", Label.RIGHT);
    add(label);
	
    // 設定視窗的大小
    this.setSize(250, 200);

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();

    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;

    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;

    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    // 顯示視窗
    this.setVisible(true);
    
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
	   //MouseListener介面方法
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
	  
	  //MouseMotionListener介面方法
	  public void mouseDragged(MouseEvent e){
		  System.out.println("mouseDragged:"+"x: " + e.getX() + ", y: " + e.getY());
	  }
	  public void mouseMoved(MouseEvent e){
		  System.out.println("mouseMoved"+"x: " + e.getX() + ", y: " + e.getY());
	  }
}
