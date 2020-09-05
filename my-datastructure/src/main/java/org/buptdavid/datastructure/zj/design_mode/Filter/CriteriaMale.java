package org.buptdavid.datastructure.zj.design_mode.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: CriteriaMale
 * @Package org.buptdavid.datastructure.zj.design_mode.Filter
 * @Description: 创建实现了 Criteria 接口的实体类。
 * @date 2020/4/21/15:59
 */
public class CriteriaMale implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("MALE")){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
