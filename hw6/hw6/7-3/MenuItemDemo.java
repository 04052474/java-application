import java.awt.*;
import java.awt.event.*;

// 實作ActionListener介面
public class MenuItemDemo extends java.awt.Frame implements ActionListener {

  Menu menu[] = new Menu[2];
  MenuItem menuitem[] = new MenuItem[8];

  // Demo only
  Label label;

  public static void main(String args[]){
    new MenuItemDemo();
  }
  
  // 建構函式
  public MenuItemDemo() {
    super("Menu Item Demo");

    // 定義 Layout Manager 為 BorderLayout
    setLayout(new BorderLayout());
    
    // Demo only
    label = new Label();
    add(label, BorderLayout.SOUTH);

    // 建立選單列
    MenuBar menuBar = createMenuBar();

    // 定義視窗使用者介面之選單列
    setMenuBar(menuBar);

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

  private MenuBar createMenuBar() {
    // 建立選單列
    MenuBar menuBar = new MenuBar();

    // 建立選單
    menu[0] = new Menu("File");

    // 建立選單項目
    menuitem[0] = new MenuItem("New");
    // 註冊 ActionListener
    menuitem[0].addActionListener(this);

    menuitem[1] = new MenuItem("Open");
    // 註冊 ActionListener
    menuitem[1].addActionListener(this);

    menuitem[2] = new MenuItem("Save");
    // 註冊 ActionListener
    menuitem[2].addActionListener(this);

    menuitem[3] = new MenuItem("Save As...");
    // 註冊 ActionListener
    menuitem[3].addActionListener(this);

    menuitem[4] = new MenuItem("Exit");
    // 註冊 ActionListener
    menuitem[4].addActionListener(this);

    // 新增選單項目
    menu[0].add(menuitem[0]);
    menu[0].add(menuitem[1]);
    // 新增分隔線（另一種方式）
    menu[0].add("-");
    menu[0].add(menuitem[2]);
    menu[0].add(menuitem[3]);
    // 新增分隔線
    menu[0].addSeparator();
    menu[0].add(menuitem[4]);
    
    // 新增選單至選單列
    menuBar.add(menu[0]);

    // 建立Help選單
    menu[1] = new Menu("Help");

    menuitem[5] = new MenuItem("Index");
    // 註冊 ActionListener
    menuitem[5].addActionListener(this);

    menuitem[6] = new MenuItem("Use Help");
    // 註冊 ActionListener
    menuitem[6].addActionListener(this);

    menuitem[7] = new MenuItem("About");
    // 註冊 ActionListener
    menuitem[7].addActionListener(this);

    menu[1].add(menuitem[5]);
    menu[1].add(menuitem[6]);
    menu[1].add("-");
    menu[1].add(menuitem[7]);

    // 設定選單列中的輔助說明選單（Help Menu）
    menuBar.setHelpMenu(menu[1]);

    return menuBar;
  }

  // 實作ActionListener介面之方法
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(menuitem[4])) { // Exit
      System.exit(0);
    }
    else {
      // 取得產生動作事件的選單項目
      MenuItem menuitem = (MenuItem)e.getSource();
      label.setText("Select "  + menuitem.getLabel() + " Menu Item.");
    }
  }
}