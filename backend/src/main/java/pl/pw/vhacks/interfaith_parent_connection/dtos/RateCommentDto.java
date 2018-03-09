package pl.pw.vhacks.interfaith_parent_connection.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class RateCommentDto implements Serializable {
    private Long commentId;
    private Boolean positiveRate;
}
