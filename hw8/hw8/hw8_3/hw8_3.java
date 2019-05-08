import java.awt.*;
import java.awt.event.*;

public class hw8_3 extends java.awt.Frame {

  java.awt.TextArea textarea;

  public static void main(String args[]){
    new hw8_3();
  }
  
  // 建構函式
  public hw8_3() {
    super("hw8_3 TextArea Event Demo");

    textarea = new TextArea();
    // 設定顯示文字
    textarea.setText("TextArea Event Demo");
    // 設定TextArea的顯示列數
    textarea.setRows(10);
    // 設定TextArea的顯示行數
    textarea.setColumns(30);

    // 以Inner Class的方式使用TextListener介面
    textarea.addTextListener(new TextListener() {
      public void textValueChanged(TextEvent e) {
        if (e.getID() == TextEvent.TEXT_VALUE_CHANGED)
          System.out.println("文字區域內容改變");
      }
    });
	
	textarea.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e){
			int i=e.getKeyCode();
			
			System.out.println("Key Pressed: "+i);
		}
		public void keyReleased(KeyEvent e){
			System.out.println("Char: "+e.getKeyChar());
		}
		public void keyTyped(KeyEvent e){}
	});
	
	textarea.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
		  System.out.println("按下並釋放滑鼠按鍵" + e.getX() + ", y: " + e.getY());
	  }
	  public void mouseEntered(MouseEvent e){
		  System.out.println("滑鼠移至物件上方"+ e.getX() + ", y: " + e.getY());
	  }
	  public void mouseExited(MouseEvent e){
		  System.out.println("滑鼠離開物件"+ e.getX() + ", y: " + e.getY());
	  }
	  public void mousePressed(MouseEvent e){
		  System.out.println("按下滑鼠按鍵"+ e.getX() + ", y: " + e.getY());

	  }
	  public void mouseReleased(MouseEvent e){
		  System.out.println("釋放滑鼠按鍵"+ e.getX() + ", y: " + e.getY());
	  }
	});
	
	textarea.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e){
		  System.out.println("按下滑鼠按鍵並拖曳滑鼠 "+"x: " + e.getX() + ", y: " + e.getY());
	  }
	  public void mouseMoved(MouseEvent e){
		  System.out.println("在物件上方移動滑鼠 "+"x: " + e.getX() + ", y: " + e.getY());
	  }
	});
    java.awt.Panel panel1 = new Panel();
    panel1.add(textarea);
    add(panel1);

    // 設定視窗的大小
    this.setSize(250, 220);

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
}
