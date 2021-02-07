package org.buptdavid.datastructure.clone;

/**
 * @author jiezhou
 * @CalssName: CloneTest
 * @Package org.buptdavid.datastructure.clone
 * @Description:
 * @date 2020/6/23/16:53
 */
public class CloneTest {


    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(11);
        student.setName("zhangsan");
        A a = new A();
        a.setSs("ssss");
        student.setA(a);

        try {
            Student students = (Student) student.clone();
            if(students==student){
                System.out.println("深拷贝==================");
            }else{
                System.out.println("浅拷贝=================");
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        System.out.println("```````````````````````````````");
        //使用流来拷贝对象
        Student student1 = CloneTest1.clones(student);
        if(student1==student){
            System.out.println("浅拷贝==================");
        }else{
            System.out.println("深拷贝=================");
        }


    }

        /*
        浅拷贝：指向同一个地址

        深拷贝（复制一份到不同的地址）：
        * 使用实现CloneAble接口的clone，然后重写Object的clone()虽然可以达到对象的拷贝（不同地址），但是如果对象里面还有对象，那里面的对象就不能再拷贝一份了（里面对象就是同一个对象）
        * 要想使用对象里面对象也copy一份到不同的内存当中，只能使用流的形式达到深拷贝，注意的是使用流拷贝 拷贝对象必须都要实现 Serializable 接口，否则会报错
        *
        * */
}
