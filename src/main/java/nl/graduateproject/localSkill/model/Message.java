package nl.graduateproject.localSkill.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
// @NoArgsConstructor: This adds a no-arguments constructor to the class.
@Data
// @DATA = LOMBOK = Generates getters and setters
@Table
        (name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // nullable of verplicht in constructor?
    @Column
    private String title;

    // nullable of verplicht in constructor?
    @Column
    private String bodyText;

    @Column
    private LocalDate date;

}