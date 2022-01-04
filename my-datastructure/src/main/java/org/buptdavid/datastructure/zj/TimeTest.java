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

    public static void main(String[] args) {
        int result=0;
        int day=1;
        long startTime = 1639620953000L;//2021-12-16 10:15:53
        if (day == -1) {
            if (startTime == 0) {
//				return 0;
                result=0;
            }
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(startTime);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTimeInMillis(System.currentTimeMillis());
            int day1 = cal1.get(Calendar.DAY_OF_YEAR);
            int day2 = cal2.get(Calendar.DAY_OF_YEAR);
//			return day2 - day1 + 1;
            result=day2 - day1 + 1;
        } else {
            if (startTime == 0) {
//				return day * 86400;
                result=day * 86400;
            }
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(startTime);
            int i = cal.get(Calendar.DAY_OF_YEAR);
            cal.set(Calendar.DAY_OF_YEAR, i + day);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            int i1 = (int) (cal.getTimeInMillis() / 1000);
//			System.out.println("i1 = " + i1);
//			return i1;
            result = i1;
        }
        System.out.println("result = " + result);

    }
}
