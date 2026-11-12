package br.com.enrico.automotivo.repository;
import br.com.enrico.automotivo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;
public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {
 @Query("select v from Veiculo v join v.modelo m join m.marca ma where " +
 "(:marca is null or lower(ma.nome) like lower(concat('%',:marca,'%'))) and " +
 "(:modelo is null or lower(m.nome) like lower(concat('%',:modelo,'%'))) and " +
 "(:precoMin is null or v.preco >= :precoMin) and (:precoMax is null or v.preco <= :precoMax) and " +
 "(:ano is null or v.ano = :ano) and (:status is null or v.status = :status)")
 List<Veiculo> filtrar(@Param("marca") String marca,@Param("modelo") String modelo,
 @Param("precoMin") BigDecimal precoMin,@Param("precoMax") BigDecimal precoMax,
 @Param("ano") Integer ano,@Param("status") StatusVeiculo status);
}
