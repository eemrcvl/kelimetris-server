package kelimetris.core.lib.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kelimetris.core.lib.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "score")
public class Score extends BaseEntity {
    private static final long serialVersionUID = 1210051467480920803L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id")
    private long id;
    @NonNull
    @Column(name = "user_id")
    @JsonIgnore
    private String userId;
    @NonNull
    @Column(name = "username")
    private String username;
    @Column(name = "score")
    private long score;
    @Column(name = "last_updated")
    private long lastUpdated; // in epoch format

    public Score(String userId, String username, long score) {
        this.userId = userId;
        this.username = username;
        this.score = score;
    }
}
