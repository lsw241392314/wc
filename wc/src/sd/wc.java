package sd;

import java.io.*;
/**   * ͳ���ı��ļ��������������飬�ַ���  */ 
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
				 // ����Ƿ����
				 f = new FileInputStream("C:\\Users\\Administrator\\Desktop\\14.txt");
				 wc(f);
				 } else {
					 // �ж���
					 for (int i = 0; i < args.length; i++) {
						 f = new FileInputStream(args[i]); 
						 wc(f);
						 }
					 }
			 } catch (IOException e) {
				 return;
				 }
		 System.out.println(lines + "�� " + words + "������ " + chars + "���ַ�");
		 }
}