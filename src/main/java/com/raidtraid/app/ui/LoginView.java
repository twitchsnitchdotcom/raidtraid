package com.raidtraid.app.ui;

import com.raidtraid.app.data.service.DataService;
import com.vaadin.flow.component.UI;
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
import de.mekaso.vaadin.addon.compani.AnimatedComponent;
import de.mekaso.vaadin.addon.compani.Animator;
import de.mekaso.vaadin.addon.compani.animation.Animation;
import de.mekaso.vaadin.addon.compani.animation.AnimationBuilder;
import de.mekaso.vaadin.addon.compani.animation.AnimationTypes;
import de.mekaso.vaadin.addon.compani.effect.HideEffect;
import de.mekaso.vaadin.addon.compani.effect.ShowEffect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Route("login")
@PageTitle("Login | RaidTraid")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

	final Animator animator = Animator.init(UI.getCurrent());
	private static final String OAUTH_URL = "/oauth2/authorize-client/twitch";

	private final DataService dataService;

	public LoginView(@Autowired Environment env, DataService dataService){

		H1 headline = new H1("Text Animations");

		AnimatedComponent animatedLabel = animator.prepareComponent(headline);

		Animation hideAnimation = AnimationBuilder
				.createBuilder()
				.create(AnimationTypes.HideAnimation.class)
				.withEffect(HideEffect.powerOff);
		animatedLabel.animateAndHide(hideAnimation);

		Animation showAnimation = AnimationBuilder
				.createBuilder()
				.create(AnimationTypes.ShowAnimation.class)
				.withEffect(ShowEffect.powerOn);
		animatedLabel.showAnimated(showAnimation);

		this.dataService = dataService;
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
		add(headline);

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