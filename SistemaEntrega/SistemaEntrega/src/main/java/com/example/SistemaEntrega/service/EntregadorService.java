package com.example.SistemaEntrega.service;

import com.example.SistemaEntrega.model.EntregadorModel;
import com.example.SistemaEntrega.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository repository;

    //LISTAR ENTREGADOR
    public List<EntregadorModel> listarTodos(){
        return repository.findAll();
    }

    //SALVAR ENTREGADOR
    public EntregadorModel salvar(EntregadorModel entregador){
        if (repository.findByEmail(entregador.getEmail()).isPresent()){
            throw new RuntimeException(("Entregador já cadastrado"));
        }
        return repository.save(entregador);
    }

    //ATUALIZAR ENTREGADOR
    public EntregadorModel atualizarEntregador(Long id, EntregadorModel entregador){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException(("Entregador não encontrado"));
        }
        entregador.setId(id);
        return repository.save(entregador);
    }

    //EXCLUIR ENTREGADOR
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entregador Não encontrado");
        }
        repository.deleteById(id);
    }
}
