package com.padroesdeprojetos.designPatterns.controller;

import com.padroesdeprojetos.designPatterns.model.Cliente;
import com.padroesdeprojetos.designPatterns.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscaTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarporId(@PathVariable("id") Long id){
        return ResponseEntity.ok(clienteService.buscaporId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> buscarporId(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id,@RequestBody Cliente cliente){

        clienteService.update(id,cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){

        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
