import org.example.Calculadora;
import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void testeCalculadora(){
        Calculadora calculador = new Calculadora(2, 3);
        int soma = calculador.soma();

        Assert.assertEquals(5, soma);
    }
}
