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

    public static class BaseHeader{
        String token;

        public String getToken() {
            return token;
        }
    }

    public static void checkRequestContent(List<String> desiredKeySet, Map<String,Object> content){
        for (String s : desiredKeySet){
            if (!content.containsKey(s)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Key-value '"+s+"' missing.");
            }
        }
    }

    public static <T> List<T> paging(List<T> globalList, int page,int pageSize){

        if(page <= 0 || pageSize <= 0)
            throw new NumberFormatException("Invalid Page or PageSize");

        int startIndex = (page-1) * pageSize;
        int endIndex = startIndex + pageSize;
        int listSize = globalList.size();

        if (startIndex > listSize-1) startIndex = listSize;
        if (endIndex > listSize) endIndex = listSize;

        return globalList.subList(startIndex,endIndex);
    }


}
