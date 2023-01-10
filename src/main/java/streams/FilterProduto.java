package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterProduto {


    public static void main(String[] args) {

        Produto p1 = new Produto("Lapis",1.99, 0.12, 0);
        Produto p2 = new Produto("Notebook",4899.89, 0.32, 0);
        Produto p3 = new Produto("Carderno",30, 0.45, 0);
        Produto p4 = new Produto("Impressora",1200, 0.40, 0);
        Produto p5 = new Produto("iPad",3100, 0.29, 0);
        Produto p6 = new Produto("Relogio ",1900, 0.12, 30);


        List<Produto> produtos = Arrays.asList(p1,p2,p3,p4,p5,p6);

        Predicate<Produto> gerarDesconto = p -> p.desconto >= 0.30;
        Predicate<Produto> freeteGratis = p -> p.valorFrete == 0;
        Predicate<Produto> produtoRElevante = p -> p.preco >= 500;

        Function<Produto,String> chamadaPromocional =
                p -> "Aproveite! " + p.nome + " por R$ " +  p.preco;


        produtos.stream()
                .filter(gerarDesconto)
                .filter(freeteGratis)
                .filter(produtoRElevante)
                .map(chamadaPromocional)
                .forEach(System.out::println);



    }

}
