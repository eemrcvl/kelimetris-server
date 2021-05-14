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
@Table(name = "users")
public class User extends BaseEntity {
    private static final long serialVersionUID = 7735748471717538780L;
    @Id
    @Column(name = "id")
    private String id;
    @NonNull
    @Column(name = "username")
    private String username;
    @Column(name = "insert_date")
    private long insertDate;
    @NonNull
    @Column(name = "insert_time")
    private String insertTime;
    @Column(name = "last_updated")
    private long lastUpdated;
}
