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
  
  // �غc�禡
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
	
    // �إ߬��㦡���
    popupmenu = new PopupMenu("popup menu");

    for(int i=0; i<menuitemlabel.length; i++){
      if (i==3) { // �l���
        // �إߤl���
        Menu submenu = new Menu(menuitemlabel[i]);
        submenu.setFont(new Font("dialog", Font.PLAIN, 11));
        
        // �إ߮֨������涵��
        for (int j=0; j<cbmenuitemlabel.length; j++){
          checkboxmenuitem[j] = new CheckboxMenuItem(cbmenuitemlabel[j]);
          
          // �]�w�֨������涵�ؤ�������A
          if (j==0) 
            checkboxmenuitem[j].setState(true);
          
          checkboxmenuitem[j].setFont(new Font("dialog", Font.PLAIN, 11));

          // ���U ItemListener
          checkboxmenuitem[j].addItemListener(this);
    
          // �s�W�֨������涵�ئܤl���
          submenu.add(checkboxmenuitem[j]);
        }
    
        // �s�W�l���ܬ��㦡��椤
        popupmenu.add(submenu);
      }
      else if (menuitemlabel[i].equals("-")) {
        // �s�W���j�u
        popupmenu.addSeparator();
      }
      else {
        // �إ߿�涵��
        menuitem[i] = new MenuItem(menuitemlabel[i]);

        menuitem[i].setFont(new Font("dialog", Font.PLAIN, 11));

        // ���U ActionListener
        menuitem[i].addActionListener(this);

        // �s�W��涵�ئܬ��㦡��椤
        popupmenu.add(menuitem[i]);
      }          
    }

    // �w�q���㦡���
    add(popupmenu);
	
	//�t�@��pop menu�A�Ilabel�|�X�{��!!!!!!!!!
	popupmenu2 = new PopupMenu("popup menu");
	menuitemforlabel = new MenuItem("A");
	menuitemforlabel.addActionListener(this);
	popupmenu2.add(menuitemforlabel);
	add(popupmenu2);
	
    // �]�w�������j�p
    this.setSize(250, 250);

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();

    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;

    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;

    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    // ��ܵ���
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
    // �����U�ƹ������
    if (e.getButton() == MouseEvent.BUTTON3) 
      // ��ܬ��㦡���
      popupmenu.show(this, e.getX(), e.getY());
  }
	public void showPopmenu2(MouseEvent e){
		if (e.getButton() == MouseEvent.BUTTON3) {
			popupmenu2.show(this, e.getX(), e.getY());
		}
	}
  // ��@ActionListener��������k
  public void actionPerformed(ActionEvent e) {
    // ���o���Ͱʧ@�ƥ󪺿�涵��
    MenuItem menuitem = (MenuItem)e.getSource();

    if (menuitem.getLabel().equals("Exit")) { // Exit
      System.exit(0);
    }
    else {
      label.setText("Select "  + menuitem.getLabel() + " Menu Item.");
    }
  }

  public void itemStateChanged(ItemEvent e) {
    // ���o���Ͷ��بƥ󪺪���
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