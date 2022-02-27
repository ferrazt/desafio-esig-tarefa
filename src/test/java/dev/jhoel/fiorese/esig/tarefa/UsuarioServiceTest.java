package dev.jhoel.fiorese.esig.tarefa;

import dev.jhoel.fiorese.esig.tarefa.model.Usuario;
import dev.jhoel.fiorese.esig.tarefa.repository.UsuarioRepository;
import dev.jhoel.fiorese.esig.tarefa.service.UsuarioService;
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
public class UsuarioServiceTest {

    @TestConfiguration
    static class UsuarioServiceTestConfiguration{

        @Bean
        public UsuarioService usuarioService(){
            return new UsuarioService();
        }
    }

    @Autowired
    UsuarioService usuarioService;
    @MockBean
    UsuarioRepository usuarioRepository;

    @Test
    public void UsuarioTestServiceFindUsuarioNotEquals(){
        String name = "Jhoel Fiorese";

        Optional<Usuario> usuario = usuarioService.findByNome(name);

        Assertions.assertNotEquals(usuario.map(Usuario::getNome),name);
    }

    @Test
    public void UsuarioTestServiceFindUsuarioEquals(){
        Usuario usuarioTest = new Usuario();
        usuarioTest.setId(33);
        usuarioTest.setNome("Jhoel Fiorese");

        Optional<Usuario> usuario = usuarioService.findByNome(usuarioTest.getNome());

        Assertions.assertEquals(usuario.map(Usuario::getNome).get(), usuarioTest.getNome());
    }

    @Before
    public void setup(){
         Usuario usuario = new Usuario();
         usuario.setId(33);
         usuario.setNome("Jhoel Fiorese");

        Mockito.when(usuarioRepository.findByNome(usuario.getNome())).thenReturn(Optional.of(usuario));
    }

}
