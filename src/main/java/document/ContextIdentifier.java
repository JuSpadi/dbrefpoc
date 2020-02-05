package document;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContextIdentifier {
    private String type;

    private String value;
}
