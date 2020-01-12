// package netris.sync.configuration;

// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping(value = {"/"})
// @CrossOrigin
// public class HealthCheckController {
    
//     @GetMapping({"/healthcheck","/health"})
    
//     public String healthcheck() {

//         String info = "Service is Running.\r\n<br>"+
//         "Name: "+this.getClass().getPackage().getName()+"\r\n<br>"+
//         "Server time: "+new java.util.Date()+"\r\n<br>";

//         return info;
//     }

// }
