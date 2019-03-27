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
		
		
    // �غc�禡 1
    checkbox[0] = new Checkbox();
    // �]�wCheckbox���O����r����
    checkbox[0].setLabel("Checkbox 0");
    // �]�wCheckbox���O��������A
    checkbox[0].setState(true);
    panel1.add(checkbox[0]);
	
	// �غc�禡 2
    checkbox[1] = new Checkbox("Checkbox 1");
    // �]�wCheckbox���O��������A
    checkbox[1].setState(false);
    panel1.add(checkbox[1]);
	
	 // �غc�禡 3
    checkbox[2] = new Checkbox("Checkbox 2", true);
    panel1.add(checkbox[2]);
	
	add(panel1);
	
	
	java.awt.Panel panel2=new Panel();
	
	// �غc�s��
    java.awt.CheckboxGroup group = new CheckboxGroup() ;
	// �غc�禡 1
    checkbox[3] = new Checkbox();
    // �]�wCheckbox���O����r����
    checkbox[3].setLabel("Checkbox 3");
	checkbox[3].setState(true);
    // �]�wCheckbox���O���s��
    checkbox[3].setCheckboxGroup(group);
    panel2.add(checkbox[3]);
	
	// �غc�禡 4
    checkbox[4] = new Checkbox("Checkbox 4", false, group);
    // �]�wCheckbox���O���s��
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
	// �]�w�������j�p
    this.setSize(400, 100);

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

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
	}
	
	public void itemStateChanged(ItemEvent e) {
			String source = null;
			// ���o���Ͷ��بƥ󪺪���
			Checkbox cb = (Checkbox)(e.getItemSelectable());
			
			for (int i=3; i <=5; i++) {
			  if(cb == checkbox[i]) {
				source = "Select " + checkbox[i].getLabel();

			System.out.println(source);
		  }
		}
	}
}