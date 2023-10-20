package mx.metaphorce.spring.blockbuster.ws.service;

import java.util.List;
import mx.metaphorce.spring.blockbuster.ws.domain.GenericResponse;
import mx.metaphorce.spring.blockbuster.ws.model.Actor;
import mx.metaphorce.spring.blockbuster.ws.repository.ActoresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActoresService {
    @Autowired
    ActoresRepository repo;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ActoresService.class);
    
    public GenericResponse getAll(){
        List<Actor> actores = repo.getAll();
        GenericResponse res = new GenericResponse(200, "Correct", actores);
        LOGGER.info("LOG TEST");
        try{
        
        }catch(Exception e){
            LOGGER.error("LOG TEST ERROR");
        }
        
        return res;
    }
}
