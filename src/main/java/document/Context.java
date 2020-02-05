package document;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = "context")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Context {

    @Id
    private String id;

    @DBRef
    private List<Counter> counters;

    @DBRef
    private List<Reward> rewards;
}
