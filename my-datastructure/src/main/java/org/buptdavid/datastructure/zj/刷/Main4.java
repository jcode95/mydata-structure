package org.buptdavid.datastructure.zj.刷;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: Main4
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description:
 * @date 2020/7/30/18:57
 */
public class Main4 {

    public static void main(String[] args) {
        String str="第1 页共 7 页\n" +
                "电子报/2013 年/2 月/17 日/第003 版\n" +
                "维修·技术\n" +
                "苹果四代智能手机供电、开机原理及不开机故障维修剖析(二)\n" +
                "广东 严萍\n" +
                "(紧接上期本版)\n" +
                "二、苹果四代智能手机开机原理及不开机故障维修剖析\n" +
                "1.手机启动开机信号方框图\n" +
                "手机3.6V 供电正常后，按下开机键启动开机，其开机稳压供电、时钟信号、复位及控制方\n" +
                "框结构如图13 所示:\n" +
                "2.手机开机工作原理\n" +
                "一是AP(多媒体)应用部分:电池BATT_VCC. (3 6V)电压给电源IC U48_PMU 供电，电源IC\n" +
                "输出1.8V_ALWAY 送到开机触发脚，当按下开机键，低电平触发电源控制各组电压给各个模块供\n" +
                "电，正常供电后，CPU 满足频率24M 作为工作时钟。电源IC 给U52 CPU 输出复位RESET 信号\n" +
                "1.8V，CPU 会在60ms 内完成复位动作，在满足供电、时钟和复位后，CPU 开始读取U1 (NAND\n" +
                "FLASH-字库)内的DFU 程序，并运行之。如果U1 有FAl 和FA2 系统，则DFU 系统会自动引导\n" +
                "运行操作系统程序，进行开机自检，完成自检后U52 CPU 输出开机维持信号给电源IC U48_PMU，\n" +
                "AP(多媒体)电源管理持续稳定的输出电压。\n" +
                "二是RF(射频)基带部分:电池BATT_VCC(3.6V)电压给RF(射频)电源IC U9_RF 供电，AP(多\n" +
                "媒体)电源IC U48 PMU 工作正常后，发送RESET 信号给RF (射频)电源IC/CPU U9_RF，同时CPU\n" +
                "发送RADIO-ON 上升沿信号给BB(基带)电源，BB(基带)电源输出各组电压给RF(射频)各IC。在\n" +
                "BB(基带)满足供电、复位和时钟信号后，BB(基带)开始读取U4_RF(射频字库:NOR FLASH)内部\n" +
                "程序，并运行之，直到开机完成，进入待机状态。\n" +
                "3.开机触发电压测试点\n" +
                "测试点为DZll，如图14 所示。若开机键无此电压，手机不能开机。故障原因:J7 变形损坏、\n" +
                "DZll 损坏、电源IC U48_PMU 虚焊或断线及主板断线，需重点排查。\n" +
                "4.U52 CPU 供电电压测试点\n" +
                "一共有以下8 组，如图15、图16、图17 所示，如果任何一组电压不正常，手机都不能开机。\n" +
                "5.字库硬盘UI 供电测试点\n" +
                "测试点在电容C17 处，如图18 所示。若没有或偏低，则不开机。\n" +
                "6.24M 主时钟信号测试点\n" +
                "24MHz 时钟的两路信号经R40、R41 输入到CPU U52 的A12 和B12 脚，正常电压是0.9V，\n" +
                "也就是说测试点在电阻R40、R41 处，如图19 所示。如果在这两个电阻处测试点的电压升高到\n" +
                "1.5V，则说明是电阻本身虚焊或CPU U52 虚焊引起不开机。\n" +
                "7.实时时钟32.768kHz 信号测试点\n" +
                "测试点在电容C82_PMU 或C83_PMU 处，如图20 所示。\n" +
                "8.复位信号RESET 1.8V 测试点\n" +
                "测试点:TP6，如图21 所示。若没有该电压或偏低，则手机不开机。\n" +
                "9.测量显示接口座J4 的显示屏输出的数据通信信号，如图22 所示。\n" +
                "检测显示接口座J4 的③脚、⑤脚、⑨脚、11 脚、⑩脚、17 脚、21 脚、23 脚(即CPU U52 对\n" +
                "显示屏输出的数据通信信号)，用示波器检测必须都有跳变的数据波形，并且幅度都一样。如果无\n" +
                "波形或波形的幅度不足，则不开机故障多数是U52 本身损坏引起；如果都有正常的波形，则多数\n" +
                "第2 页共 7 页\n" +
                "是软件出错引起的故障。\n" +
                "10.测量按键接口J1 的音量等数据信号。\n" +
                "在按键接口座J1 的⑦脚、⑨脚处测量是否有1.8V 电压，如果有，说明CPU U52 已得到供电，\n" +
                "并且其部分电路已正在工作；如果无，说明CPU 内部的各单元电路无工作，大多数是电源供电\n" +
                "电路出现了问题。\n" +
                "11.不开机故障测量分析判断法\n" +
                "如果手机加电后电流不大而不开机，其维修方法步骤如下:\n" +
                "(1)测量开机触发1.8V 电压(主要针对于按开机键无电流反应且不开机故障)。\n" +
                "如果检测此电压无或不正常，重点检查J7 是否变形损坏、DZll 损坏、电源IC U48_PMU 虚\n" +
                "焊或损坏及主板断线等。如果正常，则检查下一步的供电电路。\n" +
                "(2)测量CPU U52 和硬盘U1 的供电:如果供电不正常或无供电，重点检查U48_PMU(电源IC)\n" +
                "电路(加焊或更换)。如果供电都正常，则检查下一步的时钟电路。\n" +
                "(3)测量CPU U52 的主时钟24MHz 产生电路:在电阻R40 和R41 处测量是否为0.9V 的正常电\n" +
                "压。如果该电压升高到1.5V，则是电阻虚焊或CPU U52 虚焊所致。如果信号正常，则查32.768kHz\n" +
                "时钟电路。\n" +
                "(4)测量32.768kHz 时钟电路:如果异常或没有，则是32.768kHz 晶体或电源IC U48";
        StringBuffer sbf = new StringBuffer();
        File file = new File("");
        if (file.isDirectory()){
            File[] files = file.listFiles();


        }


        str=str.replace("\n","");



        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)+"\r\n");
        }
        String string = sb.toString();
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\zhoujie\\Desktop\\ss.txt");
            fileWriter.write(string);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(string);

    }

    /**
     * @Author：
     * @Description：获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件，所以不用递归获取
     * @Date：
     */
    public static List<String> getFiles(String path) {
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
                //文件名，不包含路径
                //String fileName = tempList[i].getName();
            }
            if (tempList[i].isDirectory()) {
                //这里就不递归了，
            }
        }
        return files;
    }


}
