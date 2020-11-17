package org.buptdavid.datastructure.zj.thread.test;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

public class JdbcTemplateTest {


    @Resource(name = "jdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    //  <T> List<T> query(String var1, Object[] var2, RowMapper<T> var3) throws DataAccessException;
//    public void  queryForList(String key,Object... ids) {
//         jdbcTemplate.query(sqlManager.getSqlTemplate(getStatementId(key)), ids, new BeanPropertyRowMapper<T>(getEntityClass()));
//    }

}