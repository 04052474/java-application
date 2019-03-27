import java.awt.*;
import java.awt.event.*;

public class ChoiceDemo extends java.awt.Frame {

  public static void main(String args[]){
    new ChoiceDemo();
  }
  
  // 建構函式
  public ChoiceDemo() {
    super("Choice Demo");

    String[] items = {"Choice 1", "Choice 2", "Choice 4", "Choice 5"};
    
    java.awt.Choice choice;

    final int row = 2;    // 列
    final int column = 1; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.Panel panel1 = new Panel();

    // 建構函式
    choice = new Choice();
    
    // 設定Choice選取項目（Item），項目index自0開始。
    for (int i=0; i < items.length; i++)    
      choice.add(items[i]);

    // 自第2個項目之後，插入一選項項目，項目index自0開始。    
    choice.insert("Choice 3", 2);

    // 選取第3個選項項目，項目index自0開始。
    choice.select(3);
    panel1.add(choice);
    add(panel1);

    Label label = new Label();
    label.setText("Total items: " + choice.getItemCount() + ",    First Item: " + choice.getItem(0) + ",    Init Selected Index: " + choice.getSelectedIndex());
    add(label);

    // 設定視窗的大小
    this.setSize(350, 100);

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
