package vvithnne.ewallet.bankingservice.config;

import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.setup.ConfigurableMockMvcBuilder;

import java.nio.charset.StandardCharsets;

@Component
public class MockMvcCharacterEncodingCustomizer implements MockMvcBuilderCustomizer {

    @Override
    public void customize(ConfigurableMockMvcBuilder<?> builder) {
        builder.alwaysDo(result ->
                result
                        .getResponse()
                        .setCharacterEncoding(StandardCharsets.UTF_8.name())
        );
    }

}
