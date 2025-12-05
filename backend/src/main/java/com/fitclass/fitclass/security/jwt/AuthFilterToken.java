package com.fitclass.fitclass.security.jwt;

import com.fitclass.fitclass.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.websphere.WebSpherePreAuthenticatedWebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthFilterToken extends OncePerRequestFilter {

  @Autowired
  private JwtUtils jwtUtil;

  @Autowired
  private UserDetailsServiceImpl userDetailService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      String jwt = getToken(request);

      if (jwt == null) {
        filterChain.doFilter(request, response);
        System.out.println("token vazio");
        return;
      }

      if(jwtUtil.validateJwtToken(jwt)) {
        System.out.println("token recebido: " + jwt);

        String username = jwtUtil.getUsernameToken(jwt);
        System.out.println("capturado username: "+ username);

        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        System.out.println("capturado userDetails: "+ userDetails);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,  null, userDetails.getAuthorities());
        System.out.println("capturado auth: "+ auth);
        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    }catch(Exception e) {
      System.out.println("Ocorreu um erro ao proecssar o token: " + e.getMessage());
    }finally {

    }

    filterChain.doFilter(request, response);
  }

  private String getToken(HttpServletRequest request) {
    String headerToken = request.getHeader("Authorization");

    if (StringUtils.hasText(headerToken) && headerToken.startsWith("Bearer ")) {
      return headerToken.substring(7); // 7 = tamanho de "Bearer "
    }

    return null;
  }


}
