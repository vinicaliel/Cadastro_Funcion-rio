package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.model.Funcionario;
import me.dio.repository.FuncionarioRepository;
import me.dio.service.FuncionarioService;


@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    
    @Override
    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(NoSuchElementException::new);



    }
    @Override
    public Funcionario create(Funcionario funcionarioToCreate) {

    
        // Log para depuração
        System.out.println("Criando funcionário: " + funcionarioToCreate);
    
        return funcionarioRepository.save(funcionarioToCreate);
    }
}
