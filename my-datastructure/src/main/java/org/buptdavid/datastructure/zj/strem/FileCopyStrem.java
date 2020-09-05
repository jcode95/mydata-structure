package org.buptdavid.datastructure.zj.strem;

import java.io.*;

/**
 * @author jiezhou
 * @CalssName: FileCopyStrem
 * @Package org.buptdavid.datastructure.zj.strem
 * @Description: 文件复制
 * @date 2020/7/6/15:06
 */
public class FileCopyStrem {

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\in.txt");
        new FileCopyStrem().copyFile(file);

    }


    public void copyFile(File inFile) throws IOException {

        if(inFile==null){
            return;
        }
        if(inFile.isDirectory()){
            File[] files = inFile.listFiles();
            for (File file : files) {
                copyFile(file);
            }

        }else {
            FileInputStream fileInputStream=null;
            FileOutputStream fileOutputStream=null;
            try {
                fileInputStream= new FileInputStream(inFile);
                fileOutputStream= new FileOutputStream(new File("F:\\copy.txt" ));
                byte[] bytes=new byte[1024];
                int len;
                while ((len=fileInputStream.read(bytes))>0){
                    fileOutputStream.write(bytes,0,len);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                fileInputStream.close();
                fileOutputStream.close();
            }
        }



    }
}
