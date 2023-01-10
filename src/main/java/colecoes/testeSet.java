package colecoes;

import java.util.HashSet;
import java.util.Iterator;

public class testeSet {

    public static void main(String[] args) {
        HashSet<Cliente> hsc = new HashSet<Cliente>();
        hsc.add(new Cliente("João Delfino","Rua da Várzea","3232-1232"));
        hsc.add(new Cliente("Maria Tijuca","Av. Brasil","8569-99988"));
        hsc.add(new Cliente("Pedro de Lara","Rua 20 de março","7568-8524"));

        Cliente clienteJoao = new Cliente("João Delfino","Rua da Várzea","3232-1232");
        if(hsc.contains(clienteJoao)){
            System.out.println("Existe o cliente João Delfino");
        }

        System.out.println("Tamanho coleção HashSet: "+hsc.size());

        //Percorrendo o HashSet<Cliente> e imprimindo os valores
        Iterator<Cliente> it = hsc.iterator();
        while(it.hasNext()){
            Cliente valorCliente = (Cliente)it.next();
            System.out.println(valorCliente);
        }


    }
}
