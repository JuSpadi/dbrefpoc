package repo;

import document.Context;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextRepository extends MongoRepository<Context, String> {



}
