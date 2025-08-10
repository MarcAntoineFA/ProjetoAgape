public class Familia {
    private int id;
    private String nome;
    private int idade;
    private String endereco;
    private long cpf;
    private int cestasRetiradas;


    public Familia(int id, String nome, int idade, String endereco, long cpf, int cestasRetiradas) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cestasRetiradas = cestasRetiradas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {

        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getCpf() {
        return this.cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

//    public boolean quantidadeMaxima(int quantidade) {
//        if (this.cestasRetiradas >= quantidade) {
//            this.cestasRetiradas += quantidade;
//            return true;
//        }
//    }


    public void registrarRetirada() {
        this.cestasRetiradas++;
        System.out.println("Retirada registrada para a família " + this.nome);
    }

    @Override
    public String toString() {
        return "----------------------------------------\n" +
                " ID: " + id + "\n" +
                " Responsável: " + nome + " (" + idade + " anos)\n" +
                " Endereço: " + endereco + "\n" +
                " CPF: " + cpf + "\n" +
                " Cestas Retiradas: " + cestasRetiradas + "\n" +
                "----------------------------------------";
        }
}







