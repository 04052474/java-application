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
	label1=new Label();//第一個label
	label1.setText("");
	gb.setConstraints(label1,gc);
	add(label1);
	
	gc.gridx=1;
	gc.gridy=1;
	label2=new Label("地區");//第二個label
	label2.addMouseListener(this);
	label2.addMouseMotionListener(this);
	gc.gridwidth=1;
	gb.setConstraints(label2,gc);
	add(label2);
	
	String[] items = {"基隆市", "台北市", "新北市", "桃園縣","新竹市"
					,"新竹縣","苗栗縣","台中市","彰化縣","南投縣"
					,"雲林縣","嘉義市","嘉義縣","台南市","高雄市"
					,"屏東縣","台東縣","花蓮縣","宜蘭縣","澎湖縣","金門縣","連江縣"};
	choice = new Choice();
    // 註冊 ItemListener
    choice.addItemListener(this);
	choice.addMouseListener(this);
    // 設定Choice選取項目（Item），項目index自0開始。
    for (int i=0; i < items.length; i++)    
      choice.add(items[i]);
	gc.gridx=3;
	gc.gridwidth=GridBagConstraints.REMAINDER;
	gb.setConstraints(choice,gc);
	add(choice);
	
	gc.gridx=1;
	gc.gridy=2;
	gc.gridwidth=1;
	label3=new Label("性別");//第三個label
	label3.addMouseListener(this);
	gb.setConstraints(label3,gc);
	add(label3);
	
	group = new CheckboxGroup() ;
	
	gc.gridx=3;
	gc.gridy=2;
	checkbox[0]=new Checkbox();
	checkbox[0].setLabel("男");
	checkbox[0].setCheckboxGroup(group);
	gb.setConstraints(checkbox[0],gc);
	checkbox[0].addItemListener(this);
	checkbox[0].addMouseListener(this);
	add(checkbox[0]);
	
	gc.gridx=4;
	gc.gridy=2;
	checkbox[1]=new Checkbox();
	checkbox[1].setLabel("女");
	checkbox[1].setCheckboxGroup(group);
	gb.setConstraints(checkbox[1],gc);
	checkbox[1].addItemListener(this);
	checkbox[1].addMouseListener(this);
	add(checkbox[1]);
	
	gc.gridx=1;
	gc.gridy=3;
	gc.gridwidth=4;
	button.setLabel("產生");
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

    // 顯示視窗
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
		label1.setText("請選擇地區...");
		if(e.getSource().equals(choice))
		label1.setText("請選擇地區...");
		if(e.getSource().equals(label3))
		label1.setText("請選擇性別...");
		if(e.getSource().equals(checkbox[0]))
		label1.setText("請選擇性別...");
		if(e.getSource().equals(checkbox[1]))
		label1.setText("請選擇性別...");
		if(e.getSource().equals(button))
		label1.setText("選好後再按產生!!!");
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
    // 取得產生項目事件的物件
	
	String want = (String) e.getItem();//這一行參考的網站https://pydoing.blogspot.com/2012/07/java-api-itemlistener.html
	if(e.getSource().equals(choice))
	want1=want;
	if(e.getSource().equals(checkbox[0]) || e.getSource().equals(checkbox[1]))
	sex=want;

  }
	public void actionPerformed(ActionEvent e){
			String checkHead = "ABCDEFGHJKLMNPQRSTUVWXYZIO";
			String v[][] = {{"A", "台北市"}, {"B", "台中市"}, {"C", "基隆市"},
         {"D", "台南市"}, {"E", "高雄市"}, {"F", "台北縣"}, {"G", "宜蘭縣"},
         {"H", "桃園縣"}, {"J", "新竹縣"}, {"K", "苗栗縣"}, {"L", "台中縣"},
         {"M", "南投縣"}, {"N", "彰化縣"}, {"P", "雲林縣"}, {"Q", "嘉義縣"},
         {"R", "台南縣"}, {"S", "高雄縣"}, {"T", "屏東縣"}, {"U", "花蓮縣"},
         {"V", "台東縣"}, {"X", "澎湖縣"}, {"Y", "陽明山"}, {"W", "金門縣"},
         {"Z", "連江縣"}, {"I", "嘉義市"}, {"O", "新竹市"}
      };
			
			String code="";
			Random r = new Random();
			String s = "";
			int checknum = 0;	// 產生前9碼的同時計算產生驗證碼
			
			// 產生第一個英文字母
			
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

			// 產生第2個數字 (1~2)
			if(sex=="男")
			{
				s += Integer.toString(t = 1);
				checknum += t*8;
			}
			if(sex=="女")
			{
				s += Integer.toString(t = 2);
				checknum += t*8;
			}
			// 產生後8碼
			for (int i=2; i<9; i++){
				s += Integer.toString(t = r.nextInt(10));
				checknum += t*(9-i);
			}
			// 完成驗證碼計算
			checknum = (10-((checknum)%10))%10;
			s+=Integer.toString(checknum);
			System.out.println(s);
			label4.setText(s);
	}
}