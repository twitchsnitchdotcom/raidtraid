package com.raidtraid.app.ui;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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

		add(logoLayout());
			Image loginImage = new Image("images/login-30.png", "Login With Twitch");

			Anchor loginLink = new Anchor(OAUTH_URL, "");
			// Set router-ignore attribute so that Vaadin router doesn't handle the login request
			loginLink.getElement().setAttribute("router-ignore", true);
			loginLink.getStyle().set("margin-top", "100px");
			loginLink.add(loginImage);
			add(loginLink);

		addClassName("login-view");
		setSizeFull();
		setAlignItems(Alignment.CENTER); 
		setJustifyContentMode(JustifyContentMode.CENTER);

	}

	public HorizontalLayout logoLayout(){
		HorizontalLayout layout = new HorizontalLayout();
		Image logoImage = new Image("images/logo-65	.png", "RaidTrad");
		layout.add(logoImage);
		return layout;
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