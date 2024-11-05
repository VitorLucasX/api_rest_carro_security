package app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CarroServiceTest {

    @Autowired
    CarroService carroService;

    @Test
    // TESTE UNITÁRIO PRA PASSAR CASO O JEEP COMPASS SEJA DO ANO CORRETO
    void cenario01() {
        boolean retorno = this.carroService.verificarNomeCarro("Jeep Compass", 2006);
        assertEquals(true, retorno);
    }

    @Test
    // TESTE UNITÁRIO PRA DAR ERRO CASO O JEEP COMPASS SEJA DO ANO < QUE 2006
    void cenario02() {
        assertThrows(Exception.class, () -> {
            boolean retorno = this.carroService.verificarNomeCarro("Jeep Compass", 1995);
        });
    }
}
