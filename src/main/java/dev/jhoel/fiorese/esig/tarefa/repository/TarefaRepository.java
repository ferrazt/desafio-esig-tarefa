package dev.jhoel.fiorese.esig.tarefa.repository;

import dev.jhoel.fiorese.esig.tarefa.model.Tarefa;
import dev.jhoel.fiorese.esig.tarefa.model.Usuario;
import dev.jhoel.fiorese.esig.tarefa.model.enums.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaRepository  extends JpaRepository<Tarefa, Integer> {

    Optional<Tarefa> findAllByDescricao(String descrption);


    List<Tarefa> findAllByStatusTrue();

    List<Tarefa> findAllByStatusFalse();

    List<Tarefa> findAllByTituloOrDescricaoOrUsuarioOrPrioridadeOrDeadLine(String titulo, String descricao, Usuario usuario, Prioridade prioridade, Date deadLine);
}

