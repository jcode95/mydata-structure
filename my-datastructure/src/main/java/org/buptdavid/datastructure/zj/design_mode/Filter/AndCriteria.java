package org.buptdavid.datastructure.zj.design_mode.Filter;

import java.util.List;

/**
 * @author jiezhou
 * @CalssName: AndCriteria
 * @Package org.buptdavid.datastructure.zj.design_mode.Filter
 * @Description: 创建实现了 Criteria 接口的实体类。
 * @date 2020/4/21/16:02
 */
public class AndCriteria implements Criteria{
    private Criteria criteria;
    private Criteria otherCriteria;
    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
