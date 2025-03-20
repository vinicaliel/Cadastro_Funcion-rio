package me.dio.service;
import me.dio.model.Funcionario;



public interface FuncionarioService {

Funcionario findById(Long id);

Funcionario create(Funcionario funcionarioToCreate);

Funcionario Delete(Long id);


}
