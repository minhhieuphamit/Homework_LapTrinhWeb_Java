package phamminhhieu.asm5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phamminhhieu.asm5.model.Course;
import phamminhhieu.asm5.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repo;

    public List<Course> getAll() {
        return repo.findAll();
    }

    public void add(Course newCourse) {
        repo.save(newCourse);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public void edit(Course course) {
        repo.save(course);
    }

    public Course getById(Integer id) {
        return repo.findById(id).get();
    }
}