import java.awt.*;
import java.awt.event.*;

public class hw5_1checkbox extends java.awt.Frame implements ItemListener{
	
	Checkbox[] checkbox=new Checkbox[7];
	
	public static void main(String args[]){
		new hw5_1checkbox();
	}
	
	public hw5_1checkbox(){
		super("hw5_1checkbox");
		
		final int row=2;
		final int column=1;
		
		setLayout(new GridLayout(row,column));
		
		java.awt.Panel panel1=new Panel();
		
		
    // 建構函式 1
    checkbox[0] = new Checkbox();
    // 設定Checkbox類別之文字標籤
    checkbox[0].setLabel("Checkbox 0");
    // 設定Checkbox類別的選取狀態
    checkbox[0].setState(true);
    panel1.add(checkbox[0]);
	
	// 建構函式 2
    checkbox[1] = new Checkbox("Checkbox 1");
    // 設定Checkbox類別的選取狀態
    checkbox[1].setState(false);
    panel1.add(checkbox[1]);
	
	 // 建構函式 3
    checkbox[2] = new Checkbox("Checkbox 2", true);
    panel1.add(checkbox[2]);
	
	add(panel1);
	
	
	java.awt.Panel panel2=new Panel();
	
	// 建構群組
    java.awt.CheckboxGroup group = new CheckboxGroup() ;
	// 建構函式 1
    checkbox[3] = new Checkbox();
    // 設定Checkbox類別之文字標籤
    checkbox[3].setLabel("Checkbox 3");
	checkbox[3].setState(true);
    // 設定Checkbox類別的群組
    checkbox[3].setCheckboxGroup(group);
    panel2.add(checkbox[3]);
	
	// 建構函式 4
    checkbox[4] = new Checkbox("Checkbox 4", false, group);
    // 設定Checkbox類別的群組
	checkbox[4].setEnabled(false);
    checkbox[4].setCheckboxGroup(group);
    panel2.add(checkbox[4]);
	
	checkbox[5]=new Checkbox("Checkbox 5",group,false);
	checkbox[5].setCheckboxGroup(group);
	panel2.add(checkbox[5]);
	
	add(panel2);
	
	for(int i=3;i<=5;i++){
		checkbox[i].addItemListener(this);
	}
	// 設定視窗的大小
    this.setSize(400, 100);

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
			String source = null;
			// 取得產生項目事件的物件
			Checkbox cb = (Checkbox)(e.getItemSelectable());
			
			for (int i=3; i <=5; i++) {
			  if(cb == checkbox[i]) {
				source = "Select " + checkbox[i].getLabel();

			System.out.println(source);
		  }
		}
	}
}