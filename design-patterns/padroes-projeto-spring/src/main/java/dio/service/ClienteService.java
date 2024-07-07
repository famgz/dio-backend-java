package dio.service;

import dio.model.Cliente;

/*
 * interface que define o padrão Strategy no domínio do cliente.
 * Com isso, se necessário, pdemos ter múltiplas implementações dessa mesma interface
 */

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
