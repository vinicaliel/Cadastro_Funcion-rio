package me.dio.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.model.Funcionario;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {



}
