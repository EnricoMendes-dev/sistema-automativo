package br.com.enrico.automotivo.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="veiculos")
public class Veiculo {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="modelo_id") private Modelo modelo;
 @Column(nullable=false) private Integer ano;
 @Column(nullable=false, length=40) private String cor;
 @Column(nullable=false, precision=12, scale=2) private BigDecimal preco;
 @Column(nullable=false) private Integer quilometragem;
 @Enumerated(EnumType.STRING) @Column(nullable=false, length=20) private StatusVeiculo status;
 public Veiculo() {}
 public Long getId(){return id;} public Modelo getModelo(){return modelo;} public void setModelo(Modelo v){modelo=v;}
 public Integer getAno(){return ano;} public void setAno(Integer v){ano=v;} public String getCor(){return cor;} public void setCor(String v){cor=v;}
 public BigDecimal getPreco(){return preco;} public void setPreco(BigDecimal v){preco=v;}
 public Integer getQuilometragem(){return quilometragem;} public void setQuilometragem(Integer v){quilometragem=v;}
 public StatusVeiculo getStatus(){return status;} public void setStatus(StatusVeiculo v){status=v;}
}
