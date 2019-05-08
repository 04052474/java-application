import java.awt.*;
import java.awt.event.*;

public class TextAreaDemo extends java.awt.Frame {

  public static void main(String args[]){
    new TextAreaDemo();
  }
  
  // 建構函式
  public TextAreaDemo() {
    super("TextArea Demo");

    final int row = 2;    // 列
    final int column = 2; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.TextArea textarea;

    // 建構函式 1
    textarea = new TextArea();
    // 設定顯示文字
    textarea.setText("TextArea 1");
    // 設定TextArea的顯示列數
    textarea.setRows(5);
    // 設定TextArea的顯示行數
    textarea.setColumns(20);

    java.awt.Panel panel1 = new Panel();
    panel1.add(textarea);
    add(panel1);

    // 建構函式 2
    textarea = new TextArea(8,12);
    // 設定顯示文字
    textarea.setText("TextArea 2");
    // 附加文字字串至TextArea之後
    textarea.append(" append text");
    // 選取所有的文字內容
    textarea.selectAll();

    java.awt.Panel panel2 = new Panel();
    panel2.add(textarea);
    add(panel2);

    // 建構函式 3
    textarea = new TextArea("TextArea 3");
    // 設定TextArea的顯示列數
    textarea.setRows(6);
    // 設定TextArea的顯示行數
    textarea.setColumns(15);
    // 自第pos位置之後，插入文字字串
    textarea.insert("insert text", 5);
    // 選取由selectionStart啟始位置
    // 至selectionEnd結束位置的文字內容
    textarea.select(3, 8);

    java.awt.Panel panel3 = new Panel();
    panel3.add(textarea);
    add(panel3);

    // 建構函式 5
    textarea = new TextArea("TextArea with only vertical scrollbar", 8, 15, TextArea.SCROLLBARS_VERTICAL_ONLY);
    // 設定背景顏色
    textarea.setBackground(new Color(120,50,0));
    // 設定前景顏色
    textarea.setForeground(new Color(245,185,60));

    java.awt.Panel panel4 = new Panel();
    panel4.add(textarea);
    add(panel4);

    // 設定視窗的大小
    this.setSize(320, 320);

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
