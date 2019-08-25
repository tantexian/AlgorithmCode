import javax.swing.*;

/**
 * @author tantexian
 * @since 2019-08-25
 * <p>
 * 从n个字符串里面选择m个字符长度的所有组合，此题解题思路为一个动态规划
 * 动态规划递归求解。
 * 可以考虑求长度为n的字符串中m个字符的组合，设为C(n,m)。
 * 原问题的解即为C(n, 1), C(n, 2),...C(n, n)的总和。
 * 对于求C(n, m)，从第一个字符开始扫描，每个字符有两种情况，要么被选中，要么不被选中，
 * 如果被选中，递归求解C(n-1, m-1)。如果未被选中，递归求解C(n-1, m)。
 * 不管哪种方式，n的值都会减少，递归的终止条件n=0或m=0。
 * https://blog.csdn.net/fxkcsdn/article/details/81328089
 */
public class StringCombination {

    public static void main(String[] args) {
        char[] a = {'1', '2', '3'};
        comb(a, 0, 3, new StringBuffer());
    }

    /**
     * @param a     全局数组
     * @param start 从数组的start位置开始，选取m个字符进行组合
     * @param m
     */
    private static void comb(char[] a, int start, int m, StringBuffer result) {
        // FIXME: 2019 - 08 - 25
        // 剩余长度不足以选取m个字符
        if (a.length - start < m || m == 0) {
            return;
        }

        // 情况1：在前部分，start起始点没有被选中，那么在剩余部分则应该选择m个
        System.out.print(result + ", ");
        comb(a, start + 1, m, result);

        // 情况2：在前部分，start起始点被选中，那么在剩余部分则应该选择m-1个
        result.append(a[start]);
        System.out.print(result + ", ");
        comb(a, start + 1, m - 1, result);
    }
}
