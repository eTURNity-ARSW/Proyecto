package edu.eci.arsw.Eturnity.cache;

import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioCache {
    private static Map<String, Usuario> userMap = new HashMap<String, Usuario>();

    public Usuario getCacheUser(String username) {
        synchronized (userMap) {
            System.out.println("cache");
            return userMap.get(username);
        }
    }

    public boolean findUser(String username) {
        synchronized (userMap) {
            return userMap.containsKey(username);
        }
    }

    public void addUserCache(Usuario user){
        synchronized (userMap){
            userMap.put(user.getUsername(),user);
            userMap.forEach((key, value) -> System.out.println(key + ":" + value));

        }
    }
}