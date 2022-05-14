package com.martinnnachi.ecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // protect the endpoint /api/orders
        http.authorizeRequests()
                .antMatchers( "/api/orders/**" )
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

        // add support for cors filters
        http.cors();

        // force a non-empty response body for 401s to make the response more friendly
        Okta.configureResourceServer401ResponseBody( http );

        // disable CSRF since we're not using cookies for sessions tracking
        http.csrf().disable();

    }
}
