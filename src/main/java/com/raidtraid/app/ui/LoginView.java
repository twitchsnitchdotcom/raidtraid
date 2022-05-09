package com.raidtraid.app.ui;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Route("login")
@PageTitle("Login | RaidTraid")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
	private static final String OAUTH_URL = "/oauth2/authorize-client/twitch";
	public LoginView(@Autowired Environment env){

		String clientkey = env.getProperty("spring.security.oauth2.client.registration.twitch.client-id");

		// Check that oauth keys are present
		if (clientkey == null || clientkey.isEmpty()) {
			Paragraph text = new Paragraph("Could not find OAuth client key in application.properties. "
					+ "Please double-check the key and refer to the README.md file for instructions.");
			text.getStyle().set("padding-top", "100px");
			add(text);
		} else {
			Anchor loginLink = new Anchor(OAUTH_URL, "Login with TWITCH");
			// Set router-ignore attribute so that Vaadin router doesn't handle the login request
			loginLink.getElement().setAttribute("router-ignore", true);
			loginLink.getStyle().set("margin-top", "100px");
			add(loginLink);
		}

		addClassName("login-view");
		setSizeFull();
		setAlignItems(Alignment.CENTER); 
		setJustifyContentMode(JustifyContentMode.CENTER);

	}

	@Override
	public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
		// inform the user about an authentication error
		if(beforeEnterEvent.getLocation() 
        .getQueryParameters()
        .getParameters()
        .containsKey("error")) {

        }
	}
}