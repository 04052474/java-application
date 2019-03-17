import java.awt.*;
import java.awt.event.*;

public class hw3_3_1MouseMouseMotion extends java.awt.Frame implements 
   MouseListener,
   MouseMotionListener{  

  // Main method
  public static void main(String[] args) {
    new hw3_3_1MouseMouseMotion();
  }
  // 建構函式
  public hw3_3_1MouseMouseMotion() {
    super("Mouse&MouseMotion");
    this.addMouseListener(this);
	this.addMouseMotionListener(this);
    // 設定視窗的大小
    this.setSize(new Dimension(200, 200));

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
