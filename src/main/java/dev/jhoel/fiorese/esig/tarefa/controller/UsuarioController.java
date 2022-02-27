package dev.jhoel.fiorese.esig.tarefa.controller;

import dev.jhoel.fiorese.esig.tarefa.model.Usuario;
import dev.jhoel.fiorese.esig.tarefa.service.UsuarioService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Getter
@Setter
@Scope("Userview")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private Usuario usuario;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public void create(){
       // System.out.println("criar");
        usuarioService.save(usuario);
        clearUsuario();
    }
    public void clearUsuario(){usuario = new Usuario();}


    public List<SelectItem> getUsuarios() {
        return usuarioService.findAll().stream()
                .map(usr -> new SelectItem(usr.getNome(), usr.getNome()))
                .distinct()
                .collect(Collectors.toList());
    }
}
