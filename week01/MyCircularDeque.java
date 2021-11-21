class MyCircularDeque {

    private ListNode head;

    private ListNode tail;

    private int size;

    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        ListNode n = new ListNode(value);
        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.pre = n;
            head = head.pre;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        ListNode n = new ListNode(value);
        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.pre = tail;
            tail.next = n;
            tail = tail.next;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = head.next;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = tail.pre;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode pre;

        ListNode(){}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode pre, ListNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }


    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
