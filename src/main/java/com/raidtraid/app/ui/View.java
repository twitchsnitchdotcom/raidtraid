//package com.raidtraid.app.ui;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import com.raidtraid.app.data.UserSession;
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.checkbox.Checkbox;
//import com.vaadin.flow.component.combobox.ComboBox;
//import com.vaadin.flow.component.html.*;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.component.orderedlayout.FlexLayout;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
//import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
//import com.vaadin.flow.component.textfield.IntegerField;
//import com.vaadin.flow.component.textfield.PasswordField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.server.VaadinServletRequest;
//import de.mekaso.vaadin.addons.Carousel;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//
//
//import javax.annotation.security.PermitAll;
//
//@Route("")
//@PermitAll
//public class View extends FlexLayout {
//	private static final long serialVersionUID = 1L;
//
//	private static final String[] channels = {"trainwreckstv", "emiru", "noway4u_sir", "silvername"};
//	private static final String BACKGROUND = "hsla(%s, 100%%, 50%%, 0.8)";
//	private static final String IMAGE_URL = "https://picsum.photos/%s/%s?random=%s";
//	private static final int WIDTH = 600;
//	private static final int HEIGHT = 400;
//	private static final int OFFSET = 20;
//	private static final int DEFAULT_ELEMENTS = 3;
//
//	private enum ElementType {
//		Simple, Image, Form
//	}
//	private RadioButtonGroup<ElementType> elementTypeRadioButtonGroup;
//	private IntegerField numberOfElements;
//	private RadioButtonGroup<String> orientation;
//	private Button nextButton;
//	private Button prevButton;
//	private ComboBox<Integer> directNavi;
//	private Checkbox autoplay;
//
//	    private static final String LOGOUT_SUCCESS_URL = "";
//
//	public View(UserSession userSession) {
//        Div div = new Div();
//        div.setText("Hello " + userSession.getUser().getUsername());
//        div.getElement().getStyle().set("font-size", "xx-large");
//        this.setHeight("100%");
//        this.setWidth("100%");
//        Button logoutButton = new Button("Logout", click -> {
//            UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
//            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
//            logoutHandler.logout(
//                    VaadinServletRequest.getCurrent().getHttpServletRequest(), null,
//                    null);
//        });
//		add(div);
//		add(logoutButton);
//		super.setAlignItems(Alignment.CENTER);
//		super.setHeightFull();
//        Carousel carousel = Carousel.create();
//        carousel.setWidth(WIDTH + "px");
//        carousel.setHeight(HEIGHT + "px");
//        for (int i = 1; i <= DEFAULT_ELEMENTS; i++) {
//        	carousel.add(createSimpleDiv(i));
//        }
//        add(carousel);
//        this.elementTypeRadioButtonGroup = new RadioButtonGroup<>();
//        elementTypeRadioButtonGroup.setLabel("Element Type");
//        elementTypeRadioButtonGroup.setItems(ElementType.values());
//        elementTypeRadioButtonGroup.setValue(ElementType.Simple);
//        elementTypeRadioButtonGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
//        this.numberOfElements = new IntegerField();
//        numberOfElements.setValue(DEFAULT_ELEMENTS);
//        numberOfElements.setHasControls(true);
//        numberOfElements.setMin(3);
//        numberOfElements.setMax(12);
//        numberOfElements.setLabel("Elements");
//        numberOfElements.addValueChangeListener(valueChange -> {
//        	if (valueChange.getValue().compareTo(valueChange.getOldValue()) > 0) {
//        		switch (elementTypeRadioButtonGroup.getValue()) {
//					case Simple:
//						carousel.add(createSimpleDiv(valueChange.getValue()));
//						break;
//					case Image:
//						Image image = new Image(String.format(IMAGE_URL, WIDTH - OFFSET, HEIGHT - OFFSET, System.currentTimeMillis()), "A Random Image");
//						image.setTitle(String.format("A random Image (%s * %s) from picsum.photos", WIDTH, HEIGHT));
//						image.addClickListener(click -> UI.getCurrent().getPage().open("https://picsum.photos/"));
//						carousel.add(image);
//						break;
//					case Form:
//						carousel.add(createLoginForm());
//						break;
//					default:
//						break;
//				}
//        	} else {
//        		Component lastComponent = carousel.getChildren().skip(carousel.getChildren().count() - 1).findFirst().get();
//        		carousel.remove(lastComponent);
//        	}
//        	this.directNavi.setItems(IntStream.rangeClosed(1, (int)carousel.getChildren().count()).boxed().collect(Collectors.toList()));
//        	this.directNavi.setValue(Integer.valueOf(1));
//        });
//
//        this.orientation = new RadioButtonGroup<>();
//        orientation.setLabel("Orientation");
//        orientation.setItems("horizontal", "vertical");
//        orientation.setValue("horizontal");
//        orientation.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
//        orientation.addValueChangeListener(change -> {
//        	boolean horizontal = orientation.getValue().equals("horizontal");
//        	carousel.withHorizontalOrientation(horizontal);
//        	String direction = horizontal ? "column" : "row";
//        	super.getStyle().set("flex-direction", direction);
//        	});
//
//        this.nextButton = new Button(VaadinIcon.CARET_SQUARE_RIGHT_O.create(), click -> {
//        	carousel.next();
//        });
//        this.prevButton = new Button(VaadinIcon.CARET_SQUARE_LEFT_O.create(), click -> {
//        	carousel.prev();
//        });
//        this.directNavi = new ComboBox<>("Direct Navigation");
//        this.directNavi.setItems(IntStream.rangeClosed(1, (int)carousel.getChildren().count()).boxed().collect(Collectors.toList()));
//        this.directNavi.setValue(Integer.valueOf(1));
//        this.directNavi.addValueChangeListener(change -> {
//        	if (this.directNavi.getValue() != null) {
//        		int index = this.directNavi.getValue() - 1;
//        		//Component targetComponent = carousel.getChildren().collect(Collectors.toList()).get(index);
//        		//carousel.show(targetComponent);
//        		carousel.show(index);
//        	}
//        });
//        this.autoplay = new Checkbox("Autoplay");
//        autoplay.addValueChangeListener(valueChange -> {
//        	if (autoplay.getValue() != null && autoplay.getValue()) {
//        		carousel.withAutoplay();
//        	} else {
//        		carousel.stop();
//        	}
//        });
//
//        Button infoButton = new Button("Info", (clickEvent) -> {
//        	String message = String.format("There is a %s (index %s) on center stage",
//        			carousel.getSelectedComponent().getClass().getSimpleName(),
//        			carousel.getSelectedIndex());
//        	Notification.show(message);
//        });
//
//        Section section = new Section(prevButton, nextButton, directNavi, autoplay, infoButton);
//        section.setTitle("Server side controls");
//        HorizontalLayout controls = new HorizontalLayout(numberOfElements, elementTypeRadioButtonGroup, orientation);
//        VerticalLayout vl = new VerticalLayout(controls, section);
//        vl.setSizeUndefined();
//        add(vl);
//
//        super.getStyle().set("justify-content", "space-evenly");
//        super.getStyle().set("flex-direction", "column");
//
//	//	add(addChart());
//    }
//
//	/**
//	 * A simple div with a text.
//	 */
//	private Div createSimpleDiv(Integer value) {
//		Div content = new Div();
//		IFrame iframe = new IFrame("https://player.twitch.tv/?channel=" + channels[value] + "&parent=localhost");
//        iframe.setWidth("600px");
//        iframe.setHeight("400px");
//		content.add(iframe);
////		content.add(new H1(channels[value]));
//		return content;
//	}
//
//	/**
//	 * A simple login form.
//	 */
//	private VerticalLayout createLoginForm() {
//		VerticalLayout loginForm = new VerticalLayout();
//		loginForm.setSizeUndefined();
//		loginForm.getStyle().set("background", "whitesmoke");
//		loginForm.setMargin(true);
//		loginForm.add(new TextField("Username"), new PasswordField("Password"), new Button("Login"));
//		loginForm.getStyle().set("border", "1px solid #efefef");
//		return loginForm;
//	}
//
////	private ChartJs addChart(){
////		BarChartConfig config = new BarChartConfig();
////		config
////				.data()
////				.labels("January", "February", "March", "April", "May", "June", "July")
////				.addDataset(new BarDataset().type().label("Dataset 1").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
////				.addDataset(new LineDataset().type().label("Dataset 2").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
////				.addDataset(new BarDataset().type().label("Dataset 3").backgroundColor("rgba(220,220,220,0.5)"))
////				.and();
////
////		config.
////				options()
////				.responsive(true)
////				.title()
////				.display(true)
////				.position(Position.LEFT)
////				.text("Chart.js Combo Bar Line Chart")
////				.and()
////				.done();
////
////		List<String> labels = config.data().getLabels();
////		for (Dataset<?, ?> ds : config.data().getDatasets()) {
////			List<Double> data = new ArrayList<>();
////			for (int i = 0; i < labels.size(); i++) {
////				data.add((double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100));
////			}
////
////			if (ds instanceof BarDataset) {
////				BarDataset bds = (BarDataset) ds;
////				bds.dataAsList(data);
////			}
////
////			if (ds instanceof LineDataset) {
////				LineDataset lds = (LineDataset) ds;
////				lds.dataAsList(data);
////			}
////		}
////
////		ChartJs chart = new ChartJs(config);
////		//chart.setJsLoggingEnabled(true);
////
////		return chart;
////	}
//}