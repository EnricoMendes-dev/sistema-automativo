package br.com.enrico.automotivo.dto;
import br.com.enrico.automotivo.model.StatusVeiculo;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
public record VeiculoRequest(@NotNull Long modeloId, @NotNull @Min(1900) Integer ano,
 @NotBlank String cor, @NotNull @DecimalMin("0.01") BigDecimal preco,
 @NotNull @Min(0) Integer quilometragem, @NotNull StatusVeiculo status) {}
