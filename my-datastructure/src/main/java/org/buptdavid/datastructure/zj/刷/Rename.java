/*
package org.buptdavid.datastructure.zj.刷;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
 
import javax.crypto.spec.IvParameterSpec;
 
public class Rename {
 
	*/
/**
	 * @param args
	 * @throws IOException
	 *//*

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("hello\n");
		File file = new File("D:\\pdf");//pdf文件夹
		String xpdfPath = "D:\\TDDOWNLOAD\\xpdfbin-win-3.03\\bin32\\pdfinfo.exe ";
		//pdfinfo.exe文件夹，注意这个exe和后面的pdf文件名有空格，所以这里有空格
		File[] fileListFiles = file.listFiles();// 取出文件夹下所有的文件
		for (int i = 0; i < fileListFiles.length; i++) {
			String cmd = xpdfPath + fileListFiles[i].getAbsolutePath();
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						process.getInputStream()));//获得exe执行程序返回结果
				String firstLine = br.readLine();//只需要读取第一行就行，只要标题
				// System.out.println(firstLine);
				// System.out.println(firstLine.indexOf('D')); //下面substring的时候为什么是16，是通过这个实验出来的
				if (firstLine != null) {
					String subTitle = firstLine.substring(16);
					if (!subTitle.equals("")) {
						subTitle = subTitle.replace(':', ' ');// 去掉文件名不合规范的
						subTitle = subTitle.replace('*', ' ');
						subTitle = subTitle.replace('/', ' ');
						subTitle = subTitle.replace('?', ' ');
						String title = subTitle + ".pdf";//加上后缀名
						File newFile;
						if (title != "untitled.pdf" && title != ".pdf") {
							newFile = new File("D:/pdf/" + title);
							// System.out.println(title);
							if (fileListFiles[i].renameTo(newFile)) {//修改文件名
								System.out.println(fileListFiles[i].getName()
										+ "修改成功");
							} else {
								System.out.println(fileListFiles[i].getName()
										+ "修改失败");
							}
						}
						br.close();//别忘了关闭流
						process.destroy();
					}else {
						System.out.println(fileListFiles[i].getName()
								+ "因为文中没有文件title而修改失败");
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}*/
