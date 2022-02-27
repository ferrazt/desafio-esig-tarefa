package dev.jhoel.fiorese.esig.tarefa.model;

import dev.jhoel.fiorese.esig.tarefa.model.enums.Prioridade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tarefa")
public class Tarefa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarefa_id")
    private Integer id;

    @Column(name = "titulo", length = 100)
    private String titulo;

    @Column(name = "descricao", length = 150)
    private String descricao;

    @Column(name = "deadLine")
    @Temporal(TemporalType.DATE)
    private Date deadLine;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "prioridade")
    private Prioridade prioridade;
}
