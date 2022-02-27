package dev.jhoel.fiorese.esig.tarefa.controller;


import dev.jhoel.fiorese.esig.tarefa.model.Tarefa;
import dev.jhoel.fiorese.esig.tarefa.model.Usuario;
import dev.jhoel.fiorese.esig.tarefa.model.enums.Prioridade;
import dev.jhoel.fiorese.esig.tarefa.service.TarefaService;
import dev.jhoel.fiorese.esig.tarefa.service.UsuarioService;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Getter
@Setter
@Scope("view")
public class TarefaController{

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private UsuarioService usuarioService;

    private Tarefa tarefa, selected;

    private String data;

    private List<Tarefa> tarefas;

    private long tarefaCount, doneTarefasCount, pendingTarefasCount;

    private String filterText = "Pendentes";

    Boolean filter = false;

    @PostConstruct
    public void init() {
        tarefas = new ArrayList<>();
        tarefa = new Tarefa();
        tarefa.setUsuario(new Usuario());
        loadData();
    }


    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }

    private void loadData() {
        tarefaCount = tarefaService.count();
        tarefas =  Optional
                .ofNullable(getFilter())
                .map(filter -> filter  ? tarefaService.findDone() : tarefaService.findNotDone())
                .orElse(tarefaService.findAll());
    }

    public Boolean hasTarefas() {
        return !tarefas.isEmpty();
    }

    public void toggleDoneFilter() {
        filter = true;
        filterText = "Concluídos";
        loadData();
    }
    public void toggleAllFilter() {
        filter = null;
        filterText = "Todos";
        loadData();
    }

    public void togglePendingFilter() {
        filter = false;
        filterText = "Pendentes";
        loadData();

    }

    public void delete(Tarefa tarefa) {
        tarefaService.delete(tarefa.getId());
        loadData();
    }

    public Boolean isEditing(Tarefa tarefa) {
        return selected != null && selected.equals(tarefa);
    }

    public void cancelEdit() {
        selected = null;
    }

    public void save(Tarefa tarefa) throws Exception {
        val usuario = usuarioService
                .findByNome(tarefa.getUsuario().getNome())
                .orElseThrow(() -> new Exception("erro ao procurar usuario"));
        tarefa.setUsuario(usuario);
        tarefaService.save(tarefa);
        selected = null;

        loadData();
    }


    public void create() throws Exception {
        tarefa.setStatus(false);
        if(data == null){
            tarefa.setDeadLine(new Date());
        }
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        tarefa.setDeadLine(date1);

        val usuario = usuarioService
                .findByNome(tarefa.getUsuario().getNome())
                .orElseThrow(() -> new Exception("erro ao procurar usuario"));
        tarefa.setUsuario(usuario);
       tarefaService.save(tarefa);
        clearTarefa();
        loadData();
    }

    public void buscar() throws Exception {
        tarefa.setStatus(false);
        if(data.isEmpty()){
            tarefa.setDeadLine(null);
        } else {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            tarefa.setDeadLine(date1);
        }

        val usuario = usuarioService
                .findByNome(tarefa.getUsuario().getNome())
                .orElse(null);
        tarefas =  tarefaService.searchAll(tarefa.getTitulo(), tarefa.getDescricao(), usuario, tarefa.getPrioridade(), tarefa.getDeadLine());

        if(tarefas.isEmpty()){
            loadData();
        }
    }

    public void clearTarefa() {
        tarefa = new Tarefa();
        tarefa.setUsuario(new Usuario());
        data = null;
    }
}
