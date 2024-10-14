package app.repository;

import app.entity.Carro;
import app.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    // listar carro por nome
    public List<Carro> findByName(String nome);

    // listar por marca
    public List<Carro> findByMarca(Marca marca);

    // listar carro com o ano acima do que eu buscar
                    //(linguagem JPQL)
    @Query("FROM Carro c WHERE c.ano > :ano")
    public List<Carro> findAcimaAno(Integer ano);
}
