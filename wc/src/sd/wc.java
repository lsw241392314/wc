package sd;

import java.io.*;
/**   * 统计文本文件的行数，单词书，字符数  */ 
class wc {
	public static int words = 1;
	public static int lines = 1;     
	public static int chars = 0;        
	public static void wc(InputStream f) throws IOException {
		int c = 0;          
		boolean lastNotWhite = false;         
		String whiteSpace = " \t\n\r";         
		while ((c = f.read()) != -1) {             
			chars++;              
			if (c == '\n') {
				lines++;
				}              
			if (whiteSpace.indexOf(c) != -1) {
				if (lastNotWhite) {
					words++;
					}
				lastNotWhite = false;
				} 
			else 
				{
					lastNotWhite = true;
				}         
			}     
		}       
	public static void main(String args[]) { 
		 FileInputStream f;
		 try {
			 if (args.length == 0) {
				 // 检查是否读入
				 f = new FileInputStream("C:\\Users\\Administrator\\Desktop\\14.txt");
				 wc(f);
				 } else {
					 // 判断行
					 for (int i = 0; i < args.length; i++) {
						 f = new FileInputStream(args[i]); 
						 wc(f);
						 }
					 }
			 } catch (IOException e) {
				 return;
				 }
		 System.out.println(lines + "行 " + words + "个单词 " + chars + "个字符");
		 }
}