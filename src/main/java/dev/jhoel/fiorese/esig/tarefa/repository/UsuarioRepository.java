package dev.jhoel.fiorese.esig.tarefa.repository;

import dev.jhoel.fiorese.esig.tarefa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNome(String nome);
}
