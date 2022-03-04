/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import mvc.controle.*;
import mvc.vista.AlunoInexistenteException;

public class GuiSimplesSalvando {
private String dre, nome, codigoPostal, telefone, cep, estado, cidade, rua, numero, dataNasc;
private JFrame janela;
private JPanel painelGeral, pCentro, pDisplay, pDre, pNome, pBotoes, pMensagem, pTelefone, pEndereco, pdataNasc;
private JLabel labelDre, labelNome, labelMensagem, labelTelefone, labelCodigoPostal, labelCep, labelEstado, labelCidade, labelRua, labelNumero, labelDataNasc;
private JButton botCriar, botObterNome, botSalvar, botLimpar;
private JTextField tfDre, tfNome, tfMensagem, tfTelefone, tfCodigoPostal, tfCep, tfEstado, tfCidade, tfRua, tfNumero, tfDataNasc;
private ControladorAlunoSerializado controlador =
 ControladorAlunoSerializado.getControladorAlunoSerializado();
public GuiSimplesSalvando() {
janela = new JFrame("GUI Simples Persistente");
painelGeral = new JPanel(new BorderLayout());
pCentro = new JPanel(new BorderLayout());
pDisplay = new JPanel(new GridLayout(5,1));
pDre = new JPanel();
pNome = new JPanel();
pTelefone = new JPanel();
pEndereco = new JPanel();
pdataNasc = new JPanel();
pDre.setLayout(new FlowLayout(FlowLayout.LEFT));
pNome.setLayout(new FlowLayout(FlowLayout.LEFT));
pTelefone.setLayout(new FlowLayout(FlowLayout.LEFT));
pEndereco.setLayout(new GridLayout(5,1));
pdataNasc.setLayout(new FlowLayout(FlowLayout.LEFT));
pDisplay.add(pDre);
pDisplay.add(pNome);
pDisplay.add(pTelefone);
pDisplay.add(pEndereco);
pDisplay.add(pdataNasc);
labelDre = new JLabel("DRE: ");
pDre.add(labelDre);
tfDre = new JTextField(10);
tfDre.addKeyListener(new OuvinteTfDre());
pDre.add(tfDre);
labelNome = new JLabel("Nome: ");
pNome.add(labelNome);
tfNome = new JTextField(30);
pNome.add(tfNome);
labelCodigoPostal = new JLabel("Código Postal: ");
pTelefone.add(labelCodigoPostal);
tfCodigoPostal = new JTextField(2);
pTelefone.add(tfCodigoPostal);
labelTelefone = new JLabel("Telefone: ");
pTelefone.add(labelTelefone);
tfTelefone = new JTextField(9);
pTelefone.add(tfTelefone);

labelCep = new JLabel("CEP: ");
labelEstado = new JLabel("Estado: ");
labelCidade = new JLabel("Cidade: ");
labelRua = new JLabel("Rua: ");
labelNumero = new JLabel("Número: ");
labelDataNasc = new JLabel("Data de Nascimento: ");
pEndereco.add(labelCep);
tfCep = new JTextField(8);
pEndereco.add(tfCep);
pEndereco.add(labelEstado);
tfEstado = new JTextField(30);
pEndereco.add(tfEstado);
pEndereco.add(labelCidade);
tfCidade = new JTextField(30);
pEndereco.add(tfCidade);
pEndereco.add(labelRua);
tfRua = new JTextField(30);
pEndereco.add(tfRua);
pEndereco.add(labelNumero);
tfNumero = new JTextField(10);
pEndereco.add(tfNumero);
labelDataNasc = new JLabel("Data de Nascimento: ");
pdataNasc.add(labelDataNasc);
tfDataNasc = new JTextField(30);
pdataNasc.add(tfDataNasc);


pBotoes = new JPanel();
botCriar = new JButton("Criar Aluno");
botCriar.addActionListener(new OuvinteCriar());
pBotoes.add(botCriar);
botObterNome = new JButton("Obter nome");
botObterNome.addActionListener(new OuvinteObterNome());
pBotoes.add(botObterNome);
botSalvar = new JButton("Salvar dados");
botSalvar.addActionListener(new OuvinteSalvar());
pBotoes.add(botSalvar);
botLimpar = new JButton("Limpar dados");
botLimpar.addActionListener(new OuvinteLimpar());
pBotoes.add(botLimpar);
pMensagem = new JPanel();
labelMensagem = new JLabel("Mensagem: ");
tfMensagem = new JTextField(40);
tfMensagem.setEditable(false);
pMensagem.add(labelMensagem);
pMensagem.add(tfMensagem);
pMensagem.setLayout(new FlowLayout(FlowLayout.LEFT));
pCentro.add(pDisplay, BorderLayout.CENTER);
pCentro.add(pBotoes, BorderLayout.SOUTH);
painelGeral.add(pCentro, BorderLayout.CENTER);
painelGeral.add(pMensagem, BorderLayout.SOUTH);
janela.add(painelGeral);
janela.setBounds(0, 0, 600, 600);
janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
janela.setVisible(true);
try{
controlador.recuperarAlunos();
tfMensagem.setText("Os dados dos alunos foram recuperados do arquivo");
}
catch(IOException ioe){
tfMensagem.setText
 ("Não foi possível recuperar os dados dos alunos: IOException");
}
catch (ClassNotFoundException cnf){
tfMensagem.setText
 ("Não foi possível recuperar os dados dos alunos: ClassNotFoundException");
}
}
class OuvinteTfDre extends KeyAdapter{
@Override
public void keyTyped(KeyEvent ev){
tfMensagem.setText("");
tfNome.setText("");
}
}
class OuvinteCriar implements ActionListener {
@Override
public void actionPerformed(ActionEvent aev){
nome = tfNome.getText();
dre = tfDre.getText();
codigoPostal = tfCodigoPostal.getText();
telefone = tfCodigoPostal.getText();
cep = tfCep.getText();
estado = tfEstado.getText();
cidade = tfEstado.getText();
rua = tfRua.getText();
numero = tfNumero.getText();
dataNasc = tfDataNasc.getText();
try{
controlador.criaAluno(dre, nome, codigoPostal, telefone, cep, estado, cidade, rua, numero, dataNasc);
tfMensagem.setText("Aluno " + nome + " criado OK, com DRE " +
dre + " ..... ");
}
catch(DreDuplicadoException ex){
tfMensagem.setText
 ("Não foi possível criar o aluno. O DRE " + dre + " já foi alocado");
}   catch (EnderecoIncompletoException e) {
    tfMensagem.setText("Endereço Incompleto");
}   catch (TelefoneIncompletoException ex){
    tfMensagem.setText("Telefone Incompleto");
}   catch (DataNascIncompletoException ex){
        tfMensagem.setText("Data de Nascimento Incompleto");
    }
}
}
class OuvinteObterNome implements ActionListener {
@Override
public void actionPerformed(ActionEvent aev){
    try {
        dre = tfDre.getText();
        nome = controlador.getAluno(dre).getNome();
        tfMensagem.setText("O aluno com DRE = " + dre + " chama-se " +
                nome);
    } catch (mvc.controle.AlunoInexistenteException ex) {
    }
}
}
class OuvinteSalvar implements ActionListener{
public void actionPerformed(ActionEvent aev){
try{
controlador.salvarAlunos();
tfMensagem.setText("Dados dos alunos salvos com sucesso");
}
catch (IOException ioe){
tfMensagem.setText
 ("Não foi possível salvar os dados dos alunos no arquivo");
}
}
}
class OuvinteLimpar implements ActionListener{
public void actionPerformed(ActionEvent aev){
        controlador.limparDados();
        tfMensagem.setText
                ("Dados dos alunos no arquivo limpos com sucesso");

}
}
public static void main(String[] args) {
new GuiSimplesSalvando();
}
}
