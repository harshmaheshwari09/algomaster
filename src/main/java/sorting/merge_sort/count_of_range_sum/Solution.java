package sorting.merge_sort.count_of_range_sum;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return mergeSort(prefixSum, 0, prefixSum.length - 1, lower, upper);
    }

    private int mergeSort(long[] prefixSum, int l, int r, int lower, int upper) {
        if (l >= r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        int result = mergeSort(prefixSum, l, mid, lower, upper)
                + mergeSort(prefixSum, mid + 1, r, lower, upper);

        result += countRange(prefixSum, l, mid, r, lower, upper);
        merge(prefixSum, l, mid, r);
        return result;
    }

    private int countRange(long[] prefixSum, int l, int mid, int r, int lower, int upper) {
        int result = 0;
        int start = l;
        int end = l;

        for (int right = mid + 1; right <= r; right++) {
            while (start <= mid && prefixSum[start] < prefixSum[right] - upper) {
                start++;
            }

            while (end <= mid && prefixSum[end] <= prefixSum[right] - lower) {
                end++;
            }

            result += end - start;
        }

        return result;
    }

    private void merge(long[] prefixSum, int l, int mid, int r) {
        long[] sorted = new long[r - l + 1];
        int left = l;
        int right = mid + 1;
        int idx = 0;

        while (left <= mid && right <= r) {
            if (prefixSum[left] <= prefixSum[right]) {
                sorted[idx++] = prefixSum[left++];
            } else {
                sorted[idx++] = prefixSum[right++];
            }
        }

        while (left <= mid) {
            sorted[idx++] = prefixSum[left++];
        }

        while (right <= r) {
            sorted[idx++] = prefixSum[right++];
        }

        for (int i = 0; i < sorted.length; i++) {
            prefixSum[l + i] = sorted[i];
        }
    }
}
