package Aibles_Training.java.client1.service.impl;

import Aibles_Training.java.client1.dto.request.ClientRequest;
import Aibles_Training.java.client1.dto.response.ClientResponse;
import Aibles_Training.java.client1.entity.ClientEntity;
import Aibles_Training.java.client1.repository.ClientRepository;
import Aibles_Training.java.client1.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static Aibles_Training.java.client1.service.mapping.ClientMapping.convertDtoToEntity;
import static Aibles_Training.java.client1.service.mapping.ClientMapping.covertEntityToClientResponse;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponse create(ClientRequest request) {
        log.info(" === Start api create new client ==== ");
        log.info(" === Request Body : {} === ", request);
        ClientEntity entity = convertDtoToEntity(request);
        entity=clientRepository.save(entity);
        ClientResponse response = covertEntityToClientResponse(entity);
        log.info(" === Finish api create new client, Client Id {} : ", response.getId());
        return response;
    }
}
