package top.gsc.framework.common.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger配置
 *
 * @author mqxu
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"top.gsc"};
        return GroupedOpenApi.builder().group("GscCloud")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("2813314009@qq.com.com");

        return new OpenAPI().info(new Info()
                .title("GscCloud")
                .description("GscCloud")
                .contact(contact)
                .version("1.0")
                .termsOfService("https://gsc.top")
                .license(new License().name("MIT")
                        .url("https://gsc.top")));
    }

}
