package Aibles_Training.java.client1.service;

import Aibles_Training.java.client1.dto.request.ClientRequest;
import Aibles_Training.java.client1.dto.response.ClientResponse;

public interface ClientService {
    ClientResponse create (ClientRequest request);
}