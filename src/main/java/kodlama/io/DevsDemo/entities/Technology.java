package kodlama.io.DevsDemo.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "technologies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "technology_name")
    private String name;
}
