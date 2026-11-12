package br.com.enrico.automotivo.repository;
import br.com.enrico.automotivo.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ModeloRepository extends JpaRepository<Modelo,Long> { boolean existsByNomeIgnoreCaseAndMarcaId(String nome, Long marcaId); }
