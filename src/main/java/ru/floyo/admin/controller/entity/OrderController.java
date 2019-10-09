package ru.floyo.admin.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.floyo.admin.entity.Client;
import ru.floyo.admin.entity.Delivery;
import ru.floyo.admin.entity.Order;
import ru.floyo.admin.entity.OrderStatus;
import ru.floyo.admin.service.IClientService;
import ru.floyo.admin.service.IDeliveryService;
import ru.floyo.admin.service.IOrderService;
import ru.floyo.admin.service.IOrderStatusService;

import java.util.List;

@Controller
@RequestMapping("/admin/table/orders")
public class OrderController {

    private IOrderService orderService;
    private IClientService clientService;
    private IDeliveryService deliveryService;
    private IOrderStatusService statusService;

    public static final String baseURL = "/admin/table/orders";

    @Autowired
    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }
    @Autowired
    public void setClientService(IClientService clientService) {
        this.clientService = clientService;
    }
    @Autowired
    public void setDeliveryService(IDeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }
    @Autowired
    public void setStatusService(IOrderStatusService statusService) {
        this.statusService = statusService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<Order> items = orderService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/orders");
        modelAndView.addObject("ordersList", items);
        modelAndView.addObject("baseURL", baseURL);
        modelAndView.addObject("baseProductURL", ProductController.baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getByID(@PathVariable("id") Integer id) {
        Order item = orderService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/entity/order");
        modelAndView.addObject("order", item);
        modelAndView.addObject("baseURL", baseURL);
        modelAndView.addObject("baseProductURL", ProductController.baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEditPage(@PathVariable("id") Integer id) {
        Order item = orderService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editOrder");
        List<Client> clients = clientService.getAll();
        modelAndView.addObject("clientsList", clients);
        List<Delivery> deliveries = deliveryService.getAll();
        modelAndView.addObject("deliveriesList", deliveries);
        List<OrderStatus> orderStatuses = statusService.getAll();
        modelAndView.addObject("statusesList", orderStatuses);
        modelAndView.addObject("order", item);
        modelAndView.addObject("baseURL", baseURL);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("order") Order item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        orderService.edit(item);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/table/editOrder");
        modelAndView.addObject("baseURL", baseURL);
        List<Client> clients = clientService.getAll();
        modelAndView.addObject("clientsList", clients);
        List<Delivery> deliveries = deliveryService.getAll();
        modelAndView.addObject("deliveriesList", deliveries);
        List<OrderStatus> orderStatuses = statusService.getAll();
        modelAndView.addObject("statusesList", orderStatuses);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("order") Order item) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        orderService.add(item);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + baseURL);
        Order item = orderService.getById(id);
        orderService.delete(item);
        return modelAndView;
    }
}
