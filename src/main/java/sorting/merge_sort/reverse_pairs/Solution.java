package sorting.merge_sort.reverse_pairs;

class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        int result = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        result += countReversePairs(nums, l, mid, r);
        merge(nums, l, mid, r);
        return result;
    }

    private int countReversePairs(int[] nums, int l, int mid, int r) {
        int result = 0;
        int right = mid + 1;

        for (int left = l; left <= mid; left++) {
            while (right <= r && (long) nums[left] > 2L * nums[right]) {
                right++;
            }
            result += right - (mid + 1);
        }

        return result;
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] sorted = new int[r - l + 1];
        int left = l;
        int right = mid + 1;
        int idx = 0;

        while (left <= mid && right <= r) {
            if (nums[left] <= nums[right]) {
                sorted[idx++] = nums[left++];
            } else {
                sorted[idx++] = nums[right++];
            }
        }

        while (left <= mid) {
            sorted[idx++] = nums[left++];
        }

        while (right <= r) {
            sorted[idx++] = nums[right++];
        }

        for (int i = 0; i < sorted.length; i++) {
            nums[l + i] = sorted[i];
        }
    }
}
