package com.example.aula.repository;

import com.example.aula.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long>{
}
