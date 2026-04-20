package edu.xyf.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xuyifeng
 * @Description: LRU 缓存
 * @Date: 2026/4/9 22:22
 */

public class Q2Leetcode146 {

    static class LRUCache {

        Map<Integer, Node> map = new HashMap<>();
        DoublyLinkedList list = new DoublyLinkedList();

        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                list.remove(node);
                list.addFirst(node);
            } else {
                Node node = new Node(key, value);
                map.put(key, node);
                list.addFirst(node);
                if (map.size() > capacity) {
                    Node removed = list.removeLast();
                    map.remove(removed.key);
                }
            }
        }

        static class Node {
            Node prev;
            Node next;
            int key;
            int value;

            public Node() {

            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        static class DoublyLinkedList {
            Node head;
            Node tail;

            DoublyLinkedList() {
                head = tail = new Node();
                head.next = tail;
                tail.next = head;
            }

            public void addFirst(Node node) {
                Node oldFirst = head.next;
                node.next = oldFirst;
                oldFirst.prev = node;
                node.prev = head;
                head.next = node;
            }

            public void remove(Node node) {
                Node next = node.next;
                Node prev = node.prev;
                prev.next = next;
                next.prev = prev;
            }

            public Node removeLast() {
                Node removed = tail.prev;
                remove(removed);
                return removed;
            }
        }
    }

}
