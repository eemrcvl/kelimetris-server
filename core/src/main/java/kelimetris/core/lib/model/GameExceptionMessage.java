package kelimetris.core.lib.model;

import kelimetris.core.lib.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class GameExceptionMessage extends BaseEntity {
    private static final long serialVersionUID = -8442657461433703880L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String gameLogId;
    @NonNull
    private String exceptionMessage;
    @NonNull
    private String insertDate;
    @NonNull
    private String insertTime;
    @NonNull
    private String userId;
}
