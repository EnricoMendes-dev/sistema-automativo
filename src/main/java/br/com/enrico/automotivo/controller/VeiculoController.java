package br.com.enrico.automotivo.controller;
import br.com.enrico.automotivo.dto.VeiculoRequest; import br.com.enrico.automotivo.model.*;
import br.com.enrico.automotivo.service.VeiculoService;
import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal; import java.util.List;
@RestController @RequestMapping("/api/veiculos")
public class VeiculoController {
 private final VeiculoService service; public VeiculoController(VeiculoService s){service=s;}
 @PostMapping public Veiculo criar(@Valid @RequestBody VeiculoRequest r){return service.criar(r);}
 @GetMapping public List<Veiculo> listar(@RequestParam(required=false) String marca,@RequestParam(required=false) String modelo,
  @RequestParam(required=false) BigDecimal precoMin,@RequestParam(required=false) BigDecimal precoMax,
  @RequestParam(required=false) Integer ano,@RequestParam(required=false) StatusVeiculo status){
  if(marca==null&&modelo==null&&precoMin==null&&precoMax==null&&ano==null&&status==null)return service.listar();
  return service.filtrar(marca,modelo,precoMin,precoMax,ano,status);
 }
 @GetMapping("/{id}") public Veiculo buscar(@PathVariable Long id){return service.buscar(id);}
 @PutMapping("/{id}") public Veiculo atualizar(@PathVariable Long id,@Valid @RequestBody VeiculoRequest r){return service.atualizar(id,r);}
 @DeleteMapping("/{id}") public void excluir(@PathVariable Long id){service.excluir(id);}
}
