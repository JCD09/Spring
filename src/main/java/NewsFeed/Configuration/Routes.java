package NewsFeed.Configuration;


import NewsFeed.Handlers.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> simpleRoute(Handler handler){

            return nest(path("/news"),route(method(GET), handler::newsSources)).
                    andRoute(path("/").and(method(GET)),handler::redirect)
                    .and(resources("/**", new ClassPathResource("/")));
    }
}
