package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

  private Map<String, Integer> agendaContatoMap;

  public AgendaContatos() {
    this.agendaContatoMap = new HashMap<>();
  }

  public void adicionarContato(String nome, Integer telefone) {
    agendaContatoMap.put(nome, telefone);
  }

  public void removerContato(String nome) {
    if (agendaContatoMap.isEmpty())
      return;
    agendaContatoMap.remove(nome);
  }

  public void exibirContatos() {
    System.out.println(agendaContatoMap);
  }

  public Integer pesquisarPorNome(String nome) {
    if (agendaContatoMap.isEmpty())
      return null;
    return agendaContatoMap.get(nome);
  }

  public static void main(String[] args) {
    AgendaContatos agendaContatos = new AgendaContatos();

    agendaContatos.adicionarContato("Camila", 12234);
    agendaContatos.adicionarContato("Camila", 13123);
    agendaContatos.adicionarContato("Camila Cavalcanti", 56767);
    agendaContatos.adicionarContato("Maria Silva", 77878);

    agendaContatos.exibirContatos();
  }

}
