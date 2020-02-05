package document;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = "counter")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Counter {

    @Id
    private String id;

    private Long buId;

    private Double value;

    private String counterType;

    private List<ContextIdentifier> identifiers;

    public List<ContextIdentifier> getIdentifiers() {
        if (identifiers == null){
            identifiers =  new ArrayList<>();
        }
        return identifiers;
    }

    public void setIdentifiers(List<ContextIdentifier> identifiers) {
        this.identifiers = identifiers;
    }
}
