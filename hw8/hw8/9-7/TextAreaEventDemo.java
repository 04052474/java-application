import java.awt.*;
import java.awt.event.*;

public class TextAreaEventDemo extends java.awt.Frame {

  java.awt.TextArea textarea;

  public static void main(String args[]){
    new TextAreaEventDemo();
  }
  
  // 建構函式
  public TextAreaEventDemo() {
    super("TextArea Event Demo");

    textarea = new TextArea();
    // 設定顯示文字
    textarea.setText("TextArea Event Demo");
    // 設定TextArea的顯示列數
    textarea.setRows(10);
    // 設定TextArea的顯示行數
    textarea.setColumns(30);

    // 以Inner Class的方式使用TextListener介面
    textarea.addTextListener(new TextListener() {
      public void textValueChanged(TextEvent e) {
        if (e.getID() == TextEvent.TEXT_VALUE_CHANGED)
          System.out.println("文字區域內容改變");
      }
    });

    java.awt.Panel panel1 = new Panel();
    panel1.add(textarea);
    add(panel1);

    // 設定視窗的大小
    this.setSize(250, 220);

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
