package com.example.java;



public class TreeMapSelf<K extends Comparable<K>, V> {
    public class Node<K extends Comparable<K>, V> implements Comparable<Node<K,V>> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node<K, V> o) {
            return getKey().compareTo(o.getKey());
        }
    }

    private Node root = null;
    private int size = 0;



    public V getValue(K key) {
        //check if the root is null;

        if (root == null) return null;
        // otherwise find the node from the root;

        Node<K, V> curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.getKey());
            if (cmp == 0) {
                return curr.getValue();
            }
            else if (cmp < 0){
                curr = curr.left;
            }
            else curr = curr.right;
        }
        return null;
    }


    public void put(K key, V value) {
        Node<K, V> node = findNode(key);
        if (node == null) {
            root = new Node<K, V>(key, value);
            size++;
            return;
        }
        if (node.getKey().equals(key)) {
            //find the key, change the value;
            node.setValue(value);
        }
        else {
            // find the position, add the value;
            int cmp = node.getKey().compareTo(key);
            size++;
            if (cmp < 0) {
                node.right = new Node<K, V>(key, value);
            }
            else {
                node.left = new Node<K, V>(key, value);
            }
        }
    }

    private Node<K, V> findNode(K key) {
        if (root == null) return null;
        int cmp = 0;
        Node<K, V> curr = root;
        Node<K, V> prev = null;
        while (curr != null) {
            cmp = key.compareTo(curr.getKey());
            if (cmp == 0) {
                return curr;
            }
            else if (cmp < 0) {
                prev = curr;
                curr = curr.left;
            }
            else {
                prev = curr;
                curr = curr.right;
            }
        }
        return prev;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        TreeMapSelf<Integer, String> map = new TreeMapSelf<Integer, String>();
        map.put(1, "I like you");
        map.put(-1, "You like me");
        map.put(4, "I want you");
        map.put(6, "you need me");
        System.out.println(map.size());
        System.out.println(map.getValue(3));
        System.out.println(map.getValue(1));
    }

}
