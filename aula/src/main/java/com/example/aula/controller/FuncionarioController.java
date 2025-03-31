package com.example.aula.controller;

import com.example.aula.model.Funcionario;
import com.example.aula.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")


public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario){
        funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

    @PutMapping
    public ResponseEntity<Funcionario> atualizar(@RequestBody Funcionario funcionario){
       if (funcionarioRepository.existsById(funcionario.getId())){
           funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (funcionarioRepository.existsById(id)){
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }



}
