package kelimetris.core.lib.model;

import kelimetris.core.lib.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "game_exceptions")
public class GameExceptionMessage extends BaseEntity {
    private static final long serialVersionUID = -8442657461433703880L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NonNull
    @Column(name = "game_log_id")
    private String gameLogId;
    @NonNull
    @Column(name = "exception_message")
    private String exceptionMessage;
    @Column(name = "insert_date")
    private long insertDate;
    @NonNull
    @Column(name = "insert_time")
    private String insertTime;
    @NonNull
    @Column(name = "user_id")
    private String userId;
}
