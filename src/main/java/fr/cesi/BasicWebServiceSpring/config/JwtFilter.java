package fr.cesi.BasicWebServiceSpring.config;

import fr.cesi.BasicWebServiceSpring.http.ErrorResponse;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean {

    /**
     * This filter is executed on each incoming http request and before the controller execution.
     * It verifies the presence of the token and it's conformity.
     * @param req Incoming http request
     * @param res Response object
     * @param chain event request handler
     * @throws IOException
     * @throws ServletException 
     */
    //TODO verify token by retrieving user from database directly
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(req, res);
        } else {

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("Missing or invalid Authorization header");
            }

            final String token = authHeader.substring(7);

            try {
                final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
                request.setAttribute("claims", claims);
            } catch (final SignatureException e) {
                setUnauthorizedResponse(response);
                return;
            } catch (final Exception e) {
                setUnauthorizedResponse(response);
                return;
            }

            chain.doFilter(req, res);
        }
    }

    /**
     * This method is used to override the default response and return a 401 unauthorized response to the client.
     * @param response 
     */
    public void setUnauthorizedResponse(HttpServletResponse response) {
        ErrorResponse error = new ErrorResponse(HttpStatus.UNAUTHORIZED, "Invalid token");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.println(error.toString());
        } catch (IOException ex) {
            Logger.getLogger(JwtFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
