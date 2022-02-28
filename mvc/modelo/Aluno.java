/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

public class Aluno implements java.io.Serializable{
private static final long serialVersionUID = 1L;
private String dre;
private String nome;
public Aluno(String dre, String nome) {
super();
this.dre = dre;
this.nome = nome;
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
}

