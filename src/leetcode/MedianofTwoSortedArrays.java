package leetcode;

import java.util.Arrays;

/**
 * Created by leon on 16/5/14.
 */

//There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

//The problem is equivalent to find the kth element in the two sorted array.
// The key is to decide how to eliminate part of the array each recursion。

public class MedianofTwoSortedArrays {
    //两数组已排序
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.f;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        if ((n1 + n2) % 2 == 1) {
            //奇数长度
            return findMedianHelper(nums1, nums2, (n1 + n2) / 2 + 1);
        } else {
            //偶数长度
            return (findMedianHelper(nums1, nums2, (n1 + n2) / 2) + findMedianHelper(nums1, nums2, (n1 + n2) / 2 + 1)) / 2;
        }
    }

    //找出两数组中间的值
    private double findMedianHelper(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0) {
            return nums2[k - 1];
        }

        if (nums2 == null || nums2.length == 0) {
            return nums1[k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        //num1数组中间值大于num2
        if (nums1[n1 / 2] > nums2[n2 / 2]) {
            if ((n1 / 2 + n2 / 2 + 1) >= k) {
                //收敛
                return findMedianHelper(Arrays.copyOfRange(nums1, 0, n1 / 2), nums2, k);
            } else {
                return findMedianHelper(nums1, Arrays.copyOfRange(nums2, n2 / 2 + 1, n2), k - (n2 / 2 + 1));
            }
        } else {
            if ((n1 / 2 + n2 / 2 + 1) >= k) {
                return findMedianHelper(nums1, Arrays.copyOfRange(nums2, 0, n2 / 2), k);
            } else {
                return findMedianHelper(Arrays.copyOfRange(nums1, n1 / 2 + 1, n1), nums2, k - (n1 / 2 + 1));
            }
        }
    }

}
