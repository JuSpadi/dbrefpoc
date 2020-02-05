package document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = {"buId", "type", "value"})
@Document(collection = "identifier")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Identifier {

    @Id
    private String id;

    @DBRef
    private Context context;

    private Long buId;

    private String type;

    private String value;
}
