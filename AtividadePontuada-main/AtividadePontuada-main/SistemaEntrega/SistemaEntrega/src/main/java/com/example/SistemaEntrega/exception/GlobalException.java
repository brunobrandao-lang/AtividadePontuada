package com.example.SistemaEntrega.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(RuntimeException.class) //tratar erro ao tentar salvar algo q ja existe
    public ResponseEntity<Map<String, Object>> runtimeException(RuntimeException erro){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", erro.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class) //tratar erro ao enviar um dado inválido
    public ResponseEntity<Map<String, Object>> IllegalArgumentException(IllegalArgumentException erro) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem",erro.getMessage()));
    }
}
