package funcional;


public class Produto {

    private String nome;
    private Double preco;
    private Double desco;


    public Produto(String nome, Double preco, Double desco) {
        this.nome = nome;
        this.preco = preco;
        this.desco = desco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getDesco() {
        return desco;
    }

    public void setDesco(Double desco) {
        this.desco = desco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", desco=" + desco +
                '}';
    }
}
