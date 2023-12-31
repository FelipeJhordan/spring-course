package br.com.dio;

import br.com.dio.entity.Produto;
import br.com.dio.exception.ProductPriceException;
import br.com.dio.service.ProdutoService;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProductTest {

    @Autowired
    private ProdutoService produtoService;


    @Test
    public void verificaValorNegativoProduto() throws Exception {
        Produto produto = new Produto();

        produto.setNome("Teste");
        produto.setPreco(-2.2);

        Assertions.assertThrows(ProductPriceException.class, () -> produtoService.save(produto));
        Assertions.assertNull(produto.getId());
    }
}
