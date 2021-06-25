package carrinho;

import calculadora.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoTest {
    private Carrinho car;

    @BeforeEach
    public void inicializa() {
        car = new Carrinho();
    }

    @Test
    public void testTamanhoCarrinhoVazio() {
        assertEquals(0, car.getQtdeItems());
    }

    @Test
    public void testValorTotal() {
        Produto p1 = new Produto("Maçã", 1.00);
        Produto p2 = new Produto("Abacaxi", 4.00);
        car.addItem(p1);
        car.addItem(p2);

        assertEquals(5.00, car.getValorTotal());

        car.esvazia();
        assertEquals(0, car.getValorTotal());
    }

    @Test
    public void testQuantidadeItens() {
        Produto p1 = new Produto("Revista", 7.00);
        Produto p2 = new Produto("Escova de dente", 3.00);
        Produto p3 = new Produto("Biscoito", 2.50);
        car.addItem(p1);
        car.addItem(p2);
        car.addItem(p3);

        assertTrue(car.getQtdeItems() == 3);

        car.esvazia();
        assertTrue(car.getQtdeItems() == 0);
    }

    @Test
    public void testRemoverItem() throws ProdutoNaoEncontradoException {
        Produto p = new Produto("Creme", 5.00);
        car.addItem(p);
        car.removeItem(p);
        int quantidadeItens = car.getQtdeItems();
        Assertions.assertEquals(quantidadeItens, 0);
    }
}
