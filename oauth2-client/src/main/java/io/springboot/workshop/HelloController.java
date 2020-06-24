package io.springboot.workshop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@EnableOAuth2Sso
public class HelloController extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private OAuth2ClientContext clientContext;
	
	@Autowired
    private OAuth2RestTemplate oauth2RestTemplate;	
	

    @GetMapping("/hello")
    public ModelAndView home(){
          
    		OAuth2AccessToken oAuth2AccessToken = clientContext.getAccessToken();
    		
    		
    		String resourceRetrieved = oauth2RestTemplate.getForObject("https://urdomain.ice.ibmcloud.com/oidc/endpoint/default/userinfo", String.class);
            Map<String,Object> model = new HashMap<String,Object>();
            model.put("token", oAuth2AccessToken.getValue());
           model.put("userInfo", resourceRetrieved);
            
            return new ModelAndView("views/home",model);
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/login**")
			.permitAll()
			.anyRequest()
			.authenticated();
	}

}
