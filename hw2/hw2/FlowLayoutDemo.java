import java.awt.*;
import java.awt.event.*;

public class FlowLayoutDemo extends java.awt.Frame {

  public static void main(String args[]){
    new FlowLayoutDemo();
  }
  
  // 建構函式
  public FlowLayoutDemo() {
    super("Flow Layout Demo");
    
    // 向水平中央對齊
    FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER); 

    // 設定物件間的水平間距
    flowlayout.setHgap(10);
    // 設定物件間的垂直間距
    flowlayout.setVgap(10);

    // 設定Layout Manager
    setLayout(flowlayout); 
    
    Button button1 = new Button("OK");
    Button button2 = new Button("Cancel");
    Button button3 = new Button("Yes");
    Button button4 = new Button("No");
    
    // 將物件加至Frame中
    add(button1);
    add(button2);
    add(button3);
    add(button4);

    // 設定視窗的大小
    this.setSize(300, 100);

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