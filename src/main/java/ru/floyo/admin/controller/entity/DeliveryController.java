package ru.floyo.admin.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.floyo.admin.entity.Delivery;
import ru.floyo.admin.service.IDeliveryService;

import java.util.List;

@Controller
@RequestMapping("/admin/table/deliveries")
public class DeliveryController {

    private IDeliveryService deliveryService;
    public static final String baseURL = "/admin/table/deliveries";

    @Autowired
    public void setDeliveryService(IDeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<Delivery> items = deliveryService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/deliveries");
        modelAndView.addObject("deliveriesList", items);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getByID(@PathVariable("id") Integer id) {
        Delivery item = deliveryService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/delivery");
        modelAndView.addObject("delivery", item);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEditPage(@PathVariable("id") Integer id) {
        Delivery item = deliveryService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editDelivery");
        modelAndView.addObject("delivery", item);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("delivery") Delivery item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        deliveryService.edit(item);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editDelivery");
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("delivery") Delivery item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        deliveryService.add(item);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        Delivery item = deliveryService.getById(id);
        deliveryService.delete(item);
        return modelAndView;
    }
}
