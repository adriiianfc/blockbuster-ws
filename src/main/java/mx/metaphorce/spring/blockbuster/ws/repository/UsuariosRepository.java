package mx.metaphorce.spring.blockbuster.ws.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mx.metaphorce.spring.blockbuster.ws.model.Actor;
import mx.metaphorce.spring.blockbuster.ws.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuariosRepository {
    @Autowired
    JdbcTemplate jdbc;
    
    public List<Usuario> getAll(){
        String sqlQuery = "SELECT * FROM blockbuster.usuarios";
        List<Map<String, Object>> resDB = jdbc.queryForList(sqlQuery);
        List<Usuario> usuarios = new ArrayList<>();
        for(Map<String, Object> res : resDB){
            Usuario usu = new Usuario();
            usu.setId(Integer.parseInt(res.get("id").toString()));
            usu.setUsername(res.get("username").toString());
            usu.setPassword(res.get("password").toString());
            usu.setRol(res.get("rol").toString());
            usuarios.add(usu);
        }
        return usuarios;
    }
    
    public Usuario login(String username){
        String sqlQuery = "SELECT * FROM blockbuster.usuarios where username = '"+username+"'";
        List<Map<String, Object>> resDB = jdbc.queryForList(sqlQuery);
        Usuario usu = null;
        for(Map<String, Object> res : resDB){
            usu = new Usuario();
            usu.setId(Integer.parseInt(res.get("id").toString()));
            usu.setUsername(res.get("username").toString());
            usu.setPassword(res.get("password").toString());
            usu.setRol(res.get("rol").toString());
        
        }
        return usu;
    }
}
