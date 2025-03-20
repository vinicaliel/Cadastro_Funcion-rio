package me.dio.model;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity(name = "funcionarios")
public class Funcionario {

    private String nome;
    private String cargo;
    @Column(name = "salario", nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;


}
