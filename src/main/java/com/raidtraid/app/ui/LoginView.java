package com.raidtraid.app.ui;

import com.infraleap.animatecss.Animated;
import com.raidtraid.app.data.service.DataService;
import com.raidtraid.app.dto.homepage.HomePageDTO;
import com.raidtraid.app.dto.homepage.HomePageElementDTO;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.mekaso.vaadin.addons.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Route("login")
@PageTitle("Login | RaidTraid")
public class LoginView extends VerticalLayout implements BeforeEnterObserver, Animated {

	private static final String OAUTH_URL = "/oauth2/authorize-client/twitch";
	private final DataService dataService;

	private static final int WIDTH = 1000;
	private static final int HEIGHT = 400;
	private static final int OFFSET = 20;
	private static final int DEFAULT_ELEMENTS = 3;

	private List<Grid> gridList = new ArrayList<>();

	public LoginView(@Autowired Environment env, DataService dataService){

		this.dataService = dataService;
		add(logoLayout());
		addAnimations();
			Image loginImage = new Image("images/login-30.png", "Login With Twitch");
			Anchor loginLink = new Anchor(OAUTH_URL, "");
			// Set router-ignore attribute so that Vaadin router doesn't handle the login request
			loginLink.getElement().setAttribute("router-ignore", true);
			loginLink.getStyle().set("margin-top", "50px");
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

		horizontalLayout.add(sandbox);
		add(horizontalLayout);
		generateAnnimatedComponents();

	}

	public void generateAnnimatedComponents(){

		Carousel carousel = Carousel.create().withAutoplay().withDuration(3, TimeUnit.SECONDS);;
		carousel.setWidth(WIDTH + "px");
		carousel.setHeight(HEIGHT + "px");
		for (int i = 1; i <= DEFAULT_ELEMENTS; i++) {
			carousel.add(createGrid());
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

	public void createGridList(){
		HomePageDTO homePage = dataService.getHomePage();
		gridList.add(createGrid(homePage.getFastestGrowingChannels()));
	}

	public Grid createGrid(List<HomePageElementDTO> items){
		Grid<HomePageElementDTO> grid = new Grid<>(HomePageElementDTO.class, false);
		grid.setSelectionMode(Grid.SelectionMode.MULTI);
		grid.addColumn(createEmployeeRenderer()).setHeader("Employee")
				.setAutoWidth(true).setFlexGrow(0);
		grid.addColumn(HomePageElementDTO::getPercentageChange).setHeader("Change%")
				.setAutoWidth(true);
		grid.addColumn(createStatusComponentRenderer()).setHeader("Status")
				.setAutoWidth(true);
		grid.setItems(items);
		return grid;

	}
	private static ComponentRenderer<Span, HomePageElementDTO> createStatusComponentRenderer() {
		return new ComponentRenderer<>(Span::new, statusComponentUpdater);
	}
	private static Renderer<HomePageElementDTO> createEmployeeRenderer() {
		return LitRenderer.<HomePageElementDTO>of(
						"<vaadin-horizontal-layout style=\"align-items: center;\" theme=\"spacing\">"
								+ "<vaadin-avatar img=\"${item.image}\" name=\"${item.name}\" alt=\"User avatar\"></vaadin-avatar>"
								+ "  <vaadin-vertical-layout style=\"line-height: var(--lumo-line-height-m);\">"
								+ "    <span> ${item.name} </span>"
								+ "    <span style=\"font-size: var(--lumo-font-size-s); color: var(--lumo-secondary-text-color);\">"
								+ "      ${item.email}" + "    </span>"
								+ "  </vaadin-vertical-layout>"
								+ "</vaadin-horizontal-layout>")
				.withProperty("pictureUrl", HomePageElementDTO::getImage)
				.withProperty("fullName", HomePageElementDTO::getName)
				.withProperty("value", HomePageElementDTO::getValue);
	}

	private static final SerializableBiConsumer<Span, HomePageElementDTO> statusComponentUpdater = (span, element) -> {
		boolean isAvailable = "Available".equals(element.getKey());
		String theme = String
				.format("badge %s", isAvailable ? "success" : "error");
		span.getElement().setAttribute("theme", theme);
		span.setText(element.getKey());
	};



	private Div createSimpleDiv(Integer value) {
		Div content = new Div();
		IFrame iframe = new IFrame("https://player.twitch.tv/?channel=" + dataService.getRaidFinder().getData().get(value).getUrl() + "&parent=localhost");
		iframe.setWidth(WIDTH + "px");
		iframe.setHeight(HEIGHT + "px");
		content.add(new H1(dataService.getRaidFinder().getData().get(value).getUrl()));
		content.add(iframe);
//
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