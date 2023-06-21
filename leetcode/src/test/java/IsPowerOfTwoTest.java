import org.junit.Assert;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/19
 * Time: 上午8:40
 */
public class IsPowerOfTwoTest {

    @Test
    public void test() {
        Assert.assertTrue(isPowerOfTwo(64));
        Assert.assertTrue(isPowerOfTwo(128));
        Assert.assertFalse(isPowerOfTwo(127));
    }

    private boolean isPowerOfTwo(int n) {
        return n == 2 || n == 1 || n % 2 == 0 && n != 0 && isPowerOfTwo(n / 2);
    }
}