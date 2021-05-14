package kelimetris.core.lib.model;

import kelimetris.core.lib.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "game_log")
public class GameLog extends BaseEntity {
    private static final long serialVersionUID = -4647410322410590691L;
    @Id
    @NonNull
    @Column(name = "id")
    private String id;
    @Column(name = "number_of_clicks")
    private long numberOfClicks;
    @Column(name = "number_of_tetrominos")
    private long numberOfTetrominos;
    @Column(name = "score")
    private long score;
    @Column(name = "word_count")
    private long wordCount;
    @Column(name = "insert_date")
    private long insertDate;
    @NonNull
    @Column(name = "insert_time")
    private String insertTime;
    @NonNull
    @Column(name = "user_id")
    private String userId;
}
