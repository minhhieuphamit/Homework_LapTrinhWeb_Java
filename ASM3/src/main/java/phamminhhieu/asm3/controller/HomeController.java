package phamminhhieu.asm3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import phamminhhieu.asm3.service.CourseService;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/test")
    @ResponseBody
    public String index() {
        String s = "5";
        return 2 + 20 + s + 20 +2 ;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("listCourse", courseService.getAll());
        return "home";
    }
}
