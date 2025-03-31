package com.example.aula.controller;


import com.example.aula.model.Endereco;
import com.example.aula.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private final EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping
    public List<Endereco> listarTodos(){
        return enderecoRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco){
        enderecoRepository.save(endereco);
        return ResponseEntity.ok(endereco);
    }
    @PutMapping
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco){
        if (enderecoRepository.existsById(endereco.getId())){
            enderecoRepository.save(endereco);
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (enderecoRepository.existsById(id)){
            enderecoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
