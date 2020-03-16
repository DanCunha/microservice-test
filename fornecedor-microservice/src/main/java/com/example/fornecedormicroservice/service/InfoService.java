package com.example.fornecedormicroservice.service;

import com.example.fornecedormicroservice.model.InfoFornecedor;
import com.example.fornecedormicroservice.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoFornecedor getInfoPorEstado(String estado){
        return infoRepository.findByEstado(estado);
    }
}
