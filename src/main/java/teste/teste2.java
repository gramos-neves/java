package teste;

public class teste2 {

    public static void main(String[] args) {
        String palavra = "digital";

        StringBuilder strb = new StringBuilder(palavra);

        String palavra2 = strb.reverse().toString();


        if(palavra.equalsIgnoreCase(palavra2)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
