package phamminhhieu.validation.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import phamminhhieu.validation.model.Product;
import phamminhhieu.validation.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping(value = {"/", "/products"})
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "products/create";
    }

    @PostMapping("/create")
    public String create(@Valid Product newProduct, @RequestParam MultipartFile imageProduct, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product", new Product());
            return "products/create";
        }
        if(imageProduct != null && imageProduct.getSize() > 0){
            try{
                File saveFile = new ClassPathResource("static/images").getFile();
                String newImageFile = UUID.randomUUID() + ".png";
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                newProduct.setImage(newImageFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        productService.add(newProduct);
        return "redirect:/products";
    }

    @PostMapping("/edit")
    public String edit(@Valid Product editProduct, @RequestParam MultipartFile imageProduct, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product", editProduct);
            return "products/edit";
        }
        if(imageProduct != null && imageProduct.getSize() > 0){
            try{
                File saveFile = new ClassPathResource("static/images").getFile();
                String newImageFile = UUID.randomUUID() + ".png";
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                editProduct.setImage(newImageFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        productService.add(editProduct);
        return "redirect:/products";
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("products", productService.getAll());
        return "products/index";
    }
}
