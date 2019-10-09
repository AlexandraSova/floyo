package ru.floyo.admin.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.floyo.admin.entity.Category;
import ru.floyo.admin.service.ICategoryService;

import java.util.List;

@Controller
@RequestMapping("/admin/table/categories")
public class CategoryController {

    private ICategoryService categoryService;
    public static final String baseURL = "/admin/table/categories";

    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<Category> items = categoryService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/categories");
        modelAndView.addObject("categoriesList", items);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getByID(@PathVariable("id") String id) {
        Category item = categoryService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/category");
        modelAndView.addObject("category", item);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEditPage(@PathVariable("id") String id) {
        Category item = categoryService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editCategory");
        modelAndView.addObject("category", item);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("category") Category item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        categoryService.edit(item);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editCategory");
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("category") Category item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        categoryService.add(item);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        Category item = categoryService.getById(id);
        categoryService.delete(item);
        return modelAndView;
    }
}
