import java.awt.*;
import java.awt.event.*;

public class hw3_3_2MouseWheelListener extends java.awt.Frame implements 
   MouseWheelListener{  

  // Main method
  public static void main(String[] args) {
    new hw3_3_2MouseWheelListener();
  }
  // 建構函式
  public hw3_3_2MouseWheelListener() {
    super("MouseWheelListener");
    
	this.addMouseWheelListener(this);
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
  public void mouseWheelMoved(MouseWheelEvent e){
	  if (e.getScrollType() == MouseWheelEvent.WHEEL_BLOCK_SCROLL) {
        System.out.println("WHEEL_BLOCK_SCROLL");
    }
    if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
        System.out.println("WHEEL_UNIT_SCROLL");
    }
         
    System.out.println("getScrollAmount: " + e.getScrollAmount());
    System.out.println("getUnitsToScroll: " + e.getUnitsToScroll());
    System.out.println("getWheelRotation: " + e.getWheelRotation());
  }
}
