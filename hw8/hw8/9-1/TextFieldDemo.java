import java.awt.*;
import java.awt.event.*;

public class TextFieldDemo extends java.awt.Frame {

  public static void main(String args[]){
    new TextFieldDemo();
  }
  
  // 建構函式
  public TextFieldDemo() {
    super("TextField Demo");

    // 定義 Layout Manager 為 FlowLayout
    setLayout(new FlowLayout());

    java.awt.TextField textfield;

    // 建構函式 1
    textfield = new TextField();
    // 設定文字欄位的顯示文字
    textfield.setText("TextField 1");
    // 設定文字欄位的顯示文字字數
    textfield.setColumns(3);
    // 設定背景顏色
    textfield.setBackground(Color.PINK);
    // 設定前景顏色
    textfield.setForeground(Color.CYAN);
    // 選取所有的文字內容
    textfield.selectAll();
    add(textfield);

    // 建構函式 2
    textfield = new TextField("TextField 2");
    // 設定回應字元
    textfield.setEchoChar('*');
    add(textfield);

    // 建構函式 3
    textfield = new TextField(8);
    // 設定文字欄位的顯示文字
    textfield.setText("TextField 3");
    // 設定是否允許編輯
    textfield.setEditable(false);
    add(textfield);

    // 建構函式 4
    textfield = new TextField("TextField 4", 8);
    // 選取由selectionStart啟始位置
    // 至selectionEnd結束位置的文字內容
    textfield.select(3, 8);
    add(textfield);

    // 設定視窗的大小
    this.setSize(200, 100);

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
