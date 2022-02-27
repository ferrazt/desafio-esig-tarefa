package dev.jhoel.fiorese.esig.tarefa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 150)
    private String nome;

}
