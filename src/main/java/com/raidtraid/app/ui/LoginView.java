package com.raidtraid.app.ui;

import com.infraleap.animatecss.Animated;
import com.raidtraid.app.data.service.DataService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.mekaso.vaadin.addons.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Route("login")
@PageTitle("Login | RaidTraid")
public class LoginView extends VerticalLayout implements BeforeEnterObserver, Animated {

	private static final String OAUTH_URL = "/oauth2/authorize-client/twitch";
	private final DataService dataService;

	private static final int WIDTH = 465;
	private static final int HEIGHT = 275;
	private static final int OFFSET = 20;
	private static final int DEFAULT_ELEMENTS = 3;

	public LoginView(@Autowired Environment env, DataService dataService){

		this.dataService = dataService;
		add(logoLayout());
		addAnimations();
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

	public void addAnimations(){

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setWidthFull();
		horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);

		HorizontalLayout sandbox = new HorizontalLayout();
		sandbox.add(new H1(dataService.getHomePage().getAverageChannels()));

		horizontalLayout.add(sandbox);
		add(horizontalLayout);

		Button nextButton = new Button("Next Animation");
		add(nextButton);

		ComboBox<Animated.Animation> comboBox = new ComboBox<>();
		comboBox.setItems(Animated.Animation.values());
		comboBox.setItemLabelGenerator(Enum::name);
		comboBox.setWidth("300px");
		add(comboBox);

		ComboBox<Animated.Modifier> modifierComboBox = new ComboBox<>();
		modifierComboBox.setItems(Animated.Modifier.values());
		modifierComboBox.setItemLabelGenerator(Enum::name);
		modifierComboBox.setValue(Animated.Modifier.REPEAT_1);
		modifierComboBox.setWidth("300px");
		add(modifierComboBox);

		nextButton.addClickListener( e -> {
			int nextOrdinal = (comboBox.getValue().ordinal() + 1) % Animated.Animation.values().length;
			comboBox.setValue(Animated.Animation.values()[nextOrdinal]);
		});
		comboBox.addValueChangeListener(event -> {
			Animated.animate(sandbox, event.getValue(), modifierComboBox.getValue());
		});
		modifierComboBox.addValueChangeListener (event-> {
			Animated.animate(sandbox, comboBox.getValue(), event.getValue());
		} );

		comboBox.setValue(Animated.Animation.ROLL_IN);

	}

	public void generateAnnimatedComponents(){

		Carousel carousel = Carousel.create();
		carousel.setWidth(WIDTH + "px");
		carousel.setHeight(HEIGHT + "px");
		for (int i = 1; i <= DEFAULT_ELEMENTS; i++) {
			carousel.add(createSimpleDiv(i));
		}

		add(carousel);

		//summary stats


		//Most Watched Channels

		//Most Watched Games

		//Trending Games

		//Fastest Growing Channels

		//Most Streamed Games

		//Most Viewed Streams
	}

	private Div createSimpleDiv(Integer value) {
		Div content = new Div();
		IFrame iframe = new IFrame("https://player.twitch.tv/?channel=" + dataService.getRaidFinder().getData().get(value).getUrl() + "&parent=localhost");
		iframe.setWidth("465px");
		iframe.setHeight("275px");
		content.add(iframe);
//		content.add(new H1(channels[value]));
		return content;
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