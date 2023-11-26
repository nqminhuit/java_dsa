public class Main {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertLast(new Student("1111111111", "Bruce Wayne", 9.9F));
        list.insertLast(new Student("1111111112", "Tom Jerry", 4.9F));
        list.insertLast(new Student("1111111113", "Jerry Tom", 2.9F));
        list.insertLast(new Student("1111111114", "Clark Ken", 6.5F));
        list.insertLast(new Student("1111111115", "Bob Kane", 10F));

        System.out.println("2. All students:");
        list.display();
        System.out.println();

        System.out.println("3. Students whose score > 5:");
        list.display(5.0F);
        System.out.println();
    }
}
