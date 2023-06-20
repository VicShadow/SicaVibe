package sicavibe.sicavibeapp;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.orm.PersistentException;
import org.orm.*;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SicaVibeErrorController implements ErrorController {


    @Hidden
    @RequestMapping(value = "/error",produces = MediaType.TEXT_HTML_VALUE)
    public String handleError(HttpServletRequest request, Model model) {
        Object code = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        String errorMsg = "N/A";
        String errorException = "N/A";

        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        if (message != null){
            errorMsg = message.toString();
        }

        Object exception = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        if (exception != null){
            errorException = exception.toString();
        }

        model.addAttribute("errorCode",code);
        model.addAttribute("errorMsg",errorMsg);
        model.addAttribute("errorException",errorException);


        if (code != null) {
            Integer statusCode = Integer.valueOf(code.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }

        return "error";
    }


}

