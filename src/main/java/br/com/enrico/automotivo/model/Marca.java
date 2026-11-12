package br.com.enrico.automotivo.model;
import jakarta.persistence.*;
@Entity @Table(name="marcas")
public class Marca {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false, unique=true, length=80) private String nome;
 public Marca() {}
 public Marca(String nome) { this.nome=nome; }
 public Long getId(){return id;} public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
}
