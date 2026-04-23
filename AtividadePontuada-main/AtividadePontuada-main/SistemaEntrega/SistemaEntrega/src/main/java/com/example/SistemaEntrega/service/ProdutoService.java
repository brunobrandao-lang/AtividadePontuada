package com.example.SistemaEntrega.service;

import com.example.SistemaEntrega.model.ProdutoModel;
import com.example.SistemaEntrega.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    //LISTAR PRODUTO
    public List<ProdutoModel> listarTodos(){
        return repository.findAll();
    }

    //SALVAR PRODUTO
    public ProdutoModel salvar(ProdutoModel produto){
        if (repository.findByLote(produto.getLote()).isPresent()){
            throw new RuntimeException(("Produto já cadastrado"));
        }
        return repository.save(produto);
    }

    //ATUALIZAR PRODUTO
    public ProdutoModel atualizarProduto(Long id, ProdutoModel produto){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Produto não encontrado");
        }
        produto.setId(id);
        return repository.save(produto);
    }

    //EXCLUIR PRODUTO
    public void excluir(Long id){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto Não encontrado");
        }
        repository.deleteById(id);
    }
}
