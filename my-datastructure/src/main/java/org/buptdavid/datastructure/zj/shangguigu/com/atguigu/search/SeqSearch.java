package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.search;

/**
 * @author jiezhou
 * @CalssName: SeqSearch
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.search
 * @Description: 线性查找
 * @date 2020/8/19/9:32
 */
public class SeqSearch implements ISearch{


    @Override
    public int search(int[] arr,int value) {
        for (int i = 0; i < arr.length; i++) {
            if(value==arr[i]){
                return i;
            }
        }
        return -1;
    }
}
