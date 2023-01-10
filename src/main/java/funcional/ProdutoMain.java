package funcional;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMain {


    public static int compareProducts(Produto p1, Produto p2){
        return p1.getPreco().compareTo(p2.getPreco());
    }



    public static void main(String[] args) {
          List<Produto> list = new ArrayList<Produto>();

          list.add(new Produto("tv",203.0,5.0));
        list.add(new Produto("samgung",205.0,5.0));
        list.add(new Produto("notbook",201.0,5.0));


        list.sort(ProdutoMain::compareProducts);

        list.forEach(System.out::println);

;    }
}
