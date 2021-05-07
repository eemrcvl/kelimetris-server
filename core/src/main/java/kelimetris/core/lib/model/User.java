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
public class User extends BaseEntity {
    private static final long serialVersionUID = 7735748471717538780L;
    @Id
    private String id;
    @NonNull
    private String username;
}
