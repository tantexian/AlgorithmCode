/**
 * @author tantexian
 * @since 2018/9/21
 */
public class MaxSubArray {

    /**
     * 穷举
     *
     * @param a
     * @return
     */
    static int maxSubArray1(int a[]) {
        int n = a.length;
        int sum;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + a[k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * @param a
     * @return
     */
    static int maxSubArray2(int a[]) {
        int n = a.length;
        int sum;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + a[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 分治法
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    static int maxSubArray3(int a[], int left, int right) {
        int max;
        if (left >= right) {
            return a[left];
        }
        int mid = (left + right) / 2;
        int max1 = maxSubArray3(a, left, mid);
        int max2 = maxSubArray3(a, mid + 1, right);
        int crossMax = maxCross(a, left, right);

        max = max1;
        if (max2 > max) {
            max = max2;
        }
        if (crossMax > max) {
            max = crossMax;
        }

        return max;
    }

    static int maxCross(int a[], int left, int right) {
        int mid = (left + right) / 2;

        int max1 = a[mid];
        int leftSum = max1;
        // 像左搜索
        for (int i = mid - 1; i > 0; i--) {
            leftSum = leftSum + a[i];
            if (leftSum > max1) {
                max1 = leftSum;
            }
        }

        // 像右搜索
        int max2 = 0;
        int rightSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightSum = rightSum + a[i];
            if (rightSum > max2) {
                max2 = rightSum;
            }
        }

        return max1 + max2;
    }


    /**
     * 动态规划，简化变量版本
     *
     * @param a
     * @return
     */
    static int maxSubArray4(int a[]) {
        int max = a[0];
        int currMax = 0;

        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            if (currMax >= 0) {
                currMax = currMax + a[i];
            } else {
                currMax = a[i];
            }
            if (currMax > max) {
                max = currMax;
            }

        }
        return max;
    }

    /**
     * 动态规划版本
     *
     * @param a
     * @return
     */
    static int maxSubArray5(int a[]) {
        int n = a.length;
        // d[i] 表示第i个元素结尾的最大子数组
        // 状态转移方程： d[i] = max(d[i-1] + a [i], a[i])
        int[] d = new int[n];
        d[0] = a[0];
        int max = d[0];
        for (int i = 1; i < n; i++) {
            d[i] = max(d[i - 1] + a[i], a[i]);
            if (d[i] > max) {
                max = d[i];
            }
        }

        // 计算d[i]中最大的max
        // 此处可以在上述迭代时候，直接将max求解出来
        return max;
    }

    static int maxSubArray6(int a[]) {
        int n = a.length;
        // d[i] 表示第i个元素结尾的最大子数组
        // 状态转移方程： d[i] = max(d[i-1] + a [i], a[i])
        // int[] d = new int[n];
        // d[0] = a[0];
        int maxDi = a[0];

        int max = maxDi;
        for (int i = 1; i < n; i++) {
            // d[i] = max(d[i - 1] + a[i], a[i]);
            if (maxDi >= 0) {
                maxDi = maxDi + a[i];
            } else {
                maxDi = a[i];
            }
            // if (d[i] > max) {
            //    max = d[i];
            // }
            if (maxDi > max) {
                max = maxDi;
            }
        }

        // 计算d[i]中最大的max
        // 此处可以在上述迭代时候，直接将max求解出来
        return max;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] a = {-1, 3, -4, 5, 4, 2, -2, -7, -1};
        int max1 = maxSubArray1(a);
        System.out.println(max1);

        int max2 = maxSubArray2(a);
        System.out.println(max2);

        int max3 = maxSubArray3(a, 0, a.length - 1);
        System.out.println(max3);

        int max4 = maxSubArray4(a);
        System.out.println(max4);

        int max5 = maxSubArray5(a);
        System.out.println(max5);


        int max6 = maxSubArray6(a);
        System.out.println(max6);

    }
}
