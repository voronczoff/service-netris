package netris.sync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import netris.sync.model.CameraAssembled;
import netris.sync.service.CameraService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = { "/api", "/" })
@CrossOrigin
public class CameraController {

    @Autowired
    private CameraService cameraService;

    // @GetMapping(value = "/cameras", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @GetMapping(value = "/cameras")
    public Flux<CameraAssembled> GetCameras() {
        return cameraService.getCameraAssembled();
    }

}
