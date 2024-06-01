package linear.stack;

import org.junit.Test;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/decode-string/">...</a>
 * 字符串解码
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class DecodeStringTest {

    @Test
    public void test() {
        String res = decodeString("3[a]2[bc]");
        System.out.println(res);
    }

    /**
     * <a href="https://leetcode.cn/problems/decode-string/solutions/19447/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/">...</a>
     * 思路：本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> multiStack = new LinkedList<>();
        LinkedList<String> resStack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                multiStack.addLast(multi);
                resStack.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = multiStack.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(resStack.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
