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
@Table(name = "feedback")
public class Feedback extends BaseEntity {
    private static final long serialVersionUID = 1010363936995158759L;
    @Id
    @JsonIgnore
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(name = "user_id")
    private String userId;
    @NonNull
    @Column(name = "message")
    private String message;
    @Column(name = "insert_date")
    private long insertDate;
    @NonNull
    @Column(name = "insert_time")
    private String insertTime;
    @Column(name = "stars")
    private int stars;
}
