package com.example.SistemaEntrega.service;

import com.example.SistemaEntrega.model.ClienteModel;
import com.example.SistemaEntrega.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    //LISTAR CLIENTE
    public List<ClienteModel> listarTodos(){
        return repository.findAll();
    }

    //SALVAR CLIENTE
    public ClienteModel salvar(ClienteModel cliente){
        if (repository.findByEmail(cliente.getEmail()).isPresent()){
            throw new RuntimeException(("CLiente já cadastrado"));
        }
        return repository.save(cliente);
    }

    //ATUALIZAR CLIENTE
    public ClienteModel atualizarCliente(Long id, ClienteModel cliente){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException(("Cliente não encontrado"));
        }
        cliente.setId(id);
        return repository.save(cliente);
    }

    //EXCLUIR CLIENTE
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente Não encontrado");
        }
        repository.deleteById(id);
    }
}
