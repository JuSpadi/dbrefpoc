package repo;

import document.Identifier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IdentifierRepository extends MongoRepository<Identifier, String> {

    Identifier findByTypeAndValue(String type, String value);

}
