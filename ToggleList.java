package com.example.java;

import java.util.*;

/**
 * Created by yueyangzou on 16/10/10.
 */
public class ToggleList {
    class Node {
        String user;
        Node next;
        Node prev;
        public Node(String user) {
            this.user = user;
            prev = null;
            next = null;
        }
    }

    Node head;
    Node tail;
    Hashtable<String, Node> hashtable = new Hashtable<String, Node>();
    public ToggleList() {
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    private void moveAfterHead(Node curr) {
        Node headnext = head.next;
        head.next = curr;
        headnext.prev = curr;
        curr.next = headnext;
        curr.prev = head;
    }

    private void deleteNode(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    public void toggle(String username) {
        if (username == null) return;
        if (!hashtable.containsKey(username)) {
            // add it to the double list, and update the hashtable,
            Node curr = new Node(username);
            moveAfterHead(curr);
            hashtable.put(username, curr);
        }
        else {
            //if delete the entry in the hashtable, and delete the node.
            Node curr = hashtable.get(username);
            hashtable.remove(username);
            deleteNode(curr);
        }


    }
    public List<String> getSelectedList() {
        List<String> list = new ArrayList<String>();
        Node curr = tail.prev;
        while (curr != head) {
            list.add(curr.user);
            curr = curr.prev;
        }
        return list;
    }

    public static void main(String[] args) {
        ToggleList toggleList = new ToggleList();
        toggleList.toggle("a");
        toggleList.toggle("b");
        toggleList.toggle("c");
        toggleList.toggle("a");
        for (String str : toggleList.getSelectedList()) {
            System.out.println(str);
        }
    }
}
