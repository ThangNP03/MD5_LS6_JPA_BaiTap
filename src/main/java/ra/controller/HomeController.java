package ra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.Customer;
import ra.service.CustomerService;
import ra.service.ICustomerService;

import java.util.List;

@Controller
@RequestMapping({"/customerController","/"})
public class HomeController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping({"/list",""})
    public String list(Model model){
        List<Customer> list = customerService.findAll();
        model.addAttribute("list", list);
        return "index";
    }
}
