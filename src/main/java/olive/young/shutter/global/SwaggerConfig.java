package olive.young.shutter.global;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "OliveYoung 셔터 Spring Server API 명세서",
                description = "셔터 서비스 API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {

}
