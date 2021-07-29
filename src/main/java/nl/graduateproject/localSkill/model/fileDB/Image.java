package nl.graduateproject.localSkill.model.fileDB;

import lombok.Data;
import nl.graduateproject.localSkill.model.item.Item;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
// @NoArgsConstructor: This adds a no-arguments constructor to the class.
// @DATA = LOMBOK = Generates getters and setters
//  https://bezkoder.com/spring-boot-upload-file-database/
@Entity
@Table(name = "files")
public class Image {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public Image() {
    }

    public Image(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}