package org.buptdavid.datastructure.zj;


import okhttp3.*;

import java.io.IOException;

/**
 * @author jiezhou
 * @CalssName: okHttpUtils
 * @Package demo.controller
 * @Description:
 * @date 2020/5/28/10:21
 */
public class OkHttpUtils {

    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "http://localhost:8080/sayHello1.action?name=zhoujie";
        Request request = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            /*失败处理*/
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            /*成功处理*/
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                System.out.println(string);
                System.exit(0);
            }
        });
    }
}
