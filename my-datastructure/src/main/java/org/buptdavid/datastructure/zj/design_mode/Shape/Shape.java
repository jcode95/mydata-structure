package org.buptdavid.datastructure.zj.design_mode.Shape;

/**
 * @author jiezhou
 * @CalssName: Shape
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape
 * @Description: 原形设计模式
 * @date 2020/4/21/14:09
 */
public abstract class Shape implements Cloneable{
    private String id;
    protected String type;
    abstract void draw();//画

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone=null;
        try {
            clone= super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}
