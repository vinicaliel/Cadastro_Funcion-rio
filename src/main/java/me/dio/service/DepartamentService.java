package me.dio.service;

import me.dio.model.Departamento;

public interface DepartamentService {

    Departamento findById(Long id);

    Departamento create(Departamento departamentToCreate);

    Departamento Delete(Long id);

    Departamento Update(Long id, Departamento departamentToUpdate);

}
