package com.example.lojamicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.lojamicroservice.dto.CompraDTO;
import com.example.lojamicroservice.model.Compra;
import com.example.lojamicroservice.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @RequestMapping(method = RequestMethod.POST)
    public Compra realizaCompra(@RequestBody CompraDTO compra){
        return compraService.realizaCompra(compra);
    }
}
