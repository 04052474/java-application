import java.awt.*;
import java.awt.event.*;

public class CustomDialog extends java.awt.Dialog {

  Frame parent;
  Button btnOK, btnCancel;
  String title, text;
  boolean state, modal;
  
  // 建構函式
  public CustomDialog(Frame parent, String title, String text, boolean modal) {
    super(parent, title, modal);

    this.parent = parent;
    this.title = title;
    this.text = text;
    this.modal = modal;

    state = false;
	
    btnOK = new Button("OK");
    // 設定按鈕的最佳尺寸
    btnOK.setPreferredSize(new Dimension(60, 25));
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // 自訂方法
        button_actionPerformed(e);
      }
    });
    
    btnCancel = new Button("Cancel");
    // 設定按鈕的最佳尺寸
    btnCancel.setPreferredSize(new Dimension(60, 25));
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // 自訂方法
        button_actionPerformed(e);
      }
    });

    Panel panel1 = new Panel();
    panel1.add(new Label(text));

    Panel panel2 = new Panel();
    panel2.add(btnOK);
    panel2.add(btnCancel);

    add(panel1, BorderLayout.CENTER);
    add(panel2, BorderLayout.SOUTH);

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

  private void button_actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnOK)) {
      state = true;
    }
    else if (e.getSource().equals(btnCancel)) {
      state = false;
    }

    setVisible(false);
  }

  public boolean getState(){
    return state;
  }

  public void setState(boolean state){
    this.state = state;
  }
}
