package NewsFeed.Handlers;

import NewsFeed.NewsFeed.NewsWebClient.NewsWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.security.Principal;


@Component
public class Handler {

    @Autowired
    NewsWebClient newsWebClient;

    private String NEWS_SOURCES="https://newsapi.org/v2/sources";
    private String API_KEY="X-Api-Key";
    private String API="43a167ad5e5943c386c72685062b81c8";


    public Mono<ServerResponse> newsSources(ServerRequest serverRequest){

        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();

        return newsWebClient.getSources(map).
                flatMap(clientResponse ->
                        ServerResponse.ok().body(clientResponse.bodyToMono(String.class),String.class));
    }

    public Mono<ServerResponse> redirect(ServerRequest serverRequest){
        System.out.println("printing redirect");
        return ServerResponse.permanentRedirect(URI.create("/app/index.html")).build();

    }
}
