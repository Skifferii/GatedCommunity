package projectfs44.gatedcommunity.security.service;

import projectfs44.gatedcommunity.model.entity.Role;
import projectfs44.gatedcommunity.repository.RoleRepository;
import projectfs44.gatedcommunity.security.AuthInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TokenService {
    private final RoleRepository roleRepository;
    private SecretKey accessKey;
    private SecretKey refreshKey;

    public TokenService(RoleRepository roleRepository,
                        @Value("${key.access}") String accessSecretPhrase,
                        @Value("${key.refresh}") String refreshSecretPhrase) {
        this.roleRepository = roleRepository;
        this.accessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessSecretPhrase));
        this.refreshKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(refreshSecretPhrase));
    }

    public String generateAccessToken(UserDetails user) {
        Instant now = Instant.now();
        Instant expiration = now.plus(1, ChronoUnit.DAYS);
        Date expriationDate = Date.from(expiration);
        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(expriationDate)
                .signWith(accessKey)
                .claim("roles", user.getAuthorities())
                .claim("name", user.getUsername())
                .compact();
    }

    public String generateRefreshToken(UserDetails user) {
        Instant now = Instant.now();
        Instant expiration = now.plus(10, ChronoUnit.DAYS);
        Date expriationDate = Date.from(expiration);
        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(expriationDate)
                .signWith(refreshKey)
                .compact();
    }


    public boolean validateAccessToken(String accessToken) {
        return validateToken(accessToken, accessKey);
    }

    public boolean validateRefreshToken(String refreshToken) {
        return validateToken(refreshToken, refreshKey);
    }

    private boolean validateToken(String token, SecretKey key) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims (String token, SecretKey key){
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    public Claims getAccessClaims (String accessToken){
        return getClaims(accessToken, accessKey);
    }

    public Claims getRefreshClaims (String refreshToken){
        return getClaims(refreshToken, refreshKey);
    }

    public AuthInfo mapClaimsToAuthInfo (Claims claims) {
        //username
        //roles
        String username = claims.getSubject();

        @SuppressWarnings("unchecked")
        List <Map<String, String>> roles = (List<Map<String, String>>) claims.get("roles", List.class);

        Set<Role> authorities = roles.stream()
                .map(m ->m.get("authority"))
                .map(s -> roleRepository.findByTitle(s).orElseThrow(RuntimeException::new))
                .collect(Collectors.toSet());
        return new AuthInfo(username, authorities);

    }

}


