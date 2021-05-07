package kelimetris.core.lib.model;

import kelimetris.core.lib.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Feedback extends BaseEntity {
    private static final long serialVersionUID = 1010363936995158759L;
    @Id
    @NonNull
    private String userId;
    @NonNull
    private String message;
    @NonNull
    private String insertDate;
    @NonNull
    private String insertTime;
}
