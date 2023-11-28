import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main {

    private static final String FILE_STUDENT_LIST = "student_list.txt";
    private static final int MAX_LENGTH_ID = 10;
    private static final int MAX_LENGTH_NAME = 40;

    private static boolean isStringBlank(String s) {
        return s == null || s.length() < 1 || s.trim().length() < 1;
    }

    private static Student parseStudent(String s) {
        String[] splt = s.split(",");
        if (splt.length < 3) {
            return null;
        }
        String id = splt[0];
        if (id.length() > MAX_LENGTH_ID || isStringBlank(id)) {
            return null;
        }
        String name = splt[1];
        if (name.length() > MAX_LENGTH_NAME || isStringBlank(name)) {
            return null;
        }
        if (isStringBlank(splt[2])) {
            return null;
        }
        float score = Float.valueOf(splt[2]).floatValue();
        if (score > 10F || score < 0F) {
            return null;
        }
        return new Student(id, name, score);
    }

    private static DoubleLinkedList readFromFile() {
        DoubleLinkedList list = new DoubleLinkedList();
        try {
            Files.lines(Path.of(FILE_STUDENT_LIST))
                    .map(s -> {
                        Student student = parseStudent(s);
                        if (student == null) {
                            System.err.println("Invalid data: '%s'".formatted(s));
                            return null;
                        }
                        return student;
                    })
                    .filter(Objects::nonNull)
                    .forEach(list::insertLast);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Invalid data will not be used!\n");
        return list;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = readFromFile();
        System.out.println("2. All valid students:");
        list.display();
        System.out.println();

        System.out.println("3. Students whose score > 5:");
        list.display(5.0F);
        System.out.println();

        System.out.println("4. Find student whose id = '11111111_1'");
        Student x = list.findById("11111111_1");
        System.out.println(x.toString());

        System.out.println("5. sort (with mergesort) by score ascendant");
        DoubleLinkedList sorted = DoubleLinkedList.mergeSort(list);
        sorted.display();

        System.out.println("6. Insert student after id = '11111111_3':");
        list.insertAfter(new Student("000", "Vinh", 10), "11111111_3");
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

        System.out.println("9. After remove student id = '11111111_3':");
        list.removeById("11111111_3");
        list.display();
        System.out.println();

        System.out.println("10. After remove all student:");
        list.removeAll();
        list.display();
    }
}
