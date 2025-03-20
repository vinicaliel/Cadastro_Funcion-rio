package me.dio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.model.Funcionario;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {



}
