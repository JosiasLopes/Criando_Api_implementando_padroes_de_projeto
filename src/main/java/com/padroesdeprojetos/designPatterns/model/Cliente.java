package com.padroesdeprojetos.designPatterns.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private String nome;

    @ManyToOne  //um cliente tem um endereço, e um endereço pode ser usado em mais de cliente
    private Endereco endereco;
}
