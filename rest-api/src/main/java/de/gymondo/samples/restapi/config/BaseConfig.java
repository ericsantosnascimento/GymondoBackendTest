package de.gymondo.samples.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Application base configuration.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
@Configuration
@Import({MvcConfig.class})
public class BaseConfig {
}
