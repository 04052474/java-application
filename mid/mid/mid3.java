import java.awt.*;
import java.awt.event.*;

public class mid3 extends java.awt.Frame implements
	MouseMotionListener,
	ActionListener{
	java.awt.Label label;
	Button button1= new Button();

  public static void main(String args[]){
    new mid3();
  }
  
  // 建構函式
  public mid3() {
    super("mid3");
	
    final int row = 2;    // 列
    final int column = 1; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

	
    // 設定滑鼠指標
    label = new Label("mouse", Label.CENTER);
	label.addMouseMotionListener(this);
    add(label);
	
	button1.setLabel("midtest");
	button1.addActionListener(this);
    add(button1);
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
	  
	  //MouseMotionListener介面方法
	  public void mouseDragged(MouseEvent e){
		  System.out.println("mouseDragged:"+"x: " + e.getX() + ", y: " + e.getY());
	  }
	  public void mouseMoved(MouseEvent e){
		  System.out.println("mouseMoved"+"x: " + e.getX() + ", y: " + e.getY());
	  }
	  public void actionPerformed (ActionEvent e){
	if(e.getSource().equals(button1))
		System.out.println("按下" + button1.getActionCommand()+"按鈕");
	
	}
}