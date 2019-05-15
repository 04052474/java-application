import java.io.*;

// 實作FilenameFilter介面
public class Filter implements java.io.FilenameFilter {
  private String extension = null;

  // 建構函式
  public Filter(String extension) {  
    this.extension = "." + extension; 
  }
  
  // 實作FilenameFilter介面之方法
  public boolean accept(File dir, String name){ 
    return name.endsWith(extension); 
  }
}
