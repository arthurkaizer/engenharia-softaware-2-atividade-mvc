package mvc.modelo;

public class Endereco{
    private String cep;
    private String estado;
    private String cidade;
    private String rua;
    private String numero;

    public Endereco(String cep, String estado, String cidade, String rua, String numero) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
