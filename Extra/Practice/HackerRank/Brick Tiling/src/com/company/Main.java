package com.company;

import java.io.*;
import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }

}
public class Main
{
    public static Node removeDuplicates(Node head) {
        if(head == null) return null;
        else {
            Node index_1 = head;
            while(index_1 != null && index_1.next != null) {
                Node index_2 = index_1.next;
                while(index_2 != null && index_2.data == index_1.data) {
                    index_1.next = index_2.next;
                    index_2 = index_2.next;
                }

                while(index_2 != null && index_2.next != null) {
                    if(index_2.next.data == index_1.data) {
                        index_2.next = index_2.next.next;
                    } else index_2 = index_2.next;
                }

                index_1 = index_1.next;
            }
            return head;
        }
    }

    public static  Node insert(Node head,int data){
        Node p=new Node(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
    {
        Node start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Node head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}