import java.awt.*;
import java.awt.event.*;

public class hw7_2 extends java.awt.Frame implements AdjustmentListener {

  Scrollbar scrollbar[] = new Scrollbar[3] ;
  Panel colorPanel = new Panel();
  Label label = new Label();
  Panel panelforco0=new Panel();
  Panel panelforco1=new Panel();
  Panel panelforco2=new Panel();	
  int red = 0;
  int green = 0;
  int blue = 0;

  public static void main(String args[]){
    new hw7_2();
  }
  
  // 建構函式
  public hw7_2() {
    super("hw7_2 Scrollbar Event Demo");

    // 定義 Layout Manager 為 BorderLayout
    setLayout(new BorderLayout());

    Panel panel = new Panel();
    panel.setLayout(new GridLayout(3, 1));

    for (int i=0; i < 3; i++) {
      // 設定配置方向為水平捲軸
      //     目前值為0, 捲軸方塊大小值為0
      //     最小值為0, 最大值為256
      scrollbar[i] = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 256);

      // 註冊 AdjustmentListener
      scrollbar[i].addAdjustmentListener(this);

      panel.add(scrollbar[i]);
    }

    label.setText("Red: " + red + ", Green: " + green + ", Blue: " + blue);
	
	colorPanel.setLayout(new GridLayout(3,1));
	
	
	panelforco0.setBackground(new Color(255, 0, 0));
	panelforco1.setBackground(new Color(0, 255,0));
	panelforco2.setBackground(new Color(0, 0, 255));
	colorPanel.add(panelforco0);
	colorPanel.add(panelforco1);
	colorPanel.add(panelforco2);

    this.add(panel,      BorderLayout.NORTH);
    this.add(colorPanel, BorderLayout.CENTER);
    this.add(label,      BorderLayout.SOUTH);


    // 設定視窗的大小
    this.setSize(220, 220);

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

  public void adjustmentValueChanged(AdjustmentEvent e) {
    // 取得產生調校事件之物件 
    Scrollbar sb = (Scrollbar)(e.getAdjustable());

    // 取得產生調校事件時捲軸之目前值
    if (sb == scrollbar[0])
	{
		red = sb.getValue();
		panelforco0.setBackground(new Color(red, 0, 0));
	}
    else if (sb == scrollbar[1])
	{
      green = sb.getValue();
	  panelforco1.setBackground(new Color(0, green, 0));
	}
    else if (sb == scrollbar[2])
	{
		blue = sb.getValue();
		panelforco2.setBackground(new Color(0, 0, blue));
	}
    label.setText("Red: " + red + ", Green: " + green + ", Blue: " + blue);
    
    
    // 回傳產生調校事件時之類型
    int type = e.getAdjustmentType();
    
    switch (type) {
      case AdjustmentEvent.BLOCK_DECREMENT:
        System.out.println("BLOCK_DECREMENT");
        break;
      case AdjustmentEvent.BLOCK_INCREMENT:
        System.out.println("BLOCK_INCREMENT");
        break;
      case AdjustmentEvent.UNIT_DECREMENT:
        System.out.println("UNIT_DECREMENT");
        break;
      case AdjustmentEvent.UNIT_INCREMENT:
        System.out.println("UNIT_INCREMENT");
        break;
      case AdjustmentEvent.TRACK:
        System.out.println("TRACK");
        break;
      default:
        break;
    }
    
    if (e.getValueIsAdjusting())
      System.out.println("捲軸方塊仍被拖曳中");
  }
}
