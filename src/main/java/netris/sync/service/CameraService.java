package netris.sync.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import netris.sync.model.CameraList;
import netris.sync.model.CameraAssembled;
import netris.sync.model.CameraToken;
import netris.sync.model.CameraURL;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class CameraService {

    private WebClient webClient = WebClient.create();
    public static final String cameraListURL = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";

    public Flux<CameraList> getCameraList(String url) {
        return webClient.get().uri(url).retrieve().bodyToFlux(CameraList.class);
    }

    public Mono<CameraURL> getCameraURL(String url) {
        return webClient.get().uri(url).retrieve().bodyToMono(CameraURL.class);
    }

    public Mono<CameraToken> getCameraToken(String url) {
        return webClient.get().uri(url).retrieve().bodyToMono(CameraToken.class);
    }

    public Flux<CameraAssembled> getCameraAssembled() {

        Flux<CameraList> cameras = getCameraList(cameraListURL);

        Flux<CameraAssembled> camerasAssembled = cameras.parallel().runOn(Schedulers.elastic()).flatMap(r -> {

            Mono<CameraToken> cameraToken = getCameraToken(r.getTokenDataUrl()).subscribeOn(Schedulers.elastic());
            Mono<CameraURL> cameraURL = getCameraURL(r.getSourceDataUrl()).subscribeOn(Schedulers.elastic());

            return Mono.zip(Mono.just(r), cameraToken, cameraURL).flatMap(m -> {

                CameraAssembled c = new CameraAssembled();

                c.setId(m.getT1().getId());

                c.setValue(m.getT2().getValue());
                c.setTtl(m.getT2().getTtl());

                c.setUrlType(m.getT3().getUrlType());
                c.setVideoUrl(m.getT3().getVideoUrl());

                return Mono.just(c);

            });

        }).ordered((u1, u2) -> u1.getId() - u2.getId()); // ordering be turned off for streaming

        return camerasAssembled;

    }

}
