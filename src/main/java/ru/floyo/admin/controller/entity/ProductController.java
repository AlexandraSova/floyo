package ru.floyo.admin.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.floyo.admin.entity.*;
import ru.floyo.admin.service.ICategoryService;
import ru.floyo.admin.service.ICollectionService;
import ru.floyo.admin.service.IProductService;
import ru.floyo.admin.service.ISizeService;

import java.util.List;

@Controller
@RequestMapping("/admin/table/products")
public class ProductController {

    private IProductService productService;
    private ICategoryService categoryService;
    private ICollectionService collectionService;
    private ISizeService sizeService;
    public static final String baseURL = "/admin/table/products";

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setCollectionService(ICollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @Autowired
    public void setSizeService(ISizeService sizeService) {
        this.sizeService = sizeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<Product> items = productService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/products");
        modelAndView.addObject("productsList", items);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getByID(@PathVariable("id") Integer id) {
        Product item = productService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/product");
        modelAndView.addObject("product", item);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEditPage(@PathVariable("id") Integer id) {
        Product item = productService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categoryEntities = categoryService.getAll();
        List<Collection> collectionEntities = collectionService.getAll();
        List<Size> sizeEntities = sizeService.getAll();
        modelAndView.addObject("categoriesList", categoryEntities);
        modelAndView.addObject("collectionsList", collectionEntities);
        modelAndView.addObject("sizesList", sizeEntities);
        modelAndView.setViewName("admin/table/editProduct");
        modelAndView.addObject("product", item);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("product") Product item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        productService.edit(item);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editProduct");
        List<Category> categoryEntities = categoryService.getAll();
        List<Collection> collectionEntities = collectionService.getAll();
        List<Size> sizeEntities = sizeService.getAll();
        modelAndView.addObject("categoriesList", categoryEntities);
        modelAndView.addObject("collectionsList", collectionEntities);
        modelAndView.addObject("sizesList", sizeEntities);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("product") Product item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        productService.add(item);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        Product item = productService.getById(id);
        productService.delete(item);
        return modelAndView;
    }
}
