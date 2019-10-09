package ru.floyo.admin.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.floyo.admin.entity.Size;
import ru.floyo.admin.service.ISizeService;

import java.util.List;

@Controller
@RequestMapping("/admin/table/sizes")
public class SizeController {

    private ISizeService sizeService;
    public static final String baseURL = "/admin/table/sizes";

    @Autowired
    public void setSizeService(ISizeService sizeService) {
        this.sizeService = sizeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<Size> items = sizeService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/sizes");
        modelAndView.addObject("sizesList", items);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getByID(@PathVariable("id") String id) {
        Size item = sizeService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/size");
        modelAndView.addObject("size", item);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEditPage(@PathVariable("id") String id) {
        Size item = sizeService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editSize");
        modelAndView.addObject("size", item);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("size") Size item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        sizeService.edit(item);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editSize");
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("size") Size item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        sizeService.add(item);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        Size item = sizeService.getById(id);
        sizeService.delete(item);
        return modelAndView;
    }
}
