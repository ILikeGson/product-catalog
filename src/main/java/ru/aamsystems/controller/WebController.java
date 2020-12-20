package ru.aamsystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.aamsystems.controller.Dto.ProductDto;

@Controller
public class WebController {

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("product", new ProductDto());
        return "index";
    }

}
