/**
 * @author tantexian
 * @since 2019-08-25
 */
public class FullArray {

    public static void main(String[] args) {

        char[] a = {'1', '2', '2', '3'};
        fullarray(a, 0, 3);
    }

    private static void fullarray(char[] a, int from, int to) {
        // 递归出口，如果起始位置和结束位置相等，直接输入之前排列即可
        if (from == to) {
            for (int i = 0; i <= from; i++) {
                System.out.print(a[i] + ", ");
            }
            System.out.println();
        } else {
            // 固定from的第一个，第一个元素可以从剩下的from->to依次选择
            for (int j = from; j <= to; j++) {
                // 如果想去重，则针对相同，不进行交互
                if (a[from] == a[j] && j != from) {
                    continue;
                }
                // 将第j个值与from的位置交互
                swap(a, from, j);
                // 递归调用，固定了第一个，剩余的进行全排列
                fullarray(a, from + 1, to);
                // 因为a是全局变量，因为需要交换回来
                swap(a, from, j);
            }
        }


    }

    private static void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
