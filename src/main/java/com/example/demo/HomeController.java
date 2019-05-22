package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/")
    public String HomePage(Model model) {

        model.addAttribute("customers", customerRepository.findAll());
        return "index";

    }


    @RequestMapping("/search")
    public String loadFormPage(@RequestParam("lastname") String lastName,
    Model model){
        model.addAttribute("customers", customerRepository.findAllByLastNameContainingIgnoreCase(lastName));
        return "customer";

//        String lastName = "Smith%";
//        ArrayList<Customer> results =(ArrayList<Customer>)
//                customerRepository.findAllByLastNameContainingIgnoreCase(lastName);
//
//        long stateId = 2;
//        long total = customerRepository.countByStateID(stateId);
//
//        model.addAttribute("state",stateId);
//        model.addAttribute("total",total);
//        model.addAttribute("results", results);
//        return "index";
    }
}
