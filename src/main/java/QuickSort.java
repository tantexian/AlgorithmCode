/**
 * @author tantexian
 * @since 2018/9/19
 */
public class QuickSort {
    static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }

        int temp;
        int i = left, j = right;
        int mid = a[left];
        while (i != j) {
            while (a[j] >= mid && i < j) {
                j--;
            }
            while (a[i] <= mid && i < j) {
                i++;
            }
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // 交换枢纽值
        a[left] = a[i];
        a[i] = mid;

        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 1, 6, 5, 3};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i);
        }
    }
}
