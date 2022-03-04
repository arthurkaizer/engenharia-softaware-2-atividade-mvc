package mvc.modelo;

public class Telefone{
    private String codigoPostal;
    private String numero;

    public Telefone(String codigoPostal, String numero) {
        this.codigoPostal = codigoPostal;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "codigoPostal='" + codigoPostal + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
