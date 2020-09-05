package org.buptdavid.datastructure.zj.design_mode.Filter;

import java.util.List;

/**
 * @author jiezhou
 * @InterfaceName: Criteria
 * @Package org.buptdavid.datastructure.zj.design_mode.Filter
 * @Description: 为标准（Criteria）创建一个接口
 * @date 2020/4/21/15:58
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
