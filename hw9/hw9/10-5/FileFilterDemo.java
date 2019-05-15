import java.io.*;

public class FileFilterDemo {
  public static void main(String args[]){
    
    // 目前目錄
    File file = new File(".");

    // 定義篩選條件: 副檔名為java
    Filter filter = new Filter("java");

    // 只列出副檔名為java之檔案名稱
    String filename[] = file.list(filter);

    for (int i=0; i<filename.length; i++) { 
      System.out.println(filename[i]); 
    }
  }
}
