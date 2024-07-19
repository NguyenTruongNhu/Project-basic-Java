package com.ntndev.tmdtbasic.controller.admin;

import com.ntndev.tmdtbasic.model.Category;
import com.ntndev.tmdtbasic.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/category")
    public String index(Model model, @Param("keyword") String keyword, @RequestParam(name = "pageNo" , defaultValue = "1") Integer pageNo){


        Page<Category> list = categoryService.getAll(pageNo);


        if(keyword != null){
            list = categoryService.searchCategory(keyword, pageNo);
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage",pageNo);

        model.addAttribute("list", list);
    return "admin/category/index";
    }



   @GetMapping("/add-category")

   public String add(Model model){
        Category category = new Category();
        category.setCategoryStatus(true);
        model.addAttribute("category", category);
       return "admin/category/add";
   }

   //add
   @PostMapping("/add-category")
   public String save(@ModelAttribute("category") Category category){
        if(categoryService.create(category)){

            return "redirect:/admin/category";
        }else {
            return "admin/category/add";
        }
   }

   //
    @GetMapping("/edit-category/{id}")
    public String edit(Model model, @PathVariable Integer id){
        Category category = categoryService.findById(id);

        model.addAttribute("category", category);

        return "admin/category/edit";
    }

    @PostMapping("/edit-category")
    public String update(@ModelAttribute("category") Category category){
        if(categoryService.update(category)){

            return "redirect:/admin/category";
        }else {
            return "admin/category/edit";
        }
    }

    //Delete

    @GetMapping("detele-category/{id}")
    public String delete(@PathVariable Integer id){
        if(categoryService.delete(id)){

            return "redirect:/admin/category";
        }else {
            return "redirect:/admin/category";
        }
    }
}
