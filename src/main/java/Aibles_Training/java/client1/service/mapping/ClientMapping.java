package Aibles_Training.java.client1.service.mapping;

import Aibles_Training.java.client1.dto.request.ClientRequest;
import Aibles_Training.java.client1.dto.response.ClientResponse;
import Aibles_Training.java.client1.entity.ClientEntity;

public class ClientMapping {
    public static ClientEntity convertDtoToEntity (ClientRequest dto){
        ClientEntity entity = new ClientEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());
        return entity;
    }
    public static ClientResponse covertEntityToClientResponse(ClientEntity entity){
        ClientResponse dto = new ClientResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setGender(entity.getGender());
        return dto;
    }
}
