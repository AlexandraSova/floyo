package ru.floyo.admin.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.floyo.admin.entity.Order;
import ru.floyo.admin.entity.OrderLine;
import ru.floyo.admin.entity.Product;
import ru.floyo.admin.service.IOrderService;
import ru.floyo.admin.service.IOrderLineService;
import ru.floyo.admin.service.IProductService;

import java.util.List;

@Controller
@RequestMapping("/admin/table/orderlines")
public class OrderLineController {

    private IOrderLineService orderLineService;
    private IProductService productService;
    private IOrderService orderService;
    public static final String baseURL = "/admin/table/orderlines";

    @Autowired
    public void setOrderLineService(IOrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<OrderLine> items = orderLineService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/orderlines");
        modelAndView.addObject("orderlinesList", items);
        modelAndView.addObject("baseOrderURL", OrderController.baseURL);
        modelAndView.addObject("baseProductURL", ProductController.baseURL);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getByID(@PathVariable("id") Integer id) {
        OrderLine item = orderLineService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/orderline");
        modelAndView.addObject("orderline", item);
        modelAndView.addObject("baseURL", baseURL);
        modelAndView.addObject("baseOrderURL", OrderController.baseURL);
        modelAndView.addObject("baseProductURL", ProductController.baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEditPage(@PathVariable("id") Integer id) {
        OrderLine item = orderLineService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editOrderLine");
        modelAndView.addObject("orderline", item);
        List<Product> productEntities = productService.getAll();
        modelAndView.addObject("productsList", productEntities);
        List<Order> orderEntities = orderService.getAll();
        modelAndView.addObject("ordersList", orderEntities);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("orderline") OrderLine item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        orderLineService.edit(item);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editOrderLine");
        List<Product> productEntities = productService.getAll();
        modelAndView.addObject("productsList", productEntities);
        List<Order> orderEntities = orderService.getAll();
        modelAndView.addObject("ordersList", orderEntities);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("orderline") OrderLine item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        orderLineService.add(item);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        OrderLine item = orderLineService.getById(id);
        orderLineService.delete(item);
        return modelAndView;
    }
}
