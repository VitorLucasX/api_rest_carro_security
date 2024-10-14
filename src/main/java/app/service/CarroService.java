package app.service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    // inserir carro
    public String save(Carro carro) {
        this.carroRepository.save(carro);
        return "Carro salvo com sucesso!";
    }

    // alterar carro
    public String update(Carro carro, long id) {
        carro.setId(id);
        this.carroRepository.save(carro);
        return "Carro alterado com sucesso!";
    }

    // deletar carro
    public String delete(long id) {
        this.carroRepository.deleteById(id);
        return "Carro deletado com sucesso!";
    }

    // listar todos carros
    public List<Carro> findAll() {
        List<Carro> lista = this.carroRepository.findAll();
        return lista;
    }

    // listar carro por id
    public Carro findById(long id) {
        Carro carro = this.carroRepository.findById(id).get();
        return carro;
    }

    // listar carro por nome
    public List<Carro> findByName(String name) {
        return this.carroRepository.findByName(name);
    }

    // listar carro por marca
    public List<Carro> findByMarca(Long idMarca) {
        Marca marca = new Marca();
        marca.setId(idMarca);
        return this.carroRepository.findByMarca(marca);
    }

    // listar carro com o ano acima do que eu buscar
    public List<Carro> findAcimaAno(Integer ano) {
        return this.carroRepository.findAcimaAno(ano);
    }
}
