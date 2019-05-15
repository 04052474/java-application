import java.awt.*;
import java.awt.event.*;

public class CustomDialogDemo extends java.awt.Frame implements ActionListener {

  String menulabel[]={"File"};

  String menuitemlabel[][]={
    {"New", "Open", "-", "Save", "Save As...", "-", "Exit"}
  };

  Menu menu[] = new Menu[1];
  MenuItem menuitem[][] = new MenuItem[1][7];

  // Demo only
  Label label;

  FileDialog filedialog ;

  public static void main(String args[]){
    new CustomDialogDemo();
  }
  
  // 建構函式
  public CustomDialogDemo() {
    super("File Dialog Demo");

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
    for (int i=0; i<menulabel.length; i++){
      // 建立選單
      menu[i] = new Menu(menulabel[i]);
      menu[i].setFont(new Font("dialog", Font.PLAIN, 11));

      // 新增選單至選單列
      menuBar.add(menu[i]);
    }

    for(int i=0; i<menulabel.length; i++){
      for(int j=0; j<menuitemlabel[i].length; j++){
        if (menuitemlabel[i][j].equals("-")) {
          // 新增分隔線
          menu[i].addSeparator();
        }
        else {
          // 建立選單項目
          menuitem[i][j] = new MenuItem(menuitemlabel[i][j]);
          menuitem[i][j].setFont(new Font("dialog", Font.PLAIN, 11));

          // 註冊 ActionListener
          menuitem[i][j].addActionListener(this);

          // 新增選單項目
          menu[i].add(menuitem[i][j]);
        }          
      }
    }

    return menuBar;
  }

  // 實作ActionListener介面之方法
  public void actionPerformed(ActionEvent e) {
    // 取得產生動作事件的選單項目
    MenuItem menuitem = (MenuItem)e.getSource();

    if (menuitem.getLabel().equals("Exit")) { // Exit
      System.exit(0);
    }
    else {
      String title = menuitem.getLabel();
      
      CustomDialog dialog = new CustomDialog(this, title, title + " Dialog Demo.", true);
  
      boolean flag = dialog.getState();
      
      if(flag) 
        label.setText("Select OK Button.");
      else
        label.setText("Select Cancel Button.");
    }
  }
}
