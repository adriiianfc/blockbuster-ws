package mx.metaphorce.spring.blockbuster.ws.service;

import java.util.List;
import mx.metaphorce.spring.blockbuster.ws.domain.GenericResponse;
import mx.metaphorce.spring.blockbuster.ws.model.Actor;
import mx.metaphorce.spring.blockbuster.ws.repository.ActoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActoresService {
    @Autowired
    ActoresRepository repo;
    
    public GenericResponse getAll(){
        List<Actor> actores = repo.getAll();
        GenericResponse res = new GenericResponse(200, "Correct", actores);
        return res;
    }
}
