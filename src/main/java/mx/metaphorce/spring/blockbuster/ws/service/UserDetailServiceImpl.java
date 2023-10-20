package mx.metaphorce.spring.blockbuster.ws.service;

import java.util.HashSet;
import java.util.Set;
import mx.metaphorce.spring.blockbuster.ws.model.Usuario;
import mx.metaphorce.spring.blockbuster.ws.repository.UsuariosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuariosRepository userRepository;
    
    private static final Logger LOG = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.login(username);
        if(user==null||user.getUsername()==null){
            throw new UsernameNotFoundException("Not exist");
        }
        Set < GrantedAuthority > grantedAuthorities = new HashSet < > ();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRol()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), 
                "{noop}"+user.getPassword(),
        
            grantedAuthorities);
    }
}