package com.example.SistemaEntrega.service;

import com.example.SistemaEntrega.model.FuncionarioModel;
import com.example.SistemaEntrega.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    //LISTAR FUNCIONÁRIO
    public List<FuncionarioModel> listarTodos(){
        return repository.findAll();
    }

    //SALVAR FUNCIONÁRIO
    public FuncionarioModel salvar(FuncionarioModel funcionario) {
        if (repository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new RuntimeException("Funcionário já cadastrado");
        }
        return repository.save(funcionario);
    }

    //ATUALIZAR FUNCIONÁRIO
    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioModel funcionario) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado");
        }
        funcionario.setId(id);
        return repository.save(funcionario);
    }

    //EXCLUIR FUNCIONÁRIO
    public void excluir(Long id){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário Não encontrado");
        }
        repository.deleteById(id);
    }

}

