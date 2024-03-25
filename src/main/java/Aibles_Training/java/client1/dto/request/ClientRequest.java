package Aibles_Training.java.client1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    private String name;
    private String email;
    private String address;
    private String gender;
}
