/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controle;

import java.util.Collection;
import java.util.HashMap;
import java.io.*;

import mvc.modelo.Aluno;
import mvc.modelo.Endereco;
import mvc.modelo.Telefone;

public class ControladorAlunoSerializado {
    public static ControladorAlunoSerializado controladorAlunoSerializado = null;

    public static ControladorAlunoSerializado getControladorAlunoSerializado() {
        if (controladorAlunoSerializado == null) controladorAlunoSerializado = new
                ControladorAlunoSerializado();
        return controladorAlunoSerializado;
    }

    HashMap<String, Aluno> alunos;

    private ControladorAlunoSerializado() {
        alunos = new HashMap<String, Aluno>();
    }

    public Aluno getAluno(String dre) throws AlunoInexistenteException {
        if (alunos.get(dre) == null) throw new AlunoInexistenteException(dre);
        else return alunos.get(dre);
    }

    public void criaAluno(String dre, String nome, String codigoPostal, String numeroTelefone, String cep, String estado, String cidade, String rua, String numero) throws DreDuplicadoException, EnderecoIncompletoException, TelefoneIncompletoException {
        if (codigoPostal.length() == 0 || numeroTelefone.length() == 0) {
            throw new TelefoneIncompletoException();
        } else if (cep.length() == 0 || estado.length() == 0 || cidade.length() == 0 || rua.length() == 0 || numero.length() == 0) {
            throw new EnderecoIncompletoException();
        } else if (alunos.get(dre) == null) {
            Telefone telefone = new Telefone(codigoPostal, numeroTelefone);
            Endereco endereco = new Endereco(cep, estado, cidade, rua, numero);
            alunos.put(dre, new Aluno(dre, nome, telefone, endereco));
        } else throw new DreDuplicadoException();
    }

    public Collection<Aluno> getAlunos() {
        return alunos.values();
    }

    public void salvarAlunos() throws IOException {
        FileOutputStream fos = new FileOutputStream("alunos.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(alunos);
        oos.close();
    }

    public void recuperarAlunos() throws IOException, ClassNotFoundException {
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("alunos.ser"));
        Object objeto = ois.readObject();
        alunos = (HashMap<String, Aluno>) objeto;
    }

    public void limparDados() {
// destroi todos os dados da memória
        alunos = new HashMap<String, Aluno>();
    }
}
