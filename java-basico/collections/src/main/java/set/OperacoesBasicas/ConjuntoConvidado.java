package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidado {
  private Set<Convidado> convidadoSet;

  public ConjuntoConvidado() {
    this.convidadoSet = new HashSet<>();
  }

  public void adicionarConvidado(String nome, int codigoConvite) {
    convidadoSet.add(new Convidado(nome, codigoConvite));
  }

  public void removerConvidadoPorCodigoConvite(int codigoConvite) {
    Convidado convidadoParaRemover = null;

    for (Convidado c : convidadoSet) {
      if (c.getCodigoConvite() == codigoConvite) {
        convidadoParaRemover = c;
        break;
      }
    }
    convidadoSet.remove(convidadoParaRemover);
  }

  public int contarConvidados() {
    return convidadoSet.size();
  }

  public void exibirConvidados() {
    System.out.println(convidadoSet);
  }

  public static void main(String[] args) {
    ConjuntoConvidado conjuntoConvidado = new ConjuntoConvidado();
    System.out.println("Existem " + conjuntoConvidado.contarConvidados() + " convidados");

    conjuntoConvidado.adicionarConvidado("Convidado 1", 123);
    conjuntoConvidado.adicionarConvidado("Convidado 2", 128);
    conjuntoConvidado.adicionarConvidado("Convidado 3", 126);
    conjuntoConvidado.adicionarConvidado("Convidado 4", 126);

    System.out.println("Existem " + conjuntoConvidado.contarConvidados() + " convidados");

    conjuntoConvidado.exibirConvidados();
  }

}
