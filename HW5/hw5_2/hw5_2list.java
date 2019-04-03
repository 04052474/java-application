import java.awt.*;
import java.awt.event.*;

public class hw5_2list extends java.awt.Frame implements ItemListener{
	
	java.awt.List list;
	java.awt.Label label;
	
	public static void main(String args[]){
		new hw5_2list();
	}
	
	public hw5_2list(){
		super("hw5_2list");
		
		final int row=2;
		final int column=2;
		
		setLayout(new GridLayout(row,column));
		
		list=new List();// 預設顯示項目列數為4
		
		// 註冊 ItemListener
		list.addItemListener(this);
		
		for(int i=0;i<5;i++)// 設定List選取項目
			list.add("List "+i);
		
		list.setMultipleMode(false);// 設定是否允許項目被多重選擇
		list.select(3);// 選取選項項目
		
		java.awt.Panel panel1=new Panel();
		panel1.add(list);
		add(panel1);
		
		list=new List(6);
		// 註冊 ItemListener
		list.addItemListener(this);
		
		for (int i=0;i<10;i++)
			list.add("List "+i);
		
		list.setMultipleMode(true);
		list.select(2);
		list.select(4);
		list.select(6);
		
		java.awt.Panel panel2=new Panel();
		panel2.add(list);
		add(panel2);
		
		label = new Label();
		// Demo Only
		label.setText("Total items: " + list.getItemCount() + ",    Init Selected Index: " + list.getSelectedIndex());
		add(label);
		// 設定視窗的大小
		this.setSize(500, 300);

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
	List li = (List)(e.getItemSelectable());
	String choose="";
	if(li.isMultipleMode()){
		String[] listchoose=li.getSelectedItems();
		for(int i=0;i<listchoose.length;i++)
			choose=choose+listchoose[i];
		label.setText("Total items: " + li.getItemCount()  + ",    Selected Item: " + choose);
	}
	else{
		label.setText("Total items: " + li.getItemCount()  + ",    Selected Item: " + li.getSelectedItem());//注意單選是getSelectedItem和上面複選有差
	}
  }
}