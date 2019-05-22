package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/")
    public String index(Model model){

        String lastName = "Smith%";
        ArrayList<Customer> results =(ArrayList<Customer>)
                customerRepository.findAllByLastNameContainingIgnoreCase(lastName);

        long stateId = 2;
        long total = customerRepository.countByStateID(stateId);

        model.addAttribute("state",stateId);
        model.addAttribute("total",total);
        model.addAttribute("results", results);
        return "index";
    }
}
