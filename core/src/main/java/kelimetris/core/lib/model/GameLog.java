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
public class GameLog extends BaseEntity {
    private static final long serialVersionUID = -4647410322410590691L;
    @Id
    @NonNull
    private String id;
    private long numberOfClicks;
    private long numberOfTetrominos;
    private long score;
    private long wordCount;
    private long insertDate;
    @NonNull
    private String insertTime;
    @NonNull
    private String userId;
}
