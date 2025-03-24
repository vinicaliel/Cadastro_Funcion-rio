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

  
        System.out.println("Criando Departamento: " + departamentToCreate);
    
        return departamentRepository.save(departamentToCreate);
    }

    @Override
    public Departamento Delete(Long id) {
        Departamento DepartamentoToDelete = departamentRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Departamento não encontrado com o ID: " + id));
            departamentRepository.deleteById(id);
        return DepartamentoToDelete;
    }

    @Override
    public Departamento Update(Long id, Departamento departamentToUpdate) {
        Departamento existingDepartamento = departamentRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Departamento não encontrado com o ID: " + id));
        
        existingDepartamento.setNome(departamentToUpdate.getNome());
        
        // Add other fields to update as needed

        return departamentRepository.save(existingDepartamento);
    }
}