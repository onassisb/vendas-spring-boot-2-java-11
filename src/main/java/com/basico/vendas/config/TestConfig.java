package com.basico.vendas.config;

import com.basico.vendas.entities.*;
import com.basico.vendas.entities.enums.PedidoStatus;
import com.basico.vendas.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));

        var p1 = new Pedido(null, Instant.parse("2020-06-20T19:53:07Z"), u1, PedidoStatus.ENTREGUE);
        var p2 = new Pedido(null, Instant.parse("2020-07-21T03:42:10Z"), u2, PedidoStatus.ENVIADO);
        var p3 = new Pedido(null, Instant.parse("2020-07-22T15:21:22Z"), u1, PedidoStatus.PAGO);
        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

        var c1 = new Categoria(null, "Informática");
        var c2 = new Categoria(null, "Eletrônicos");
        var c3 = new Categoria(null, "TVs");
        var c4 = new Categoria(null, "Eletrodomesticos");
        categoriaRepository.saveAll(Arrays.asList(c1,c2,c3,c4));

        var pr1 = new Produto(null, "Computador","Core I7 9º geração",3000.0,"");
        var pr2 = new Produto(null,"Smart Tv","Televisão de ultima geração", 2000.0,"");
        var pr3 = new Produto(null,"Geladeira Eletro","geladeira de ultima geração", 3200.0,"");
        produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3));

        pr1.getCategorias().add(c1);
        pr2.getCategorias().add(c2);
        pr2.getCategorias().add(c3);
        pr3.getCategorias().add(c4);
        produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3));

        var pi1 = new PedidoItem(p1, pr1, 2, pr1.getPreco());
        var pi2 = new PedidoItem(p1, pr3, 1, pr3.getPreco());
        var pi3 = new PedidoItem(p2, pr3, 2, pr3.getPreco());
        var pi4 = new PedidoItem(p3, pr2, 2, pr2.getPreco());
        pedidoItemRepository.saveAll(Arrays.asList(pi1, pi2, pi3,pi4));

        var pagamento = new Pagamento(null, Instant.parse("2020-07-22T16:21:22Z"), p3);
        p3.setPagamento(pagamento);
        pedidoRepository.save(p3);
    }
}
