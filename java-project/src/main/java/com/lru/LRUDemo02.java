package com.lru;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * LRU 算法
 * 哈希+ 双向链表
 *
 * @author pengwei
 * @date 2021/2/17
 */
public class LRUDemo02 {


    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }


    }

    class LRUDoubleLinkedList<K, V> {

        private Node<K, V> head;
        private Node<K, V> tail;

        public LRUDoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;

        }

        public Node<K, V> getLast() {
            return tail.prev;
        }

    }

    /**
     * 坑位
     */
    private int capacity;
    Map<Integer, Node<Integer, Integer>> map;
    LRUDoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUDemo02(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinkedList = new LRUDoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addNode(node);
        return node.value;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addNode(node);

        } else {
            //坑位已满
            if (map.size() == capacity) {
                Node<Integer, Integer> last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }
            Node<Integer, Integer> node = new Node<>(key, value);
            map.put(key, node);
            doubleLinkedList.addNode(node);

        }
    }

    public static void main(String[] args) {

    }
}
