/**
 * @author tantexian
 * @since 2018/9/22$
 */
public class CycleArray {

    static void reverse(int a[], int start, int end) {
        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = a.length - 1;
        int k = 3;
        k = k % n;

        reverse(a, 0, n - k);
        reverse(a, n - k + 1, n);
        reverse(a, 0, n);
        for (int i : a) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
