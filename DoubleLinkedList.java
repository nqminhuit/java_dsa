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
        if (this.isEmpty()) {
            this.head = student;
            this.tail = student;
            this.size++;
        }
        else {
            this.tail.setNext(student);
            student.setPrev(this.tail);
            this.tail = student;
        }
    }

    public void insertFirst(Student student) {}

    /**
     * Insert `student` after student whose id == `afterId`
     */
    public void insertMiddle(Student student, String afterId) {}

    public void removeFirst() {}

    public void removeLast() {}

    public void removeMiddle(String id) {}

    public void removeAll() {
        this.head = null;
        this.tail = null;
    }

    public void display() {
        Student curNode = this.head;

        while(curNode != null) {
            System.out.println("id: " + curNode.getId());
            System.out.println("name: " + curNode.getName());
            System.out.println("score: " + curNode.getScore());
            System.out.println();

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
                System.out.println("id: " + curNode.getId());
                System.out.println("name: " + curNode.getName());
                System.out.println("score: " + studentScore);
                System.out.println();
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
    public Student display(String id) {
        return null;
    }

    /**
     * Sort using `Merge sort algorithm` ascendant
     * */
    public void sort() {}

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
