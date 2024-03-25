package Aibles_Training.java.client1.service.impl;

import Aibles_Training.java.client1.dto.request.ClientRequest;
import Aibles_Training.java.client1.dto.response.ClientResponse;
import Aibles_Training.java.client1.entity.ClientEntity;
import Aibles_Training.java.client1.exception.NotFoundException;
import Aibles_Training.java.client1.repository.ClientRepository;
import Aibles_Training.java.client1.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    @Override
    public ClientResponse getById(String id) {
        log.info(" === Start api getById client === ");
        log.info(" === String id : {} === ", id);
        Optional<ClientEntity> optionalClient = clientRepository.findById(id);
        if( !optionalClient.isPresent()){
            throw new NotFoundException("khong tim thay", id ,null);
        }
        ClientEntity clientEntity = optionalClient.get();
        ClientResponse response = covertEntityToClientResponse(clientEntity);
        log.info(" === Finish api getById client, Client Id {} : === ", response.getId());
        return response ;
    }
    @Override
    public ClientResponse update (ClientRequest request, String id){
        log.info(" === Start api update client === ");
        log.info(" === Request Body : {}, String id : {} === ", request, id);
        Optional<ClientEntity> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()){
            throw new RuntimeException();
        }
        ClientEntity clientEntity = optionalClient.get();
        clientEntity.setName(request.getName());
        clientEntity.setEmail(request.getEmail());
        clientEntity.setAddress(request.getAddress());
        clientEntity.setGender(request.getGender());
        clientEntity = clientRepository.save(clientEntity);
        ClientResponse response = covertEntityToClientResponse(clientEntity);
        log.info(" === Finish api update client, Client Id {} : ", response.getId());
        return response;
    }
    @Override
    public void deleteById(String id) {
        log.info(" === Start api deleteById client === ");
        log.info(" === String id : {} === ", id);
        Optional<ClientEntity> optionalClient= clientRepository.findById(id);
        if (!optionalClient.isPresent()){
            throw new RuntimeException();
        }
        log.info(" Finish api deleteById client, Client Id : {} === ");
        clientRepository.deleteById(id);
    }
}
