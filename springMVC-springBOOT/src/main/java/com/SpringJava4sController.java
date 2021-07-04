package com;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//http://localhost:8080/springbootmvc/
@RestController
public class SpringJava4sController {

    @GetMapping("/")
    public ModelAndView showLoginPage(Model model) {
        model.addAttribute("message", "Welcome to Java4s Spring Boot Tutorials");

        return new ModelAndView("welcomePage");
    }
}
