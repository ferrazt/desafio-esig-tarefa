package dev.jhoel.fiorese.esig.tarefa;

import dev.jhoel.fiorese.esig.tarefa.model.Tarefa;
import dev.jhoel.fiorese.esig.tarefa.repository.TarefaRepository;
import dev.jhoel.fiorese.esig.tarefa.service.TarefaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class TarefaServiceTest {

    @TestConfiguration
    static class TarefaServiceTestConfiguration{

        @Bean
        public TarefaService tarefaService(){
            return new TarefaService();
        }
    }

    @Autowired
    TarefaService tarefaService;

    @MockBean
    TarefaRepository tarefaRepository;

    @Test
    public void TarefaTestServiceFindTarefaNotEquals(){
        String descricao = "Teste Descrição";

        Optional<Tarefa> tarefa = tarefaService.findByDescription(descricao);

        Assertions.assertNotEquals(tarefa.map(Tarefa::getDescricao),descricao);
    }

    @Test
    public void UsuarioTestServiceFindUsuarioEquals(){
        Tarefa tarefa = new Tarefa();
        tarefa.setId(10);
        tarefa.setDescricao("Teste Descrição");

        Optional<Tarefa> tarefaTest = tarefaService.findByDescription(tarefa.getDescricao());

        Assertions.assertEquals(tarefaTest.map(Tarefa::getDescricao).get(), tarefa.getDescricao());
    }

    @Before
    public void setup(){
        Tarefa tarefa = new Tarefa();
        tarefa.setId(10);
        tarefa.setDescricao("Teste Descrição");

        Mockito.when(tarefaService.findByDescription(tarefa.getDescricao())).thenReturn(Optional.of(tarefa));
    }

}
