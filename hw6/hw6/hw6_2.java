import java.awt.*;
import java.awt.event.*;

public class hw6_2 extends java.awt.Frame implements ActionListener, ItemListener {

  PopupMenu popupmenu, popupmenu2;

  String menuitemlabel[]={
    "A","B","-","C"};
	
  String cbmenuitemlabel[]={"D","E","F"};
  
  MenuItem menuitem[] = new MenuItem[4];
  CheckboxMenuItem checkboxmenuitem[] = new CheckboxMenuItem[3];
	
  MenuItem menuitemforlabel;
  // Demo only
  Label label;
  
  public static void main(String args[]){
    new hw6_2();
  }
  
  // 建構函式
  public hw6_2() {
    super("hw6_2 PopupMenu Demo");

    // Demo only
    label = new Label("Test");
	
    label.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        showPopmenu2(e);
      }
    });
    add(label, BorderLayout.NORTH);
	
    // 建立突顯式選單
    popupmenu = new PopupMenu("popup menu");

    for(int i=0; i<menuitemlabel.length; i++){
      if (i==3) { // 子選單
        // 建立子選單
        Menu submenu = new Menu(menuitemlabel[i]);
        submenu.setFont(new Font("dialog", Font.PLAIN, 11));
        
        // 建立核取方塊選單項目
        for (int j=0; j<cbmenuitemlabel.length; j++){
          checkboxmenuitem[j] = new CheckboxMenuItem(cbmenuitemlabel[j]);
          
          // 設定核取方塊選單項目之選取狀態
          if (j==0) 
            checkboxmenuitem[j].setState(true);
          
          checkboxmenuitem[j].setFont(new Font("dialog", Font.PLAIN, 11));

          // 註冊 ItemListener
          checkboxmenuitem[j].addItemListener(this);
    
          // 新增核取方塊選單項目至子選單
          submenu.add(checkboxmenuitem[j]);
        }
    
        // 新增子選單至突顯式選單中
        popupmenu.add(submenu);
      }
      else if (menuitemlabel[i].equals("-")) {
        // 新增分隔線
        popupmenu.addSeparator();
      }
      else {
        // 建立選單項目
        menuitem[i] = new MenuItem(menuitemlabel[i]);

        menuitem[i].setFont(new Font("dialog", Font.PLAIN, 11));

        // 註冊 ActionListener
        menuitem[i].addActionListener(this);

        // 新增選單項目至突顯式選單中
        popupmenu.add(menuitem[i]);
      }          
    }

    // 定義突顯式選單
    add(popupmenu);
	
	//另一個pop menu，點label會出現的!!!!!!!!!
	popupmenu2 = new PopupMenu("popup menu");
	menuitemforlabel = new MenuItem("A");
	menuitemforlabel.addActionListener(this);
	popupmenu2.add(menuitemforlabel);
	add(popupmenu2);
	
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

    this.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        showPopmenu(e);
      }
    });
    
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
  
  public void showPopmenu(MouseEvent e) {
    // 當按下滑鼠按鍵時
    if (e.getButton() == MouseEvent.BUTTON3) 
      // 顯示突顯式選單
      popupmenu.show(this, e.getX(), e.getY());
  }
	public void showPopmenu2(MouseEvent e){
		if (e.getButton() == MouseEvent.BUTTON3) {
			popupmenu2.show(this, e.getX(), e.getY());
		}
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
