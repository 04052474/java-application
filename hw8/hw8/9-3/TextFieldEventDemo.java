import java.awt.*;
import java.awt.event.*;

public class TextFieldEventDemo extends java.awt.Frame {  

  java.awt.TextField textfield;

  public static void main(String args[]){
    new TextFieldEventDemo();
  }
  
  // 建構函式
  public TextFieldEventDemo() {
    super("TextField Event Demo");

    // 定義 Layout Manager 為 FlowLayout
    setLayout(new FlowLayout());

    // 建構函式 1
    textfield = new TextField();
    // 設定文字欄位的顯示文字
    textfield.setText("TextField 1");
    // 設定文字欄位的顯示文字字數
    textfield.setColumns(10);
    // 設定背景顏色
    textfield.setBackground(Color.PINK);
    // 設定前景顏色
    textfield.setForeground(Color.CYAN);
    // 選取所有的文字內容
    textfield.selectAll();
    
    // 以Inner Class的方式使用TextListener介面
    textfield.addTextListener(new TextListener() {
      public void textValueChanged(TextEvent e) {
        if (e.getID() == TextEvent.TEXT_VALUE_CHANGED)
          System.out.println("文字欄位內容改變");
      }
    });

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
