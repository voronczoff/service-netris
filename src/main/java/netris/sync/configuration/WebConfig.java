// package netris.sync.configuration;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// @EnableWebMvc
// // @componentscan(basePackages =
// // {"com.haizhi.dao","com.haizhi.controll","com.haizhi.service"})
// public class WebConfig implements WebMvcConfigurer {

//     @Value("https://" + "${BPM_HOST}")
//     private List<String> domains;

//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {

//     registry
//         .addResourceHandler("swagger-ui.html")
//         .addResourceLocations("classpath:/META-INF/resources/");

//     registry
//         .addResourceHandler("/webjars/**")
//         .addResourceLocations("classpath:/META-INF/resources/webjars/");

//     //System.out.println("CORS enabled domains: " + domains.toString());
    
//     }


//     @Override
//     public void addCorsMappings(CorsRegistry registry) {

//         if (domains.contains("https://intranet.rnd-env.com") || domains.contains("https://localhost:8080")) {
//             domains.add("http://localhost:8080");
//         }

//         registry.addMapping("/**").allowedOrigins(domains.toArray(new String[domains.size()])).allowedMethods("*");

//         System.out.println("CORS enabled domains: " + domains.toString());

//     }

// }