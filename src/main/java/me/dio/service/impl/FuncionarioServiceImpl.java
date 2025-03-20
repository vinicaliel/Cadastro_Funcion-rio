package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.model.Funcionario;
import me.dio.repository.FuncionarioRepository;
import me.dio.service.FuncionarioService;


@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    

    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(NoSuchElementException::new);



    }

    public Funcionario create(Funcionario funcionarioToCreate) {
        if(funcionarioToCreate.getId() !=null){
            throw new IllegalArgumentException("O id do funcionário não deve ser informado.");
        }
        return funcionarioRepository.save(funcionarioToCreate);
    }
}
