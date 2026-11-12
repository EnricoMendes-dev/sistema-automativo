package br.com.enrico.automotivo.repository;
import br.com.enrico.automotivo.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MarcaRepository extends JpaRepository<Marca,Long> { boolean existsByNomeIgnoreCase(String nome); }
