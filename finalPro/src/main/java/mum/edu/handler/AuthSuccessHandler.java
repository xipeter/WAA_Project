package mum.edu.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // Get the role of logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        System.out.println("role is "+ role);

        String redirectUrl = "/login";
        if(role.contains("ROLE_ADMIN")) {
        		System.out.println("role is");
        		redirectUrl = "/admin1";
        } else if(role.contains("ROLE_RESTAURANT")) {
        		redirectUrl = "/restaurant";
        } else if (role.contains("ROLE_DELIVERER")) {
        		redirectUrl = "/rider";
        }
        return redirectUrl;
    }
}
