package leetcode;

/**
 * Created by leon on 16/5/8.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

// You are given two linked lists representing two non-negative numbers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }

            //求余 11 % 10 = 1
            //p3 = p3.next 每次重置,但是newHead每次都会加next
            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            //整除 11 / 10 = 1, 加到下一位
            carry /= 10;
        }

        //进位
        if (carry == 1)
            p3.next = new ListNode(1);

        return newHead.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(3);
        ListNode ll1 = new ListNode(4);
        l1.next = ll1;
        ll1.next = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode ll2 = new ListNode(6);
        l2.next = ll2;
        ll2.next = new ListNode(5);
        ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(l3.val + " " + l3.next.val + " " + l3.next.next.val);
    }
}
