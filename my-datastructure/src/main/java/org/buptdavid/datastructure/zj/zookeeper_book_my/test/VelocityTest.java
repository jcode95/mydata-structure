package org.buptdavid.datastructure.zj.zookeeper_book_my.test;


import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;

/**
 * Velocity 模板引擎快速生成代码
 */
public class VelocityTest {

    public static void main(String[] args) throws IOException {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER,"classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        //init
        velocityEngine.init();

        //导入模板
        Template template = velocityEngine.getTemplate("domain.java.vm");
        VelocityContext context = new VelocityContext();
        context.put("package","book.test.velocity");
        context.put("className","VelocityGenerate");
        context.put("auth","private");
        context.put("type","String");
        context.put("name","name");
        context.put("Name","Name");
        StringWriter stringWriter = new StringWriter();
        template.merge(context,stringWriter);
        String string = stringWriter.toString();
        System.out.println(string);
        File file = new File("F:\\ideawork\\zookeeper_paxos\\zookeeper_book\\src\\main\\java\\book\\test\\velocity\\VelocityGenerate.java");
        boolean newFile = file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(string.getBytes(Charset.defaultCharset()));
        fileOutputStream.flush();
        fileOutputStream.close();

        Long l=new Long(1);
        int sss=Integer.parseInt(l+"");

    }


}
