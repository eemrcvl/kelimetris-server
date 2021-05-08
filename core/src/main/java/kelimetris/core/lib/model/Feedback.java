package kelimetris.core.lib.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kelimetris.core.lib.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String userId;
    @NonNull
    private String message;
    @NonNull
    private String insertDate;
    @NonNull
    private String insertTime;
    @NonNull
    private int stars;
}
