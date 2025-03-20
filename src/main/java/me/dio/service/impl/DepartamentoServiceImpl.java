package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.model.Departamento;
import me.dio.repository.DepartamentRepository;
import me.dio.service.DepartamentService;



@Service
public class DepartamentoServiceImpl implements DepartamentService {

    private final DepartamentRepository departamentRepository;

    public DepartamentoServiceImpl(DepartamentRepository departamentRepository) {
        this.departamentRepository = departamentRepository;
    }
    
    @Override
    public Departamento findById(Long id) {
        return departamentRepository.findById(id).orElseThrow(NoSuchElementException::new);



    }
    @Override
    public Departamento create(Departamento departamentToCreate) {

    
        // Log para depuração
        System.out.println("Criando funcionário: " + departamentToCreate);
    
        return departamentRepository.save(departamentToCreate);
    }

    @Override
    public Departamento Delete(Long id) {
        Departamento DepartamentoToDelete = departamentRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Departamento não encontrado com o ID: " + id));
            departamentRepository.deleteById(id);
        return DepartamentoToDelete;
    }
}