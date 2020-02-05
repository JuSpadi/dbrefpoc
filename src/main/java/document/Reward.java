package document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = "reward")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reward {

    @Id
    private String id;

    private Long buId;

    private String rewardType;

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
