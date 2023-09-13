package tdtu.edu.ex01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CusErrorController implements ErrorController {
    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String messageErr = "";
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                messageErr = "error 404";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                // handle HTTP 403 Forbidden error
                messageErr = "error 403";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                messageErr = "error 500";
            }
        }
        model.addAttribute("messageErr",messageErr);
        return "errorPage";
    }
}
