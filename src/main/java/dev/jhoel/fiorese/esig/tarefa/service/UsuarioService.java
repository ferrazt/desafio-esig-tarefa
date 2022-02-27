package dev.jhoel.fiorese.esig.tarefa.service;


import dev.jhoel.fiorese.esig.tarefa.model.Usuario;
import dev.jhoel.fiorese.esig.tarefa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public long count(){
        return usuarioRepository
                .findAll().stream()
                .filter(usu -> usu.getId().equals(usu.getId()))
                .count();
    }


    public List<Usuario> findAll(){
        return usuarioRepository
                .findAll().stream()
                .filter(usuario -> usuario.getId().equals(usuario.getId()))
                .collect(Collectors.toList());
    }


    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public void save(Usuario usuario) {
        usuario.setId(null);
        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findByNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }
}
