package org.buptdavid.datastructure.zj;

import org.apache.lucene.search.similarities.DFRSimilarity;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author jiezhou
 * @CalssName: TimeTest
 * @Package org.buptdavid.datastructure.zj
 * @Description:
 * @date 2021/12/2/0:49
 */
public class TimeTest {

    public static void main(String[] args) {
        getWeekStartDate();
    }

    /**
     * 获取下周一
     * @return
     */
    public static Date getWeekStartDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal1 = Calendar.getInstance();
        int dayofweek = cal1.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("当前周几 = " + dayofweek);
        if (dayofweek >= 1) {
            long l = date.getTime() + 604800 * 1000L;
            date = new Date(l);
        }
        System.out.println("下周一  = " + format0.format(date));
        return date;
    }
}
