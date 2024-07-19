package com.ntndev.tmdtbasic.controller.admin;

import com.ntndev.tmdtbasic.model.Category;
import com.ntndev.tmdtbasic.model.Product;
import com.ntndev.tmdtbasic.services.CategoryService;
import com.ntndev.tmdtbasic.services.ProductService;
import com.ntndev.tmdtbasic.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ProductService productService;


    @RequestMapping("/product")
    public String index(Model model){
        List<Product> listProduct = productService.getAll();

        System.out.println(listProduct);

        model.addAttribute("listProduct",listProduct);
        return "admin/product/index";
    }

    @RequestMapping("/product-add")
    public String add(Model model){

        Product product = new Product();
        model.addAttribute("product",product);

        List<Category> listCate = categoryService.getAll();
        model.addAttribute("listCate", listCate);

        return "admin/product/add";
    }



    @PostMapping("/product-add")
    public String save(@ModelAttribute("product") Product product,@RequestParam("fileImage") MultipartFile file){

            // upload file
        storageService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImage(fileName);
        if(productService.create(product)){
            return "redirect:/admin/product";
        }
        return "admin/product/add";


    }


    @GetMapping("/edit-product/{id}")
    public String edit(Model model, @PathVariable Integer id){
        Product product = productService.findById(id);

        model.addAttribute("product", product);
        List<Category> listCate = categoryService.getAll();
        model.addAttribute("listCate", listCate);

        return "admin/product/edit";
    }


    @PostMapping("/edit-product")
    public String update(@ModelAttribute("product") Product product,@RequestParam("fileImage") MultipartFile file){

        String fileName = file.getOriginalFilename();
        boolean isEmpty = fileName == null || fileName.trim().length() == 0;
        if(!isEmpty){
            storageService.store(file);
            product.setImage(fileName);
        }

        if(productService.update(product)){
            return "redirect:/admin/product";
        }
        return "admin/product/edit";
    }

    //Delete

    @GetMapping("detele-product/{id}")
    public String delete(@PathVariable Integer id){
        if(productService.delete(id)){

            return "redirect:/admin/product";
        }else {
            return "redirect:/admin/product";
        }
    }
}
