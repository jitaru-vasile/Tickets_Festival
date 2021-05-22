package ro.sd.a2.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayloadDTO {
    private String ticketName;
    private String userFullName;
    private String userEmail;
    private Integer price;
    private String ticketPath;
}
