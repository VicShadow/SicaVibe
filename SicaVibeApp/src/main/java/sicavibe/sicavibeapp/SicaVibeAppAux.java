package sicavibe.sicavibeapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SicaVibeAppAux {

    public static void checkRequestContent(List<String> desiredKeySet, Map<String,Object> content){
        for (String s : desiredKeySet){
            if (!content.containsKey(s)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Key-value '"+s+"' missing.");
            }
        }
    }


}
