package com.penghuis.leetcode;

import java.security.SecureRandom;
import java.util.Random;
import java.util.RandomAccess;

/**
 * @ClassName: Node234
 * @Description: 请判断一个链表是否为回文链表
 * @Author: zhangpenghui
 * @Date: 2020/7/16 3:24 下午
 * @Version: V1.0
 */
public class Node234 {

    static class Node<T>{
        Node next;
        T val;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node<String> head = null;
        Node<String> tail = null;

        head = new Node<String>();
        head.setVal("-1");
        tail = head;

        for (int i = 0; i < 10; i++) {
            tail.setNext(new Node());
            tail = tail.getNext();
            tail.setVal("" + i);
        }

        for (int i = 9; i >= -1; i--) {
            tail.setNext(new Node());
            tail = tail.getNext();
            tail.setVal("" + i);
        }

        Node print = head;
        while(print != null){
            System.out.println(print.val);
            print = print.next;
        }
        System.out.println(Node234.isPalindrome(head));
    }

    public static boolean isPalindrome(Node head){
        if(head == null || head.getNext() == null){
            return true;
        }

        Node fast = head;
        Node slow = head;
        Node prev = null;

        while (fast != null && fast.getNext() != null){
            fast = fast.next.next;
            Node next = slow.getNext();
            slow.setNext(prev);
            prev = slow;
            slow = next;
        }

        if(fast != null){
            slow = slow.next;
        }

        while (slow != null){
            System.out.println(slow.val + "," + prev.val);
            if(!slow.val.equals(prev.val)){
                return false;
            }

            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}
