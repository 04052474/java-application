import java.awt.*;
import java.awt.event.*;

public class hw4_1label extends java.awt.Frame {

  public static void main(String args[]){
    new hw4_1label();
  }
  
  // 建構函式
  public hw4_1label() {
    super("Label Demo");

    final int row = 2;    // 列
    final int column = 3; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.Label label;
    
    // 建構函式 1
    label = new Label();
    // 設定Label類別之顯示文字
    label.setText("向左對齊");
    // 設定Label類別之對齊方式，向左對齊
    label.setAlignment(Label.LEFT);
    add(label);

    // 建構函式 2
    label = new Label("向中央對齊");
    // 設定Label類別之對齊方式，向中央對齊
    label.setAlignment(Label.CENTER);
    add(label);

    // 建構函式 3
    // 設定Label類別之對齊方式，向右對齊
    label = new Label("向右對齊", Label.RIGHT);
    add(label);

    //
    // 使用Component抽象類別所提供的方法
    //
    // 設定字型 - 粗斜體字型
    label = new Label("hw4_1lable", Label.LEFT);
    label.setFont(new Font("標楷體", Font.BOLD | Font.ITALIC, 10));
    add(label);

    // 設定顏色
    label = new Label("Color Demo", Label.CENTER);
    // 設定背景顏色
    label.setBackground(new Color(120,50,0));
    // 設定前景顏色
    label.setForeground(new Color(245,185,60));
    add(label);

    // 設定滑鼠指標
    label = new Label("Cursor Demo", Label.RIGHT);
    // 選擇連線（手形）之滑鼠指標
    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
    add(label);

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
}
