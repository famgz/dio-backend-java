package dio.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // opcional
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
