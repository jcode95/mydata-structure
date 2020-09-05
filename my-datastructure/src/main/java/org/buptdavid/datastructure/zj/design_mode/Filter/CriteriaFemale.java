package org.buptdavid.datastructure.zj.design_mode.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: CriteriaFemale
 * @Package org.buptdavid.datastructure.zj.design_mode.Filter
 * @Description: 创建实现了 Criteria 接口的实体类。
 * @date 2020/4/21/16:00
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
