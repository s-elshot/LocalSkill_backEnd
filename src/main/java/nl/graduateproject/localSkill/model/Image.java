package nl.graduateproject.localSkill.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
@NoArgsConstructor
// @NoArgsConstructor: This adds a no-arguments constructor to the class.
// @DATA = LOMBOK = Generates getters and setters
@Entity
@Table
        (name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private Long size;


    @Column
    private String description;

    // nullable of verplicht in constructor?
    @Lob
    @Column
    private byte[] content;

    // nullable of verplicht in constructor?
    @ManyToOne
    @JoinColumn(name = "items_id")
    private Item item;
}