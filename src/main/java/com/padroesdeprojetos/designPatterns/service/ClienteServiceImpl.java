package com.padroesdeprojetos.designPatterns.service;

import com.padroesdeprojetos.designPatterns.exceptions.ClienteNotFoundException;
import com.padroesdeprojetos.designPatterns.model.Cliente;
import com.padroesdeprojetos.designPatterns.model.Endereco;
import com.padroesdeprojetos.designPatterns.repository.ClienteRepository;
import com.padroesdeprojetos.designPatterns.repository.EnderecoRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository cltRepo;

    @Autowired
    private EnderecoRepository endRepo;

    @Autowired
    private ViaCepService cepService;

    @Override
    public Iterable buscaTodos() {
        return cltRepo.findAll();

    }

    @Override
    public Cliente buscaporId(Long id) {
        Optional<Cliente> opt = cltRepo.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new ClienteNotFoundException(id);
        }
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarComCep(cliente);
    }

    private void salvarComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Optional<Endereco> opt = Optional.of(endRepo.findById(cep).orElseGet(() -> {
            Endereco novo = cepService.consultarCep(cep);
            endRepo.save(novo);
            return novo;
        }));
        cliente.setEndereco(opt.get());
        cltRepo.save(cliente);
    }


    @Override
    public void deletar(Long id) {
         cltRepo.deleteById(id);
    }

    @Override
    public void update(Long id, Cliente cliente) {
        Optional<Cliente> opt = cltRepo.findById(id);
        if(opt.isPresent()){
          salvarComCep(cliente);
        }
    }
}
