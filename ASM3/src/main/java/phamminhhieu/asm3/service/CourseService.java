package phamminhhieu.asm3.service;

import org.springframework.stereotype.Service;
import phamminhhieu.asm3.model.Course;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> listCourse = new ArrayList<>();

    public void add(Course newProduct) {
        listCourse.add(newProduct);
    }

    public List<Course> getAll() {
        return listCourse;
    }
}
