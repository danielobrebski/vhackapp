package pl.pw.vhacks.interfaith_parent_connection.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class RatePostDto implements Serializable {
    private Long postId;
    private Boolean positiveRate;
}
