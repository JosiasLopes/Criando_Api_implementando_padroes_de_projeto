package com.padroesdeprojetos.designPatterns.service;

import com.padroesdeprojetos.designPatterns.model.Cliente;
import org.springframework.stereotype.Service;


public interface ClienteService{

    Iterable buscaTodos();
    Cliente buscaporId(Long id);
    void inserir(Cliente cliente);
    void deletar(Long id);
    void update(Long id, Cliente cliente);
}
