package br.com.enrico.automotivo.model;
import jakarta.persistence.*;
@Entity @Table(name="modelos", uniqueConstraints=@UniqueConstraint(columnNames={"nome","marca_id"}))
public class Modelo {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false, length=80) private String nome;
 @ManyToOne(optional=false) @JoinColumn(name="marca_id") private Marca marca;
 public Modelo() {}
 public Modelo(String nome, Marca marca){this.nome=nome;this.marca=marca;}
 public Long getId(){return id;} public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
 public Marca getMarca(){return marca;} public void setMarca(Marca marca){this.marca=marca;}
}
