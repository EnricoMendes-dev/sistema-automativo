package br.com.enrico.automotivo.controller;
import br.com.enrico.automotivo.model.Marca; import br.com.enrico.automotivo.repository.MarcaRepository;
import jakarta.validation.Valid; import jakarta.validation.constraints.NotBlank; import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/marcas")
public class MarcaController {
 private final MarcaRepository repo; public MarcaController(MarcaRepository r){repo=r;}
 public record Entrada(@NotBlank String nome){}
 @GetMapping public List<Marca> listar(){return repo.findAll();}
 @PostMapping public Marca criar(@Valid @RequestBody Entrada e){if(repo.existsByNomeIgnoreCase(e.nome()))throw new IllegalArgumentException("Marca já cadastrada");return repo.save(new Marca(e.nome()));}
 @DeleteMapping("/{id}") public void excluir(@PathVariable Long id){repo.deleteById(id);}
}
