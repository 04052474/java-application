import java.awt.*;
import java.awt.event.*;

public class FileDialog extends java.awt.FileDialog {

  Frame parent;
  Button btnOK, btnCancel;
  String title, text;
  boolean state, modal;
  
  // 建構函式
  public FileDialog(Frame parent, String title, int mode) {
    super(parent, title, mode);

    
    // 設定對話盒是否為無邊框及標題列樣式
    this.setUndecorated(false);

    // 設定對話盒的大小
    this.setSize(220, 120);
    
    Dimension frameSize = parent.getSize();
    Dimension dialogSize = this.getSize();
    
    this.setLocation(
      (frameSize.width - dialogSize.width) / 2 + parent.getLocation().x,
      (frameSize.height - dialogSize.height) / 2 + parent.getLocation().y);

    // 顯示對話盒
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void WindowDeactivated(WindowEvent e) {
        setVisible(false);
      }
    });
  }

  
}
