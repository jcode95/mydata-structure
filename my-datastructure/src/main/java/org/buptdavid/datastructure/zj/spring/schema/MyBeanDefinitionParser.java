package org.buptdavid.datastructure.zj.spring.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author jiezhou
 * @CalssName: MyBeanDefinitionParser
 * @Package org.buptdavid.datastructure.zj.spring.schema
 * @Description: 自定义spring文件的bean解析器
 * @date 2021/2/10/18:07
 */
public class MyBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String name = element.getAttribute("name");
        String age = element.getAttribute("age");
        String id = element.getAttribute("id");
        if(StringUtils.hasText(name)){
            bean.addPropertyValue("name",name);
        }
        if(StringUtils.hasText(name)){
            bean.addPropertyValue("age",Integer.parseInt(age));
        }
        if(StringUtils.hasText(name)){
            bean.addPropertyValue("id",id);
        }
    }
}
