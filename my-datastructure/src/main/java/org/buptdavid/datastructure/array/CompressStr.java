package org.buptdavid.datastructure.array;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 压缩字符串,如果压缩后的字符串长度大于等于原字符串长度,则返回原字符串
 *
 * @author weijielu
 */
public class CompressStr {
    public static String compress(String s) {
        StringBuffer sb = new StringBuffer();

        int i, j;
        for (i = 0; i < s.length(); i++) {
            j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            sb.append(j - i);
            sb.append(s.charAt(i));


            i = j - 1;
        }

        String sbString = sb.toString();
        return sbString.length() <= s.length() ? sbString.toString() : s;
    }

    @Test
    public void test() {
        String s1 = "aabcccaaaa";
        String expectedS1 = "a2b1c3a4";

        String s2 = "aaaaaaaaaaaa";
        String compress = CompressStr.compress(s2);

        String expectedS2 = "a12";

        String s3 = "abcdefg";
        String expectedS3 = "abcdefg";

        String s4 = "aabbccdd";
        String expectedS4 = "aabbccdd";

        Assert.assertEquals(expectedS1, compress(s1));
        Assert.assertEquals(expectedS2, compress(s2));
        Assert.assertEquals(expectedS3, compress(s3));
        Assert.assertEquals(expectedS4, s4);
    }

    public static String compressMy(String string) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < string.length(); i++) {
            int j = i - 1;
            if (string.charAt(j + 1) == string.charAt(j)) {
                count++;
                if (i == string.length() - 1) {
                    sb.append(count + "" + string.charAt(j));
                }
            } else {
                sb.append(count + "" + string.charAt(j));
                count = 1;
            }
        }

        return sb.toString();
    }

    @Test
    public void testMy() {
        String str = "aabbccdd";
        String s = CompressStr.compressMy(str);
        System.out.println(s);
    }
}
