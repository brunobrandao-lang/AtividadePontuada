package com.example.SistemaEntrega.controller;

import com.example.SistemaEntrega.model.ClienteModel;
import com.example.SistemaEntrega.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteModel> listar(){
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ClienteModel cliente){
        service.salvar(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cliente salvo com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>>atualizar(
            @PathVariable Long id,
            @RequestBody ClienteModel cliente){
        service.atualizarCliente(id, cliente);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "CLiente exlucuido com sucesso"));
    }
}
