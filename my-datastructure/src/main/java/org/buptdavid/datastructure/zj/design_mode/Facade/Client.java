package org.buptdavid.datastructure.zj.design_mode.Facade;

/**
 *门面模式
 * @author jiezhou
 * @CalssName: Client
 * @Package org.buptdavid.datastructure.zj.design_mode.Facade
 * @Description: 客户端角色类：
 * @date 2020/7/21/15:04
 */
public class Client {

    public static void main(String[] args) {
        ModuleFacade facade = new ModuleFacade();
        facade.b1();


    }

}
