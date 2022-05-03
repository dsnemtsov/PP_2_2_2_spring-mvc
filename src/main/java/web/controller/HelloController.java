package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class HelloController {

    private final CarService carService;

    public HelloController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(required = false) String count, Model model) {

        if (count == null) {
            model.addAttribute("cars", carService.findAll());
        } else {
            model.addAttribute("cars", carService.findByCount(Integer.parseInt(count)));
        }
        return "cars";
    }

}