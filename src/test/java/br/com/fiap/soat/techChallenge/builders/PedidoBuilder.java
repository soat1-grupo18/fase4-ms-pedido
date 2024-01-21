package br.com.fiap.soat.techChallenge.builders;

import br.com.fiap.soat.techChallenge.entities.ItemDoPedido;
import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PedidoBuilder {

    public static Pedido build() {
        var pedido = new Pedido();
        pedido.setId(UUID.randomUUID());
        pedido.setClienteId(UUID.randomUUID());
        pedido.setDataDeCriacao(LocalDateTime.now());

        var produtos = ProdutoBuilder.buildList(3);
        produtos.forEach(produto -> pedido.adicionarItem(PedidoBuilder.buildItem(produto)));

        return pedido;
    }

    private static ItemDoPedido buildItem(Produto produto) {
        return new ItemDoPedido(
                null,
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategoria().toString(),
                produto.getImagem(),
                2,
                BigDecimal.valueOf(produto.getPreco())
        );
    }
}
