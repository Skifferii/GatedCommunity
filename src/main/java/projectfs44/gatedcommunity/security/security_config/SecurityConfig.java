package projectfs44.gatedcommunity.security.security_config;


import projectfs44.gatedcommunity.security.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
<<<<<<< HEAD:src/main/java/gatedcommunity/security/security_config/securityConfig.java
=======
public class SecurityConfig {
>>>>>>> origin/dev:src/main/java/projectfs44/gatedcommunity/security/security_config/SecurityConfig.java

public class securityConfig {

    public SecurityConfig(TokenFilter tokenFilter) {
        this.tokenFilter = tokenFilter;
    }

    private final TokenFilter tokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) // настройка сессий
                .httpBasic(AbstractHttpConfigurer::disable) // отключаем базовую аутентификацию
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
<<<<<<< HEAD:src/main/java/gatedcommunity/security/security_config/securityConfig.java
                                .anyRequest().permitAll()
//                                .requestMatchers(HttpMethod.GET, "/hello").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/auth/login", "/auth/refresh").permitAll()
//                                .requestMatchers("/swagger-ui/**", "/v3/api-docs").permitAll()
//                                .requestMatchers(HttpMethod.GET, "/products").permitAll() // разрешено всем
//                                .requestMatchers(HttpMethod.GET, "/products/{id}").authenticated() //  только для аутентифицированных пользователей
////                        .requestMatchers(HttpMethod.GET, "/products/{id}").hasAnyRole("ADMIN", "USER") //  только для пользователей с ролью USER или ADMIN
//                                .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
//                                .anyRequest().authenticated()
=======

//                                .anyRequest().permitAll()
                                .requestMatchers(HttpMethod.GET, "/hello").permitAll()
                                .requestMatchers(HttpMethod.POST, "/register", "/auth/register").permitAll()
                                .requestMatchers(HttpMethod.GET, "/confirm").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/login", "/auth/refresh").permitAll()
                                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/offered-services/{id}").authenticated() //  только для аутентифицированных пользователей
                                .requestMatchers(HttpMethod.POST, "/offered-services").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/offered-services*").authenticated()
//                                .requestMatchers(HttpMethod.GET, "/offered-services*").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/offered-services/update/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/offered-services/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/offered-services/restore/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/offered-services/remove/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/addresses").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.GET, "/addresses/{id}").authenticated()
                                .requestMatchers(HttpMethod.PUT, "/addresses/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/addresses").authenticated()
                                .requestMatchers(HttpMethod.DELETE,"/addresses/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/users/{id}").authenticated()
                                .requestMatchers(HttpMethod.GET,"/users").authenticated()
                                .requestMatchers(HttpMethod.GET, "users/results").authenticated()
                                .requestMatchers(HttpMethod.PUT,"/users/update/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/users{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/users/restore/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/users/remove/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/user-request").authenticated()
                                .requestMatchers(HttpMethod.GET,"/user-requests/{id}").authenticated()
                                .requestMatchers(HttpMethod.GET,"/user-requests").authenticated()
                                .requestMatchers(HttpMethod.PUT,"/user-requests/{id}").authenticated()
                                .requestMatchers(HttpMethod.DELETE,"/user-requests/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/user-requests/restore/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/user-requests/remove/{id}").hasRole("ADMIN")
                                .anyRequest().authenticated()
>>>>>>> origin/dev:src/main/java/projectfs44/gatedcommunity/security/security_config/SecurityConfig.java
                );

        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

/*
Уровни доступа!
1. Получение всех продуктов - доступно всем пользователям, включая анонимных (аутентификация не требуется)
2. Получение продукта по id - доступно только аутентифицированным пользователям с любой ролью
3. Сохранение нового продукта - доступно только администраторам. (аутентифицирован + имеет роль ADMIN)
 */