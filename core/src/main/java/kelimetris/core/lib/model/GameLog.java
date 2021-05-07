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
    @NonNull
    private long numberOfClicks;
    @NonNull
    private int numberOfTetrominos;
    @NonNull
    private int score;
    @NonNull
    private int wordCount;
    @NonNull
    private String insertDate;
    @NonNull
    private String insertTime;
    @NonNull
    private String userId;
}
