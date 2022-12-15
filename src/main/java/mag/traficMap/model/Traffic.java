package mag.traficMap.model;

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

    @Column(nullable = false, unique = true)
    private Float grade;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="street_id", nullable = false)
    private Street street;

    @ManyToOne(fetch = FetchType.LAZY)
    private Street streetTo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Street streetFrom;

    public Traffic(Float grade, Street street, Street streetTo, Street streetFrom) {
        this.grade = grade;
        this.street = street;
        this.streetTo = streetTo;
        this.streetFrom = streetFrom;
    }
}
