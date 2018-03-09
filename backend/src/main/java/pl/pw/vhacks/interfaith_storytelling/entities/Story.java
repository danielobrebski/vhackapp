package pl.pw.vhacks.interfaith_storytelling.entities;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class Story implements Serializable {
    private Long id;
    private String text;
    private MultipartFile additionalFile;
}
