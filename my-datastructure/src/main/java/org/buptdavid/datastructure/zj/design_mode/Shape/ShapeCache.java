package org.buptdavid.datastructure.zj.design_mode.Shape;

import javax.annotation.PostConstruct;
import java.util.Hashtable;

/**
 * @author jiezhou
 * @CalssName: ShapeCache
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape
 * @Description: 创建一个类，从数据库获取实体类，并把它们存储在一个 Hashtable 中。
 * @date 2020/4/21/14:17
 */
public class ShapeCache {

    private  static Hashtable<String,Shape> shapeMap=  new Hashtable<String,Shape>();

    public static Shape getShape(String shapeId) {
        try {
            Shape shape = shapeMap.get(shapeId);
            return (Shape) shape.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    @PostConstruct
    public static void loadCache() {
        //圆
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);
        //正方形
        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);
        //长方形
        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
