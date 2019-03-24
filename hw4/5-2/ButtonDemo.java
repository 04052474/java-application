import java.awt.*;
import java.awt.event.*;

public class ButtonDemo extends java.awt.Frame {

  public static void main(String args[]){
    new ButtonDemo();
  }
  
  // 建構函式
  public ButtonDemo() {
    super("Button Demo");

    final int row = 3;    // 列
    final int column = 2; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.Button button;
    
    // 建構函式 1
    button = new Button();
    // 設定Button類別之文字標籤
    button.setLabel("OK");
    add(button);

    // 建構函式 2
    button = new Button("Cancel");
    add(button);

    // 設定字型 - 粗斜體字型
    button = new Button("Font Demo");
    button.setFont(new Font("dialog", Font.BOLD | Font.ITALIC, 10));
    add(button);

    // 設定顏色
    button = new Button("Color Demo");
    // 設定背景顏色
    button.setBackground(new Color(120,50,0));
    // 設定前景顏色
    button.setForeground(new Color(245,185,60));
    add(button);

    // 設定是否回應互動
    button = new Button("Disable");
    button.setEnabled(false);
    add(button);

    // 設定隱藏指令鈕
    button = new Button("Invisible");
    button.setVisible(false);
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
