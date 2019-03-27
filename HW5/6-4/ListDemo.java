import java.awt.*;
import java.awt.event.*;

public class ListDemo extends java.awt.Frame {

  public static void main(String args[]){
    new ListDemo();
  }
  
  // 建構函式
  public ListDemo() {
    super("List Demo");

    final int row = 1;    // 列
    final int column = 3; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    // 建構函式 1
    // 預設顯示項目列數為4
    // 且不允許多重選擇項目
    java.awt.List list = new List();
    
    // 設定List選取項目
    for (int i=0; i < 10; i++)    
      list.add("List " + i);
      
    // 設定是否允許項目被多重選擇  
    list.setMultipleMode(false);

    // 選取選項項目
    list.select(4);

    java.awt.Panel panel1 = new Panel();
    panel1.add(list);
    add(panel1);

    // 建構函式 2
    // 可顯示的項目列數為5
    list = new List(5);
    
    // 設定List選取項目（Item）
    for (int i=0; i < 10; i++)    
      list.add("List " + i);
      
    // 設定是否允許項目被多重選擇  
    list.setMultipleMode(true);

    // 選取選項項目
    list.select(4);
    list.select(6);

    java.awt.Panel panel2 = new Panel();
    panel2.add(list);
    add(panel2);

    // 建構函式 3
    // 可顯示的項目列數為6
    // 設定允許項目被多重選擇  
    list = new List(6, true);
    
    // 設定List選取項目（Item）
    for (int i=0; i < 10; i++)    
      list.add("List " + i);
      
    // 選取選項項目
    list.select(2);
    list.select(3);

    java.awt.Panel panel3 = new Panel();
    panel3.add(list);
    add(panel3);

    // 設定視窗的大小
    this.setSize(420, 150);

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
