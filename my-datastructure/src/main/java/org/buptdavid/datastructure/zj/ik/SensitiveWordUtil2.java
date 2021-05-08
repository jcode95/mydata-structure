package org.buptdavid.datastructure.zj.ik;

import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.dic.Hit;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * 敏感词处理工具 - IKAnalyzer中文分词工具 - 借助分词进行敏感词过滤
 *
 * @author sam
 * @since 2017/9/4
 */
public class SensitiveWordUtil2 {

    /**
     * 敏感词集合
     */
    public static HashMap sensitiveWordMap;

    /**
     * 初始化敏感词库
     *
     * @param sensitiveWordSet 敏感词库
     */
    public static synchronized void init(Set<String> sensitiveWordSet) {
        //初始化敏感词容器，减少扩容操作
        sensitiveWordMap = new HashMap(sensitiveWordSet.size());
        for (String sensitiveWord : sensitiveWordSet) {
            sensitiveWordMap.put(sensitiveWord, sensitiveWord);
        }
    }

    /**
     * 判断文字是否包含敏感字符
     *
     * @param txt 文字
     * @return 若包含返回true，否则返回false
     */
    public static boolean contains(String txt) throws Exception {
        boolean flag = false;
        List<String> wordList = segment(txt);
        for (String word : wordList) {
            if (sensitiveWordMap.get(word) != null) {
                return true;
            }
        }
        return flag;
    }

    /**
     * 获取文字中的敏感词
     *
     * @param txt 文字
     * @return
     */
    public static Set<String> getSensitiveWord(String txt) throws IOException {
        Set<String> sensitiveWordList = new HashSet<>();

        List<String> wordList = segment(txt);
        for (String word : wordList) {
            if (sensitiveWordMap.get(word) != null) {
                sensitiveWordList.add(word);
            }
        }
        return sensitiveWordList;
    }

    /**
     * 替换敏感字字符
     *
     * @param txt         文本
     * @param replaceChar 替换的字符，匹配的敏感词以字符逐个替换，如 语句：我爱中国人 敏感词：中国人，替换字符：*， 替换结果：我爱***
     * @return
     */
    public static String replaceSensitiveWord(String txt, char replaceChar) throws IOException {
        String resultTxt = txt;
        //获取所有的敏感词
        Set<String> sensitiveWordList = getSensitiveWord(txt);
        String replaceString;
        for (String sensitiveWord : sensitiveWordList) {
            replaceString = getReplaceChars(replaceChar, sensitiveWord.length());
            resultTxt = resultTxt.replaceAll(sensitiveWord, replaceString);
        }
        return resultTxt;
    }

    /**
     * 替换敏感字字符
     *
     * @param txt        文本
     * @param replaceStr 替换的字符串，匹配的敏感词以字符逐个替换，如 语句：我爱中国人 敏感词：中国人，替换字符串：[屏蔽]，替换结果：我爱[屏蔽]
     * @return
     */
    public static String replaceSensitiveWord(String txt, String replaceStr) throws IOException {
        String resultTxt = txt;
        //获取所有的敏感词
        Set<String> sensitiveWordList = getSensitiveWord(txt);
        for (String sensitiveWord : sensitiveWordList) {
            resultTxt = resultTxt.replaceAll(sensitiveWord, replaceStr);
        }
        return resultTxt;
    }

    /**
     * 获取替换字符串
     *
     * @param replaceChar
     * @param length
     * @return
     */
    private static String getReplaceChars(char replaceChar, int length) {
        String resultReplace = String.valueOf(replaceChar);
        for (int i = 1; i < length; i++) {
            resultReplace += replaceChar;
        }

        return resultReplace;
    }

    /**
     * 对语句进行分词
     *
     * @param text 语句
     * @return 分词后的集合
     * @throws IOException
     */
    private static List segment(String text) throws IOException {
        List<String> list = new ArrayList<>();
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, false);
        Lexeme lex;
        while ((lex = ik.next()) != null) {
            list.add(lex.getLexemeText());
        }
        return list;
    }

    public static void main(String[] args) throws IOException {

        Set<String> sensitiveWordSet = new HashSet<>();
        sensitiveWordSet.add("太多");
        sensitiveWordSet.add("爱恋");
        sensitiveWordSet.add("静静");
        sensitiveWordSet.add("哈哈");
        sensitiveWordSet.add("啦啦");
        sensitiveWordSet.add("感动");
        sensitiveWordSet.add("发呆");
        sensitiveWordSet.add("高级会计实务");
        sensitiveWordSet.add("础");
        //初始化敏感词库
        SensitiveWordUtil2.init(sensitiveWordSet);

        /**
         * 需要进行处理的目标字符串
         */
        System.out.println("敏感词的数量：" + SensitiveWordUtil2.sensitiveWordMap.size());
        String string = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节。"
                + "然后 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
                + "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个贱人一杯红酒一部电影在夜 深人静的晚上，关上电话静静的发呆着。";
        System.out.println("待检测语句字数：" + string.length());

        /**
         * 是否含有关键字
         */
        try {
            boolean result = SensitiveWordUtil2.contains(string);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 获取语句中的敏感词
         */
        Set<String> set = SensitiveWordUtil2.getSensitiveWord(string);
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);

        /**
         * 替换语句中的敏感词
         */
        String filterStr = SensitiveWordUtil2.replaceSensitiveWord(string, '_');
        System.out.println(filterStr);

//        String filterStr2 = SensitiveWordUtil2.replaceSensitiveWord(string, "[*敏感词*]");
//        System.out.println(filterStr2);
        System.out.println("---------------------------  ");
        String s = "2012年高级会计实务基础班";
        Configuration cfg = org.wltea.analyzer.cfg.DefaultConfig.getInstance();
        cfg.setUseSmart(true);
        org.wltea.analyzer.dic.Dictionary.initial(cfg);
        Dictionary dictionary = Dictionary.getSingleton();

        List<String> words = new ArrayList<String>();
        words.add("基础班");
        words.add("高级会计实务");
        words.add("础");
        dictionary.addWords(words);


        System.out.println(cfg.getMainDictionary());
        System.out.println(cfg.getQuantifierDicionary());

        Hit hit = dictionary.matchInMainDict("基础班".toCharArray());
        System.out.println(hit.isMatch());


        System.out.println(segment(s));

        String word = SensitiveWordUtil2.replaceSensitiveWord(s, '*');
        System.out.println("word = " + word);

    }

}
