package phamminhhieu.asm5.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import phamminhhieu.asm5.model.Course;
import phamminhhieu.asm5.service.CourseService;

import java.util.List;

@Controller
@RequestMapping(value = {"/course"})
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("course", new Course());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid Course newCourse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("course", newCourse);
            return "create";
        }
        courseService.add(newCourse);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        courseService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Course course = courseService.getById(id);
        model.addAttribute("course", course);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, @Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("course", course);
            return "edit";
        }
        courseService.edit(course);
        return "redirect:/home";
    }
}
