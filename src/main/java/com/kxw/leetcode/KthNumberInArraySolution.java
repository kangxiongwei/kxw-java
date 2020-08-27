package com.kxw.leetcode;

/**
 * 查询数组中第k大的数
 *
 * @author kangxiongwei
 * @date 2020-06-23 10:46
 */
public class KthNumberInArraySolution {

    public static void main(String[] args) {
        int k = 6;
        int[] array = new int[]{1, 3, 4, 5, 6, 2, 3};
        int kth = findKthByQuickSort(array, 0, array.length - 1, k);
        int hkth = findKthByHeapSort(array, array.length);
        System.out.println("quickSort ==> " + kth + "， heapSort ==> " + hkth);
    }

    public static int findKthByQuickSort(int[] num, int low, int high, int k) {
        if (low <= high) {
            int pos = partition(num, low, high);
            if (pos == k - 1) {
                return num[pos];
            } else if (pos > k - 1) {
                return findKthByQuickSort(num, low, pos - 1, k);
            } else {
                return findKthByQuickSort(num, pos + 1, high, k);
            }
        } else {
            return -1;
        }
    }

    public static int findKthByHeapSort(int[] num, int k) {
        int len = num.length;
        buildMaxHeap(num, len);
        for (int i = num.length - 1; i >= 0; i--) {
            swap(num, 0, i);
            len--;
            maxHeap(num, 0, len);
        }
        return num[k - 1];
    }

    /**
     * 构建大根堆
     *
     * @param num
     */
    public static void buildMaxHeap(int[] num, int len) {
        for (int i = len / 2; i >= 0; i--) {
            maxHeap(num, i, len);
        }
    }

    public static void maxHeap(int[] num, int root, int length) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int largest = root;
        if (left < length && num[largest] <= num[left]) {
            largest = left;
        }
        if (right < length && num[largest] <= num[right]) {
            largest = right;
        }
        if (largest != root) {
            swap(num, root, largest);
            maxHeap(num, largest, length);
        }
    }

    public static void swap(int[] num, int source, int target) {
        int temp = num[source];
        num[source] = num[target];
        num[target] = temp;
    }

    /**
     * 分治，将low对应的数字进行左右划分
     *
     * @param num
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] num, int low, int high) {
        int tmp = num[low];
        while (low < high) {
            while (low < high && tmp >= num[high]) {
                high--;
            }
            num[low] = num[high];
            while (low < high && tmp <= num[low]) {
                low++;
            }
            num[high] = num[low];
        }
        num[low] = tmp;
        return low;
    }

}
