package org.buptdavid.datastructure.zj;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: Main2
 * @Package org.buptdavid.datastructure.zj
 * @Description:
 * @date 2021/1/3/23:07
 */
public class Main2 {

    public static void main(String[] args) throws ParseException {
//        String cdtime = "60";
//        String carNum = "1";
//        double speed = Double.parseDouble(carNum) / ( Double.parseDouble(cdtime) * 1000d);
//        System.out.println(speed);
        List<String> params = new ArrayList<>();
        params.add("34fe345");
        params.add("34frer345");
        params.add("3243");
        JSONArray js = new JSONArray();
        for (String param : params) {
            js.add(param);
        }
        String text = js.toJSONString();
        JSONArray jsonArray = JSONArray.parseArray(text);
//        List<String> strings = JSONObject.parseArray("[344gdf5]", String.class);
//        System.out.println("strings = " + strings);
        System.out.println("jsonArray = " + jsonArray);

        Date date = new Date();
        String s="2022-09-22 11:53:50";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse(s);
        System.out.println("parse.getTime() = " + parse.getTime()/1000);
        System.out.println("date = " + date.getTime()/1000);


        ArrayList<String> ls = new ArrayList<>();
        ls.add(123423+"");
        ls.add("JHsdf?dfs");
        JSONArray base = new JSONArray();
        base.add(ls.get(0));
        base.add(ls.get(1));

        String s1 = base.toJSONString();
        System.out.println("s1 = " + s1);

    }
}
