public class Student {

    private String id;

    private String name;

    private float score;

    private Student next;

    private Student prev;

    public Student(String id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        String s = "id: " + this.getId() + "\n";
        s += "name: " + this.getName() + "\n";
        s += "score: " + this.getScore() + "\n";
        return s;
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
