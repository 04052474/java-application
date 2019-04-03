import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ID_UI extends java.awt.Frame implements
	MouseListener,
	MouseMotionListener,
	ItemListener,
	ActionListener
	{
		
	java.awt.Label label1,label2,label3,label4;
	java.awt.Choice choice;
	Checkbox[] checkbox = new Checkbox[2];
	java.awt.CheckboxGroup group;
	Button button=new Button();
	String want1="";
	String sex="";
	public static void main(String args[]){
		new ID_UI();
	}
	
	public ID_UI(){
	super("hw5_3 ID_UI");
	
	
	
	GridBagLayout gb=new GridBagLayout();
	GridBagConstraints gc=new GridBagConstraints();
	
	setLayout(gb);
	gc.anchor=GridBagConstraints.CENTER;
	gc.fill=GridBagConstraints.HORIZONTAL;
	
	
	gc.gridwidth=GridBagConstraints.REMAINDER;
	label1=new Label();//�Ĥ@��label
	label1.setText("");
	gb.setConstraints(label1,gc);
	add(label1);
	
	gc.gridx=1;
	gc.gridy=1;
	label2=new Label("�a��");//�ĤG��label
	label2.addMouseListener(this);
	label2.addMouseMotionListener(this);
	gc.gridwidth=1;
	gb.setConstraints(label2,gc);
	add(label2);
	
	String[] items = {"�򶩥�", "�x�_��", "�s�_��", "��鿤","�s�˥�"
					,"�s�˿�","�]�߿�","�x����","���ƿ�","�n�뿤"
					,"���L��","�Ÿq��","�Ÿq��","�x�n��","������"
					,"�̪F��","�x�F��","�Ὤ��","�y����","���","������","�s����"};
	choice = new Choice();
    // ���U ItemListener
    choice.addItemListener(this);
	choice.addMouseListener(this);
    // �]�wChoice������ء]Item�^�A����index��0�}�l�C
    for (int i=0; i < items.length; i++)    
      choice.add(items[i]);
	gc.gridx=3;
	gc.gridwidth=GridBagConstraints.REMAINDER;
	gb.setConstraints(choice,gc);
	add(choice);
	
	gc.gridx=1;
	gc.gridy=2;
	gc.gridwidth=1;
	label3=new Label("�ʧO");//�ĤT��label
	label3.addMouseListener(this);
	gb.setConstraints(label3,gc);
	add(label3);
	
	group = new CheckboxGroup() ;
	
	gc.gridx=3;
	gc.gridy=2;
	checkbox[0]=new Checkbox();
	checkbox[0].setLabel("�k");
	checkbox[0].setCheckboxGroup(group);
	gb.setConstraints(checkbox[0],gc);
	checkbox[0].addItemListener(this);
	checkbox[0].addMouseListener(this);
	add(checkbox[0]);
	
	gc.gridx=4;
	gc.gridy=2;
	checkbox[1]=new Checkbox();
	checkbox[1].setLabel("�k");
	checkbox[1].setCheckboxGroup(group);
	gb.setConstraints(checkbox[1],gc);
	checkbox[1].addItemListener(this);
	checkbox[1].addMouseListener(this);
	add(checkbox[1]);
	
	gc.gridx=1;
	gc.gridy=3;
	gc.gridwidth=4;
	button.setLabel("����");
	gb.setConstraints(button,gc);
	button.addMouseListener(this);
	button.addActionListener(this);
	add(button);
	
	gc.gridx=1;
	gc.gridy=4;
	gc.gridwidth=4;
	label4=new Label("");
	gb.setConstraints(label4,gc);
	add(label4);
	
    this.setSize(400, 400);
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
	//mouselistener
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){
		if(e.getSource().equals(label2))
		label1.setText("�п�ܦa��...");
		if(e.getSource().equals(choice))
		label1.setText("�п�ܦa��...");
		if(e.getSource().equals(label3))
		label1.setText("�п�ܩʧO...");
		if(e.getSource().equals(checkbox[0]))
		label1.setText("�п�ܩʧO...");
		if(e.getSource().equals(checkbox[1]))
		label1.setText("�п�ܩʧO...");
		if(e.getSource().equals(button))
		label1.setText("��n��A������!!!");
	}
	public void mouseExited(MouseEvent e){
		label1.setText("");
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	//mousemotion
	public void mouseDragged(MouseEvent e){
		
	}
	public void mouseMoved(MouseEvent e){

	}
	public void itemStateChanged(ItemEvent e) {
    // ���o���Ͷ��بƥ󪺪���
	
	String want = (String) e.getItem();//�o�@��ѦҪ�����https://pydoing.blogspot.com/2012/07/java-api-itemlistener.html
	if(e.getSource().equals(choice))
	want1=want;
	if(e.getSource().equals(checkbox[0]) || e.getSource().equals(checkbox[1]))
	sex=want;

  }
	public void actionPerformed(ActionEvent e){
			String checkHead = "ABCDEFGHJKLMNPQRSTUVWXYZIO";
			String v[][] = {{"A", "�x�_��"}, {"B", "�x����"}, {"C", "�򶩥�"},
         {"D", "�x�n��"}, {"E", "������"}, {"F", "�x�_��"}, {"G", "�y����"},
         {"H", "��鿤"}, {"J", "�s�˿�"}, {"K", "�]�߿�"}, {"L", "�x����"},
         {"M", "�n�뿤"}, {"N", "���ƿ�"}, {"P", "���L��"}, {"Q", "�Ÿq��"},
         {"R", "�x�n��"}, {"S", "������"}, {"T", "�̪F��"}, {"U", "�Ὤ��"},
         {"V", "�x�F��"}, {"X", "���"}, {"Y", "�����s"}, {"W", "������"},
         {"Z", "�s����"}, {"I", "�Ÿq��"}, {"O", "�s�˥�"}
      };
			
			String code="";
			Random r = new Random();
			String s = "";
			int checknum = 0;	// ���ͫe9�X���P�ɭp�ⲣ�����ҽX
			
			// ���ͲĤ@�ӭ^��r��
			
			for(int x=0;x<v.length;x++)
			{	
				for(int y=0;y<2;y++){
					if (want1==v[x][y])
						code=v[x][y-1];
				}
			}
			int t;
			s+=code;
			t=checkHead.indexOf(code)+10;
			checknum += t/10;
			checknum += t%10*9;

			// ���Ͳ�2�ӼƦr (1~2)
			if(sex=="�k")
			{
				s += Integer.toString(t = 1);
				checknum += t*8;
			}
			if(sex=="�k")
			{
				s += Integer.toString(t = 2);
				checknum += t*8;
			}
			// ���ͫ�8�X
			for (int i=2; i<9; i++){
				s += Integer.toString(t = r.nextInt(10));
				checknum += t*(9-i);
			}
			// �������ҽX�p��
			checknum = (10-((checknum)%10))%10;
			s+=Integer.toString(checknum);
			System.out.println(s);
			label4.setText(s);
	}
}