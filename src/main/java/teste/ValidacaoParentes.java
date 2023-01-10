package teste;

public class ValidacaoParentes {

    public static void main(String[] args) {
        String s = "[']";

        char[] charArr = s.toCharArray();
        System.out.println(charArr[0]);

       // System.out.println(charArr[charArr.length - 1]);

        switch (charArr[0]) {
            case '(':
               if(charArr[charArr.length - 1] == ')'){
                   System.out.println("true");
               }else{
                   System.out.println("false");
               }
               break;
            case '[':
                if(charArr[charArr.length - 1] == ']'){
                    System.out.println("true");
                }else{
                    System.out.println("false 2");
                }
                break;
            default:
                break;

        }

    }
}
