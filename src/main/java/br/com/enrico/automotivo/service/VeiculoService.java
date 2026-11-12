package br.com.enrico.automotivo.service;
import br.com.enrico.automotivo.dto.VeiculoRequest;
import br.com.enrico.automotivo.model.*;
import br.com.enrico.automotivo.repository.*;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
@Service
public class VeiculoService {
 private final VeiculoRepository repo; private final ModeloRepository modelos;
 public VeiculoService(VeiculoRepository repo, ModeloRepository modelos){this.repo=repo;this.modelos=modelos;}
 public Veiculo criar(VeiculoRequest r){Veiculo v=new Veiculo(); aplicar(v,r); return repo.save(v);}
 public List<Veiculo> listar(){return repo.findAll();}
 public Veiculo buscar(Long id){return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Veículo não encontrado: "+id));}
 public Veiculo atualizar(Long id, VeiculoRequest r){Veiculo v=buscar(id); aplicar(v,r); return repo.save(v);}
 public void excluir(Long id){repo.delete(buscar(id));}
 public List<Veiculo> filtrar(String marca,String modelo,BigDecimal min,BigDecimal max,Integer ano,StatusVeiculo status){
  return repo.filtrar(vazio(marca),vazio(modelo),min,max,ano,status);
 }
 private void aplicar(Veiculo v,VeiculoRequest r){
  Modelo m=modelos.findById(r.modeloId()).orElseThrow(()->new IllegalArgumentException("Modelo não encontrado"));
  v.setModelo(m);v.setAno(r.ano());v.setCor(r.cor());v.setPreco(r.preco());v.setQuilometragem(r.quilometragem());v.setStatus(r.status());
 }
 private String vazio(String s){return s==null||s.isBlank()?null:s;}
}
