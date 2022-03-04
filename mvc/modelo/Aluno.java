/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

public class Aluno implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String dre;
    private String nome;
    private String telefone;
    private String endereco;
//private DataNasc dataNasc;

    public Aluno(String dre, String nome, String telefone, String endereco) {
        super();
        this.dre = dre;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
//this.dataNasc = dataNasc;
    }

    public String getDre() {
        return dre;
    }

    public void setDre(String dre) {
        this.dre = dre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
/*
public DataNasc getDataNasc() {
    return dataNasc;
}
public void setDataNasc(DataNasc dataNasc) {
        this.dataNasc = dataNasc;
    }
}
*/
}
