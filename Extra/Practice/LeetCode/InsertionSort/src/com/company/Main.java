package com.company;

import java.util.List;

public class Main {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    class Solution{
        public ListNode get(ListNode head, int index)
        {
            int i = 0;
            while(i != index)
            {
                head = head.next;
                i++;
            }
            return head;
        }
        public int length(ListNode head)
        {
            int n = 0;
            while(head != null)
            {
                n++;
                head = head.next;
            }
            return n;
        }
         public ListNode insertionSortList(ListNode head) {
            int N = length(head), i = N - 2;

            while(i >= 0)
            {
                ListNode current = get(head, i);
                while(current.next != null && current.val > current.next.val)
                {
                    int aux = current.val;
                    current.val = current.next.val;
                    current.next.val = aux;

                    current = current.next;
                }
                i--;
            }
            return head;
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
