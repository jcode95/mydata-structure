package org.buptdavid.datastructure.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author jiezhou
 * @CalssName: CloneTest1
 * @Package org.buptdavid.datastructure.clone
 * @Description:
 * @date 2020/6/23/17:19
 */
public class CloneTest1 {

    public static <T extends Object>  T clones(T sreObject){
        T cloneObject=null;
        //输出流
        ByteArrayOutputStream out=null;
        ObjectOutputStream oo=null;
        ByteArrayInputStream in=null;
        ObjectInputStream oi=null;
        try {
            out=new ByteArrayOutputStream();
            oo=new ObjectOutputStream(out);
            oo.writeObject(sreObject);
            in=new ByteArrayInputStream(out.toByteArray());
            oi=new ObjectInputStream(in);
            cloneObject = (T)oi.readObject();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                oi.close();
                in.close();
                oo.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cloneObject;
    }
}
