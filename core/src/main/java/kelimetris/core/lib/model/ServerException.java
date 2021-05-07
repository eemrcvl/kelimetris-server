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
public class ServerException extends BaseEntity {
    /**
     * DO NOT USE, WILL IMPLEMENT SAVING LOGS TO DATABASE LATER
     */
    private static final long serialVersionUID = 1863178902897116607L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    @NonNull
    @JsonIgnore
    private String userId;
    @NonNull
    private String username;
    @NonNull
    private int score;
}
