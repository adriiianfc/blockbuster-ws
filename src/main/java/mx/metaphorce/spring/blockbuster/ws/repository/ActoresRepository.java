package mx.metaphorce.spring.blockbuster.ws.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mx.metaphorce.spring.blockbuster.ws.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ActoresRepository {
    @Autowired
    JdbcTemplate jdbc;
    
    public List<Actor> getAll(){
        String sqlQuery = "SELECT * FROM blockbuster.actores";
        List<Map<String, Object>> resDB = jdbc.queryForList(sqlQuery);
        List<Actor> actores = new ArrayList<>();
        for(Map<String, Object> res : resDB){
            Actor actor = new Actor();
            actor.setId(Integer.parseInt(res.get("id").toString()));
            actor.setNombre(res.get("nombre").toString());
            actores.add(actor);
        }
        return actores;
    }
}
