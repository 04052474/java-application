import java.awt.*;
import java.awt.event.*;

public class hw4_3button extends java.awt.Frame {

  public static void main(String args[]){
    new hw4_3button();
  }
  
  // 建構函式
  public hw4_3button() {
    super("hw4_3button");

    final int row = 1;    // 列
    final int column = 2; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.Button button;

    // 設定字型 - 粗斜體字型
    button = new Button("hw4_3button");
    button.setFont(new Font("dialog", Font.BOLD | Font.ITALIC, 10));
    add(button);

    // 設定顏色
    button = new Button("Color Demo");
    // 設定背景顏色
    button.setBackground(new Color(120,50,0));
    // 設定前景顏色
    button.setForeground(new Color(245,185,60));
    add(button);

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

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
