package ru.gb.homework7;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
@RequestMapping("/students")
public class StudentRepository {
    private final List<Student> students = List.of(
            new Student(1L, "Student #1",20),
            new Student(2L, "Student #2",21),
            new Student(3L, "Student #3",19),
            new Student(4L, "Student #4", 20),
            new Student(5L, "Student #5", 20)
    );

    public List<Student> getAllStudents() {return Collections.unmodifiableList(students);}

    public void deleteById(Long id) {
        students.removeIf(student -> Objects.equals(student.getId(), id));
    }

    public Student findById(int id) {
        return students.get(id);
    }
}
