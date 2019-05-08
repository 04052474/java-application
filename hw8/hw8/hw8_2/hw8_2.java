import java.awt.*;
import java.awt.event.*;

public class hw8_2 extends java.awt.Frame {  

  java.awt.TextField textfield;

  public static void main(String args[]){
    new hw8_2();
  }
  
  // 建構函式
  public hw8_2() {
    super("hw8_2 TextField Event Demo");

    // 定義 Layout Manager 為 FlowLayout
    setLayout(new FlowLayout());

    // 建構函式 1
    textfield = new TextField();
    // 設定文字欄位的顯示文字
    textfield.setText("TextField 1");
    // 設定文字欄位的顯示文字字數
    textfield.setColumns(10);
    // 設定背景顏色
    textfield.setBackground(Color.PINK);
    // 設定前景顏色
    textfield.setForeground(Color.CYAN);
    // 選取所有的文字內容
    textfield.selectAll();
    
    // 以Inner Class的方式使用TextListener介面
    textfield.addTextListener(new TextListener() {
      public void textValueChanged(TextEvent e) {
        if (e.getID() == TextEvent.TEXT_VALUE_CHANGED)
          System.out.println("文字欄位內容改變");
      }
    });
	
	textfield.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(textfield))
				System.out.println("於文字欄位上按下Enter鍵");
		}
	});
	
	textfield.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e){
			int i=e.getKeyCode();
			
			System.out.println("Key Pressed: "+i);
		}
		public void keyReleased(KeyEvent e){
			System.out.println("Char: "+e.getKeyChar());
		}
		public void keyTyped(KeyEvent e){}
	});
	
	textfield.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
		  System.out.println("按下並釋放滑鼠按鍵" + e.getX() + ", y: " + e.getY());
	  }
	  public void mouseEntered(MouseEvent e){
		  System.out.println("滑鼠移至物件上方"+ e.getX() + ", y: " + e.getY());
	  }
	  public void mouseExited(MouseEvent e){
		  System.out.println("滑鼠離開物件"+ e.getX() + ", y: " + e.getY());
	  }
	  public void mousePressed(MouseEvent e){
		  System.out.println("按下滑鼠按鍵"+ e.getX() + ", y: " + e.getY());

	  }
	  public void mouseReleased(MouseEvent e){
		  System.out.println("釋放滑鼠按鍵"+ e.getX() + ", y: " + e.getY());
	  }
	});
	
	textfield.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e){
		  System.out.println("按下滑鼠按鍵並拖曳滑鼠 "+"x: " + e.getX() + ", y: " + e.getY());
	  }
	  public void mouseMoved(MouseEvent e){
		  System.out.println("在物件上方移動滑鼠 "+"x: " + e.getX() + ", y: " + e.getY());
	  }
	});
    add(textfield);

    // 設定視窗的大小
    this.setSize(200, 100);

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
}
