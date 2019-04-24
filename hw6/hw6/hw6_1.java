import java.awt.*;
import java.awt.event.*;

public class hw6_1 extends java.awt.Frame implements ActionListener, ItemListener {

  String menulabel[]={"File", "Edit","Draw","Help"};

  String menuitemlabel[][]={
    {"New", "-", "Open", "Save", "Save As...", "-", "Exit"},
    {"Copy", "Cut", "Paste"},
	{"Share","Line","Pot"},
	{"Help"}
  };
  
  String cbmenuitemlabel[]={"Circle", "Rectangle"};
  
  int menuShortCut[][]={
    {KeyEvent.VK_N, 0, KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_A, 0, KeyEvent.VK_E},
    {KeyEvent.VK_C, KeyEvent.VK_X, KeyEvent.VK_V},
	{0,KeyEvent.VK_L,KeyEvent.VK_P},
	{KeyEvent.VK_E}
  };

  int cbmenuShortCut[]={KeyEvent.VK_R, KeyEvent.VK_T};

  Menu menu[] = new Menu[4];
  MenuItem menuitem[][] = new MenuItem[4][7];
  CheckboxMenuItem checkboxmenuitem[] = new CheckboxMenuItem[2];

  // Demo only
  Label label;

  public static void main(String args[]){
    new hw6_1();
  }
  
  // 建構函式
  public hw6_1() {
    super("hw6_1 Menu Shortcut Demo");

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
        if (i==2 && j==0) { // 子選單
          // 建立子選單
          Menu submenu = new Menu(menuitemlabel[i][j]);
          submenu.setFont(new Font("dialog", Font.PLAIN, 11));
          
          // 建立核取方塊選單項目
          for (int k=0; k<cbmenuitemlabel.length; k++){
            checkboxmenuitem[k] = new CheckboxMenuItem(cbmenuitemlabel[k]);
            
            // 設定核取方塊選單項目之選取狀態
            
            
            // 設定核取方塊選單項目的選單快速鍵
            checkboxmenuitem[k].setShortcut(new MenuShortcut(cbmenuShortCut[k], false));
            checkboxmenuitem[k].setFont(new Font("dialog", Font.PLAIN, 11));

            // 註冊 ItemListener
            checkboxmenuitem[k].addItemListener(this);
      
            // 新增核取方塊選單項目至子選單
            submenu.add(checkboxmenuitem[k]);
          }
      
          menu[i].add(submenu);
        }
        else if (menuitemlabel[i][j].equals("-")) {
          // 新增分隔線
          menu[i].addSeparator();
        }
        else {
          // 建立選單項目並使用選單快速鍵
          if (menuShortCut[i][j] != 0) 
            menuitem[i][j] = new MenuItem(menuitemlabel[i][j], new MenuShortcut(menuShortCut[i][j], false));
          else
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
      label.setText("Select "  + menuitem.getLabel() + " Menu Item.");
    }
  }

  public void itemStateChanged(ItemEvent e) {
    // 取得產生項目事件的物件
    CheckboxMenuItem cbmi = (CheckboxMenuItem)(e.getItemSelectable());
    
    for (int i=0; i < checkboxmenuitem.length; i++) {
      if(cbmi == checkboxmenuitem[i]) {
        checkboxmenuitem[i].setState(true);

        label.setText("Select " + checkboxmenuitem[i].getLabel() + " Checkbox Menu Item.");
      }
      else
        checkboxmenuitem[i].setState(false);
    }
  }
}