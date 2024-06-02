package funcionalidades;

public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

  @Override
  public void atender() {
    System.out.println("atender");
  }

  public void iniciarCorreioVoz() {
    System.out.println("iniciarCorreioVoz");
  }

  @Override
  public void ligar(String numero) {
    System.out.println("ligar");
  }

  @Override
  public void adicionarNovaAva() {
    System.out.println("adicionarNovaAva");
  }

  @Override
  public void atualizarPagina() {
    System.out.println("atualizarPagina");
  }

  @Override
  public void exibirPagina(String url) {
    System.out.println("exibirPagina");
  }

  @Override
  public void pausar() {
    System.out.println("pausar");
  }

  @Override
  public void selecionarMusica() {
    System.out.println("selecionarMusica");
  }

  @Override
  public void tocar() {
    System.out.println("tocar");
  }
}
