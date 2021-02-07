package org.buptdavid.datastructure.zj.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author jiezhou
 * @CalssName: MyNamespaceHandler
 * @Package org.buptdavid.datastructure.zj.spring.schema
 * @Description:
 * @date 2021/2/10/18:18
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport{
    @Override
    public void init() {
        registerBeanDefinitionParser("proper",new MyBeanDefinitionParser());
    }
}
