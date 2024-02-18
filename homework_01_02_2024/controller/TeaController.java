package com.telran.org.tea.homework_01_02_2024.controller;

import java.util.ArrayList;
import java.util.List;


import com.telran.org.tea.homework_01_02_2024.model.Tea;
import org.springframework.web.bind.annotation.*;


//GET, POST, PUT, PATCH, DELETE
//http://localhost:8080  / GET
@RestController
@RequestMapping("/tea")   // //http://localhost:8080/tea
public class TeaController {

    private List<Tea> teaList = new ArrayList<>();

    public TeaController() {
        init();
    }

    @GetMapping
    public Iterable<Tea> getTea() {
        return teaList;
    }

    //http://localhost:8080/tea/rwerwr-treter-ter-te
    @GetMapping("/{id}")
    public Tea getTeaById(@PathVariable String id) {
        for (Tea tea : teaList) {
            if (tea.getId().equals(id)) {
                return tea;
            }
        }

        return null;
    }

    @PostMapping
    public Tea addTea(@RequestBody Tea tea) {
        teaList.add(tea);
        return tea;
    }

    private void init() {
        List<Tea> teas = List.of(
                new Tea("Black"),
                new Tea("Green"),
                new Tea("Chamomile"));

        teaList.addAll(teas);
    }
}