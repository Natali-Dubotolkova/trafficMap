package mag.traficMap.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "street")

public class Street implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", unique = true, nullable = false)
    private String streetTitle;

    @OneToMany(/*mappedBy = "traffic", fetch = FetchType.LAZY, */cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    private Set<Traffic> traffics;

    public Street(String streetTitle) {
        this.streetTitle = streetTitle;
    }
}
