public class Main {

    public static void main(String[] args) {
        // TODO read data from file

        // TODO: validate id length <= 10; name length <= 40; score <= 10.0

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

        System.out.println("4. Find student whose id = '1111111111'");
        Student x = list.findById("1111111111");
        System.out.println("\n" + x.toString() + "\n");

        // TODO 5

        System.out.println("6. Insert student after id = '1111111113':");
        list.insertAfter(new Student("000", "Vinh", 10), "1111111113");
        list.display();
        System.out.println();

        System.out.println("7. After remove first student:");
        list.removeFirst();
        list.display();
        System.out.println();

        System.out.println("8. After remove last student:");
        list.removeLast();
        list.display();
        System.out.println();

        System.out.println("9. After remove student id = '1111111113':");
        list.removeById("1111111113");
        list.display();
        System.out.println();

        System.out.println("10. After remove all student:");
        list.removeAll();
        list.display();
        System.out.println();
    }
}
