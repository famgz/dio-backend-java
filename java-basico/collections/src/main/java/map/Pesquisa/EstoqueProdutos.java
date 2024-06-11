package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

  private Map<Long, Produto> estoqueProdutosMap;

  public EstoqueProdutos() {
    this.estoqueProdutosMap = new HashMap<>();
  }

  public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
    estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
  }

  public void exibirTodosProdutos() {
    System.out.println(estoqueProdutosMap);
  }

  public double calcularValorTotalEstoque() {
    double valorTotal = 0;

    for (Produto p : estoqueProdutosMap.values()) {
      valorTotal += p.getPreco() * p.getQuantidade();
    }
    return valorTotal;
  }

  public Produto obterProdutoMaisCaro() {
    Produto produtoMaisCaro = null;
    double maiorPreco = Double.MIN_VALUE;
    for (Produto p : estoqueProdutosMap.values()) {
      if (p.getPreco() > maiorPreco) {
        produtoMaisCaro = p;
      }
    }
    return produtoMaisCaro;
  }

  public static void main(String[] args) {
    EstoqueProdutos estoque = new EstoqueProdutos();
    estoque.exibirTodosProdutos();

    estoque.adicionarProduto(1l, "Produto A", 10, 5.0);
    estoque.adicionarProduto(2L, "Produto B", 5, 10.0);
    estoque.adicionarProduto(3L, "Produto C", 2, 15.0);
    estoque.adicionarProduto(4L, "Produto D", 2, 23.0);

    estoque.exibirTodosProdutos();

    System.out.println("Valor total do esqotue: R$" + estoque.calcularValorTotalEstoque());
    System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());
  }

}
