package ru.aamsystems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.aamsystems.controller.Dto.ProductDto;
import ru.aamsystems.exception.ProductNotFoundException;
import ru.aamsystems.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String getProductPage(Model model) {
        model.addAttribute("product", new ProductDto());
        return "add-product";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute("product") ProductDto product) {
        ProductDto.toDto(productService.insert(ProductDto.toDomainObject(product)));
        return "redirect:/";
    }


    @PostMapping("/find")
    public String findProductByName(@RequestParam("name") String name, Model model) {
         model.addAttribute("product", ProductDto.toDto(productService.findByName(name)));
         return "product-info";
    }

    @GetMapping("/update/{id}")
    public String getEditPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit-page";
    }

    @PostMapping("/update")
    public String updateProductByName(@ModelAttribute("product") ProductDto productDto) {
        productService.update(ProductDto.toDomainObject(productDto), productDto.getId());
        return "redirect:/" ;
    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable("id") long id){
        productService.deleteById(id);
        return "redirect:/";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleException(ProductNotFoundException exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        modelAndView.addObject("message", exception.getMessage());
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
