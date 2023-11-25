public class Student {

    // TOOD: max lenght = 10
    private String id;

    // TOOD: max lenght = 40
    private String name;

    private float score;

    private Student next;

    private Student prev;

    public Student(String id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    public Student getPrev() {
        return prev;
    }

    public void setPrev(Student prev) {
        this.prev = prev;
    }


}
