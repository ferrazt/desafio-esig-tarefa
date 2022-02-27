package dev.jhoel.fiorese.esig.tarefa.service;


import dev.jhoel.fiorese.esig.tarefa.model.Tarefa;
import dev.jhoel.fiorese.esig.tarefa.model.Usuario;
import dev.jhoel.fiorese.esig.tarefa.model.enums.Prioridade;
import dev.jhoel.fiorese.esig.tarefa.repository.TarefaRepository;
import lombok.val;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }


    public long count(){
        return tarefaRepository
                .findAll().stream()
                .filter(tarefa -> tarefa.getId().equals(tarefa.getId()))
                .count();
    }

    public List<Tarefa> findAll(){
        return tarefaRepository
                .findAll().stream()
                .filter(tarefa -> tarefa.getId().equals(tarefa.getId()))
                .collect(Collectors.toList());
    }

    public Optional<Tarefa> findByDescription(String description) {
        return tarefaRepository.findAllByDescricao(description);
    }

    public List<Tarefa> findDone() {
        return new ArrayList<>(tarefaRepository
                .findAllByStatusTrue());
    }

    public List<Tarefa> findNotDone() {
        return new ArrayList<>(tarefaRepository
                .findAllByStatusFalse());
    }


    public List<Tarefa> searchAll(String titulo, String descricao, Usuario usuario, Prioridade prioridade, Date deadLine) {
        return  tarefaRepository.findAllByTituloOrDescricaoOrUsuarioOrPrioridadeOrDeadLine(titulo, descricao, usuario, prioridade, deadLine);
    }

    public void save(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    public void delete(Integer id) {
        tarefaRepository.deleteById(id);
    }

    public void toggleStatus(Integer id) {
        val optionalTarefa = tarefaRepository.findById(id);

        if (!optionalTarefa.isPresent()) {
            throw new RuntimeException("Entidade não encontrada");
        }

        optionalTarefa.ifPresent(tarefa -> {
            tarefa.setStatus(!tarefa.getStatus());
            save(tarefa);
        });
    }
}
