import java.awt.*;
import java.awt.event.*;

public class MenuDemo extends java.awt.Frame {

  public static void main(String args[]){
    new MenuDemo();
  }
  
  // 建構函式
  public MenuDemo() {
    super("Menu Demo");

    // 建立選單列
    MenuBar menuBar = new MenuBar();

    // 定義視窗之選單列
    setMenuBar(menuBar);

    Menu menu[] = new Menu[2];
    
    // 建立File選單
    menu[0] = new Menu("File");
    // 新增選單至選單列
    menuBar.add(menu[0]);

    // 建立子選單
    Menu submenu = new Menu("Sub Menu");
    // 新增子選單至選單中
    menu[0].add(submenu);
    menu[0].addSeparator();
	
    // 建立Help選單
    menu[1] = new Menu("Help");
    // 新增分隔線（另一種方式）
    menu[1].add("-");

    // 設定選單列中的輔助說明選單（Help Menu）
    menuBar.setHelpMenu(menu[1]);

    // 取得選單列所有選單的數目
    for (int i=0; i<menuBar.getMenuCount(); i++) {
      // 取得選單列中指定index之選單
      System.out.println("Menu " + i + ": " + menuBar.getMenu(i).getLabel());
    }

    // 取得各選單所有選單項目的數目
    for (int i=0; i<menu.length; i++) {
      for (int j=0; j<menu[i].getItemCount(); j++) {
        // 取得各選單指定index之選單項目
        System.out.println("Menu Item " + j + " at " + menu[i].getLabel() + " menu: " + menu[i].getItem(j).getLabel());
      }
    }

    // 設定視窗的大小
    this.setSize(250, 250);

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