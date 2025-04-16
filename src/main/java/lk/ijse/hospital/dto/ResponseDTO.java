package lk.ijse.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Component
public class ResponseDTO {
    private int code;
    private String message;
    private Object data;


}
