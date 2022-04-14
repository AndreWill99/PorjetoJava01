import java.util.Date;

import javax.swing.JOptionPane;

class Funcionario {
  String nome;
  int matricula;

  void setNome(String nome) {
    this.nome = nome;
  }

  void setMatricula(int matricula) {
    this.matricula = matricula;
  }

  String getNome() {
    return this.nome;
  }

  int getMatricula() {
    return this.matricula;
  }
}

class Loja {

  void showMenu() {
    JOptionPane.showMessageDialog(null, "MENU\n\nR$7,00 . . . . . . . . Hambúrguer");
  }

}

class Pedido {
  int pedido;
  Date dataEmissao;
  double valorTotalCalculado;
  double valorHamburguer;

  int setId_Pedido(int pedido) {
    return this.pedido;
  }

  void setData_Emissao(Date dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  void setValor_Total_Calc(double valorTotalCalculado) {
    this.valorTotalCalculado = valorTotalCalculado;
  }

  void setProdutos(int quantidadeHumburguer) {
    double totalHamburguer = quantidadeHumburguer * this.valorHamburguer;

    this.valorTotalCalculado += totalHamburguer;

  }

  double getValorTotalCalculado() {
    return this.valorTotalCalculado;
  }
}

class Main {
  public static void main(String[] args) throws Exception {

    Funcionario funcionario1 = new Funcionario();
    funcionario1.setNome(JOptionPane.showInputDialog("Funcionário, digite seu nome:"));
    int matriculaFunc = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula [Somente Números]:"));
    funcionario1.setMatricula(matriculaFunc);
    JOptionPane.showMessageDialog(null, "Funcionário: " + funcionario1.getNome() + "\nMatrícula: " + matriculaFunc);

    Pedido pedido1 = new Pedido();
    pedido1.valorHamburguer = 7.00;
    int quantHamburguer = 0;

    Loja loja1 = new Loja();
    loja1.showMenu();

    while (true) {

      String respostaMenu = JOptionPane
          .showInputDialog("[1] Inserir produtos\n[2] Remover produto\n[3] Revisar Pedido\n\n[4] Para sair");
      if (respostaMenu.equals("1")) {
        int respostaInserirProd = Integer.parseInt(JOptionPane.showInputDialog("Quantos Hambúrguer(es)?"));
        quantHamburguer += respostaInserirProd;
      } else if (respostaMenu.equals("2")) {
        int respostaRemoverProd = Integer
            .parseInt(JOptionPane.showInputDialog("Quantos Hamburguer(es) deseja remover?"));
        quantHamburguer -= respostaRemoverProd;
      } else if (respostaMenu.equals("3")) {
        JOptionPane.showMessageDialog(null, "Você adicionou: " + quantHamburguer + " Hamburguer(es) ao carrinho");
      } else {
        break;
      }
    }
    Date dataPedido = new Date();
    pedido1.setData_Emissao(dataPedido);
    pedido1.setProdutos(quantHamburguer);

    JOptionPane.showMessageDialog(null, "Data do pedido: " + pedido1.dataEmissao + "\nPreço total dos produtos: R$"
        + String.format("%.2f", pedido1.getValorTotalCalculado()));

  }
}