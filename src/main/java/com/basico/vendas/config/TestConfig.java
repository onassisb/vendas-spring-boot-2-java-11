package com.basico.vendas.config;

import com.basico.vendas.entities.Pedido;
import com.basico.vendas.entities.User;
import com.basico.vendas.entities.enums.PedidoStatus;
import com.basico.vendas.repositories.PedidoRepository;
import com.basico.vendas.repositories.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {
        var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));

        var p1 = new Pedido(null, Instant.parse("2020-06-20T19:53:07Z"), u1, PedidoStatus.ENTREGUE);
        var p2 = new Pedido(null, Instant.parse("2020-07-21T03:42:10Z"), u2, PedidoStatus.ENVIADO);
        var p3 = new Pedido(null, Instant.parse("2020-07-22T15:21:22Z"), u1, PedidoStatus.PAGO);
        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
