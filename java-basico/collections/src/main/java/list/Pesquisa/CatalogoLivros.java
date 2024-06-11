package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

  private List<Livro> livrosList;

  public CatalogoLivros() {
    this.livrosList = new ArrayList<>();
  }

  public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
    livrosList.add(new Livro(titulo, autor, anoPublicacao));
  }

  public List<Livro> pesquisarPorAutor(String autor) {
    List<Livro> livrosPorAutor = new ArrayList<>();
    for (Livro l : livrosList) {
      if (l.getAutor().equalsIgnoreCase(autor)) {
        livrosPorAutor.add(l);
      }
    }
    return livrosPorAutor;
  }

  public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
    List<Livro> livrosPorIntervaloAnos = new ArrayList<>();

    for (Livro l : livrosList) {
      if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
        livrosPorIntervaloAnos.add(l);
      }
    }
    return livrosPorIntervaloAnos;
  }

  public Livro pesquisarPorTitulo(String titulo) {
    for (Livro l : livrosList) {
      if (l.getTitulo().equalsIgnoreCase(titulo)) {
        return l;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    CatalogoLivros catalogoLivros = new CatalogoLivros();

    catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2012);
    catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2020);
    catalogoLivros.adicionarLivro("Livro 4", "Autor 2", 2011);
    catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2009);

    System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));
    System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2008, 2011));
    System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
  }

}
