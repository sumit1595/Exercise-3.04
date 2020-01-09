package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CarsController {
    @Autowired
    CarsRepository carsRepository;
    @RequestMapping("/")
    public String listCars(Model model){
        model.addAttribute("cars", carsRepository.findAll());
        return "carslist";
    }
    @GetMapping("/add")
    public String carsForm(Model model){
        model.addAttribute("cars", new Cars());
        return "carsform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Cars cars, BindingResult result) {
        if (result.hasErrors()) {
            return "carsform";
        }
        carsRepository.save(cars);
        return "redirect:/";
    }
    @RequestMapping("/detail/{id}")
    public String carsdetailCars(@PathVariable("id") long id, Model model){
        model.addAttribute("cars", carsRepository.findById(id).get());
        return "carsdetail";
    }
    @RequestMapping("/update/{id}")
    public String updateCars(@PathVariable("id") long id, Model model){
        model.addAttribute("cars", carsRepository.findById(id).get());
        return "carsform";
    }
    @RequestMapping("/delete/{id}")
    public String delCars(@PathVariable("id") long id){
        carsRepository.deleteById(id);
        return "redirect:/";
    }
}
