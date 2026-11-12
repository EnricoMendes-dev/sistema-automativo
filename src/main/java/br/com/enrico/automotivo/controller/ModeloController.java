package br.com.enrico.automotivo.controller;
import br.com.enrico.automotivo.model.*; import br.com.enrico.automotivo.repository.*;
import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/modelos")
public class ModeloController {
 private final ModeloRepository repo; private final MarcaRepository marcas;
 public ModeloController(ModeloRepository r,MarcaRepository m){repo=r;marcas=m;}
 public record Entrada(@NotBlank String nome,@NotNull Long marcaId){}
 @GetMapping public List<Modelo> listar(){return repo.findAll();}
 @PostMapping public Modelo criar(@Valid @RequestBody Entrada e){
  Marca marca=marcas.findById(e.marcaId()).orElseThrow(()->new IllegalArgumentException("Marca não encontrada"));
  if(repo.existsByNomeIgnoreCaseAndMarcaId(e.nome(),e.marcaId()))throw new IllegalArgumentException("Modelo já cadastrado para esta marca");
  return repo.save(new Modelo(e.nome(),marca));
 }
 @DeleteMapping("/{id}") public void excluir(@PathVariable Long id){repo.deleteById(id);}
}
