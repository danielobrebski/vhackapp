package pl.pw.vhacks.users;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class Faith implements Serializable {
    private Long id;
    private String name;
}