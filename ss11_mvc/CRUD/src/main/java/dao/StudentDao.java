package dao;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDao {
    private static Map<Integer, Student> studentMap = new HashMap<>();

    static {
        studentMap.put(1, new Student(1, "Hoang", "17/03/1997"));
        studentMap.put(2, new Student(2, "Huyen", "08/02/1998"));
        studentMap.put(3, new Student(3, "Kaka", "10/06/1998"));
    }

    public static List<Student> getListStudent() {
        return new ArrayList<>(studentMap.values());
    } //Mục đích: Lấy list gửi lên trang jsp để hiển thị lên màn hình

    public static void save(Student student) {
        studentMap.put(student.getId(), student);
    }

    public static Student findById(Integer id) {
        return studentMap.get(id);
    }

    public static void deleteById(Integer id) {
        studentMap.remove(id);
    }
}
