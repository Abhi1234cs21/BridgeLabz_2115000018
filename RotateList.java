import java.util.ArrayList;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int rotateBy = 2;
        List<Integer> rotatedList = rotateList(list, rotateBy);

        System.out.println(rotatedList);
    }

    public static List<Integer> rotateList(List<Integer> list, int rotateBy) {
        int size = list.size();
        rotateBy = rotateBy % size;  // To handle cases where rotateBy > size of list

        List<Integer> rotatedList = new ArrayList<>();
        for (int i = rotateBy; i < size; i++) {
            rotatedList.add(list.get(i));
        }
        for (int i = 0; i < rotateBy; i++) {
            rotatedList.add(list.get(i));
        }

        return rotatedList;
    }
}
