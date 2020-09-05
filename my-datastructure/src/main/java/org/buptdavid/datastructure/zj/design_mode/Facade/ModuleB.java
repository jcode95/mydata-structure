package org.buptdavid.datastructure.zj.design_mode.Facade;

public class ModuleB {
    /**
     * 提供给子系统外部使用的方法
     */
    public void b1() {
        System.out.println("b1.............");
    }



    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    private void b2() {
    }



    private void b3() {
    }


}