package mag.traficMap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "traffic")
public class Traffic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grade", nullable = false, unique = true)
    private int grade;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="street_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Street street;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name ="street_from", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    private Street streetFrom;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name ="street_to", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    private Street streetTo;

}
