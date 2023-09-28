package mx.metaphorce.spring.blockbuster.ws.controller;

import mx.metaphorce.spring.blockbuster.ws.domain.GenericResponse;
import mx.metaphorce.spring.blockbuster.ws.service.ActoresService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/actores")
public class ActoresController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ActoresController.class);
    
    @Autowired
    ActoresService ser;
    
    @GetMapping("/getAll")
    public GenericResponse getAll(){
        LOGGER.debug("[INIT CONTROLLER] {}",ActoresController.class.getSimpleName());
        GenericResponse res = ser.getAll();
        LOGGER.info("[NO ERROR CONTROLLER] {}",ActoresController.class.getSimpleName());
        return res;
    }
}
