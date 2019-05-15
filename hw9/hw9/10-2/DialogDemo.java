import java.awt.*;
import java.awt.event.*;

// 繼承java.awt.Dialog
public class DialogDemo extends java.awt.Dialog {

  public static void main(String args[]){
    new DialogDemo();
  }
  
  // 建構函式
  public DialogDemo() {
    super((Dialog)null);

    // 設定對話盒是否為無邊框及標題列樣式
    this.setUndecorated(true);

    // 設定對話盒的大小
    this.setSize(250, 150);

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension dialogSize = this.getSize();

    if (dialogSize.height > screenSize.height)
      dialogSize.height = screenSize.height;

    if (dialogSize.width > screenSize.width)
      dialogSize.width = screenSize.width;

    this.setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);

    // 顯示對話盒
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
