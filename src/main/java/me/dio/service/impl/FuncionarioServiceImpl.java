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
        Funcionario funcionarioToFind = funcionarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return funcionarioToFind;

    }
    @Override
    public Funcionario create(Funcionario funcionarioToCreate) {
        
        Funcionario funcionarioCadastrado = funcionarioRepository.save(funcionarioToCreate);
    
        return funcionarioRepository.save(funcionarioCadastrado);
    }

    @Override
    public Funcionario Delete(Long id) {
        Funcionario funcionarioToDelete = funcionarioRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Funcionário não encontrado com o ID: " + id));
        funcionarioRepository.deleteById(id);
        return funcionarioToDelete;
    }
}
