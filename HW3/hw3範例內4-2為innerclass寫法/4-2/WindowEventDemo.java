import java.awt.*;
import java.awt.event.*;

public class WindowEventDemo extends java.awt.Frame {

  // Main method
  public static void main(String[] args) {
    new WindowEventDemo();
  }

  // 建構函式
  public WindowEventDemo() {
    super("Window Event Demo");

    // 以Inner Class的方式使用WindowAdapter
    this.addWindowListener(new WindowAdapter() {
      public void windowActivated(WindowEvent e) {
        System.out.println("視窗狀態由非作用中變為作用中");
      }
      
      public void windowClosed(WindowEvent e) {
        System.out.println("視窗已關閉");
      }
      
      public void windowClosing(WindowEvent e) {
        System.out.println("視窗正在關閉");
        dispose();
        System.exit(0);
      }
      
      public void windowDeactivated(WindowEvent e) {
        System.out.println("視窗狀態由作用中變為非作用中");
      }
      
      public void windowDeiconified(WindowEvent e) {
        System.out.println("視窗狀態由最小化變為正常狀態");
      }
      
      public void windowIconified(WindowEvent e) {
        System.out.println("視窗狀態由正常狀態變為最小化");
      }
      
      public void windowOpened(WindowEvent e) {
        System.out.println("視窗開啟");
      }    
    });    

    this.addWindowFocusListener(new WindowAdapter() {
      public void windowGainedFocus(WindowEvent e) {
        System.out.println("視窗取得輸入焦點");
      }
    
      public void windowLostFocus(WindowEvent e) {
        System.out.println("視窗失去輸入焦點");
      }
    });    
        
    this.addWindowStateListener(new WindowAdapter() {
      public void windowStateChanged(WindowEvent e) {
        System.out.println("視窗狀態改變");
      }
    });    

    // 設定視窗的大小
    this.setSize(200, 200);

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
  }
}
