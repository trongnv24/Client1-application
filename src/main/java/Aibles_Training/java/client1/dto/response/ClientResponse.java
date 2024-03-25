package Aibles_Training.java.client1.dto.response;

import Aibles_Training.java.client1.dto.request.ClientRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse extends ClientRequest {
    private String id;

}
