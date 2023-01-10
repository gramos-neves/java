package fila;

public class Fila {

    private No refNoEntradaFila;

    public Fila(){
        this.refNoEntradaFila = null;
    }

    public boolean isEmpty(){
        return  this.refNoEntradaFila==null? true : false;
    }


    public void enqueue(No novoNO){
        novoNO.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNO;

    }

    public  No first(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            while (true){
                if(primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    break;
                }
            }
        }
        return  null;
    }


    public  No dequeue(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No auxiliarNo = refNoEntradaFila;
            while (true){
                if(primeiroNo.getRefNo() != null){
                    auxiliarNo = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    auxiliarNo.setRefNo(null);
                    break;
                }
            }
            return  primeiroNo;
        }
        return  null;
    }


    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if(refNoEntradaFila != null){

           while (true){
               stringRetorno += "[No{objeto="+ noAuxiliar.getObject() + ", ref ="+ noAuxiliar.getRefNo() +"}] \n";

               if(noAuxiliar.getRefNo() != null){
                   noAuxiliar = noAuxiliar.getRefNo();
               }else{
                   stringRetorno += "null";
                   break;
               }
           }

        }else{
            return null;
        }
        return stringRetorno;
    }
}
