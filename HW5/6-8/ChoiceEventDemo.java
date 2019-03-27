import java.awt.*;
import java.awt.event.*;

// 實作ItemListener介面
public class ChoiceEventDemo extends java.awt.Frame implements ItemListener {

  java.awt.Choice choice;
  java.awt.Label label;

  public static void main(String args[]){
    new ChoiceEventDemo();
  }
  
  // 建構函式
  public ChoiceEventDemo() {
    super("Choice Event Demo");

    String[] items = {"Choice 1", "Choice 2", "Choice 4", "Choice 5"};
    
    final int row = 2;    // 列
    final int column = 1; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.Panel panel1 = new Panel();

    // 建構函式
    choice = new Choice();
    // 註冊 ItemListener
    choice.addItemListener(this);
    
    // 設定Choice選取項目（Item），項目index自0開始。
    for (int i=0; i < items.length; i++)    
      choice.add(items[i]);

    // 自第2個項目之後，插入一選項項目，項目index自0開始。    
    choice.insert("Choice 3", 2);

    // 選取第3個選項項目，項目index自0開始。
    choice.select(3);
    panel1.add(choice);
    add(panel1);

    label = new Label();
    // Demo Only
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

  public void itemStateChanged(ItemEvent e) {
    // 取得產生項目事件的物件
    Choice ch = (Choice)(e.getItemSelectable());

    label.setText("Total items: " + ch.getItemCount() + ",    Selected Item: " + ch.getSelectedItem() + ",    Selected Index: " + ch.getSelectedIndex());
  }
}
