public class DoubleLinkedList {

    private Student head;
    private Student tail;
    private int size;

    public DoubleLinkedList () {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size < 1;
    }

    public void insertLast(Student student) {
        Student noPointers = new Student(student.getId(), student.getName(), student.getScore());
        if (this.isEmpty()) {
            this.head = noPointers;
            this.tail = noPointers;
        } else {
            this.tail.setNext(noPointers);
            noPointers.setPrev(this.tail);
            this.tail = noPointers;
        }
        this.size++;
    }

    /**
     * Insert `student` after student whose id == `afterId`
     */
    public void insertAfter(Student student, String afterId) {
        if (student == null || afterId == null) {
            return;
        }
        // 1. insert last
        if (this.tail == null || afterId.equals(this.tail.getId())) {
            insertLast(student);
            this.size++;
            return;
        }

        // 2. insert after x
        Student x = findById(afterId);
        student.setNext(x.getNext());
        x.getNext().setPrev(student);

        student.setPrev(x);
        x.setNext(student);
    }

    public void removeFirst() {
        Student currNode = head;
        if (currNode == null) {
            return;
        }
        head = currNode.getNext();
        if (head == null) { // last element
            return;
        }
        currNode.setNext(null);
        head.setPrev(null);
        this.size--;
    }

    public void removeLast() {
        Student currNode = tail;
        if (currNode == null) {
            return;
        }
        tail = currNode.getPrev();
        if (tail == null) { // last element
            return;
        }
        tail.setNext(null);
        this.size--;
    }

    public void removeById(String id) {
        // 1. remove first
        if (id.equals(head.getId())) {
            removeFirst();
            return;
        }

        // 2. remove last
        if (id.equals(tail.getId())) {
            removeLast();
            return;
        }

        // 3. remove middle
        Student currNode = findById(id);
        if (currNode == null) {
            return;
        }
        Student tmpPrev = currNode.getPrev();
        currNode.getPrev().setNext(currNode.getNext());
        currNode.getNext().setPrev(tmpPrev);
        currNode.setPrev(null);
        currNode.setNext(null);
        this.size--;
    }

    public void removeAll() {
        Student currNode = this.head;
        while (currNode != null) {
            removeFirst();
            currNode = this.head;
        }
    }

    public void display() {
        if (this.isEmpty()) {
            System.out.println("The list is now empty!");
        }
        Student curNode = this.head;

        while(curNode != null) {
            System.out.println(curNode.toString());
            if(curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            else {
                break;
            }
        }
    }

    /**
     * Display students whose score higher than `score`
     */
    public void display(float score) {
        Student curNode = this.head;

        while (curNode != null) {
            float studentScore = curNode.getScore();
            if (studentScore > 5) {
                System.out.println(curNode.toString());
            }

            if (curNode.getNext() != null) {
                curNode = curNode.getNext();
            } else {
                break;
            }
        }
    }

    /**
     * Find student whose Id = `id`
     * */
    public Student findById(String id) {
        Student curNode = this.head;

        while (curNode != null) {
            if (id.equals(curNode.getId())) {
                return curNode;
            }

            if (curNode.getNext() != null) {
                curNode = curNode.getNext();
            } else {
                break;
            }
        }
        return null;
    }

    /**
     * Sort by ascendant
     * */
    public static DoubleLinkedList mergeSort(DoubleLinkedList list) {
        int s = list.size;
        if (s <= 1) {
            return list;
        }
        int halfS = s / 2;
        int i = 0;
        Student currNode = list.head;
        DoubleLinkedList left = new DoubleLinkedList();
        DoubleLinkedList right = new DoubleLinkedList();
        while (i < halfS) {
            left.insertLast(currNode);
            currNode = currNode.getNext();
            i++;
        }
        while (currNode != null || i < s) {
            right.insertLast(currNode);
            currNode = currNode.getNext();
            i++;
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private static DoubleLinkedList merge(DoubleLinkedList left, DoubleLinkedList right) {
        DoubleLinkedList result = new DoubleLinkedList();
        while (left.head != null && right.head != null) {
            if (left.head.getScore() < right.head.getScore()) {
                result.insertLast(left.head);
                left.removeFirst();
            } else {
                result.insertLast(right.head);
                right.removeFirst();
            }
        }
        while (left.head != null) {
            result.insertLast(left.head);
            left.removeFirst();
        }
        while (right.head != null) {
            result.insertLast(right.head);
            right.removeFirst();
        }
        return result;
    }

    // getters setters
    public Student getHead() {
        return head;
    }

    public void setHead(Student head) {
        this.head = head;
    }

    public Student getTail() {
        return tail;
    }

    public void setTail(Student tail) {
        this.tail = tail;
    }

}
