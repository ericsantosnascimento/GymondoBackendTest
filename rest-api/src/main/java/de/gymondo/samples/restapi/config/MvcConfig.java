package de.gymondo.samples.restapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * MVC Configuration.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
@Configuration
@ComponentScan("de.gymondo")
@EnableWebMvc
public class MvcConfig {
}
