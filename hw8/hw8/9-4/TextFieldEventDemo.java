import java.awt.*;
import java.awt.event.*;

public class TextFieldEventDemo extends java.awt.Frame implements FocusListener {

  public static void main(String args[]){
    new TextFieldEventDemo();
  }
  
  // 建構函式
  public TextFieldEventDemo() {
    super("TextField Event Demo");

    // 定義 Layout Manager 為 FlowLayout
    setLayout(new FlowLayout());

    TextField[] textfield = new TextField[4];

    // 建構函式 1
    textfield[0] = new TextField();
    // 設定文字欄位的顯示文字
    textfield[0].setText("TextField 1");
    // 設定文字欄位的顯示文字字數
    textfield[0].setColumns(6);
    // 設定背景顏色
    textfield[0].setBackground(Color.PINK);
    // 設定前景顏色
    textfield[0].setForeground(Color.CYAN);
    // 選取所有的文字內容
    textfield[0].selectAll();
    // 註冊 FocusListener
    textfield[0].addFocusListener(this);
    add(textfield[0]);

    // 建構函式 2
    textfield[1] = new TextField("TextField 2");
    // 設定回應字元
    textfield[1].setEchoChar('*');
    // 註冊 FocusListener
    textfield[1].addFocusListener(this);
    add(textfield[1]);

    // 建構函式 3
    textfield[2] = new TextField(8);
    // 設定文字欄位的顯示文字
    textfield[2].setText("TextField 3");
    // 設定是否允許編輯
    textfield[2].setEditable(false);
    // 註冊 FocusListener
    textfield[2].addFocusListener(this);
    add(textfield[2]);

    // 建構函式 4
    textfield[3] = new TextField("TextField 4", 8);
    // 選取由selectionStart啟始位置
    // 至selectionEnd結束位置的文字內容
    textfield[3].select(3, 8);
    // 註冊 FocusListener
    textfield[3].addFocusListener(this);
    add(textfield[3]);

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

  // 取得輸入焦點時
  public void focusGained(FocusEvent e) {
    Component com = e.getComponent();

    if (com instanceof TextField) {
      TextField textfield = (TextField) com;

      //選取所有的文字內容
      textfield.selectAll();
    } 
  }

  // 失去輸入焦點時
  public void focusLost(FocusEvent e) {} 
}
