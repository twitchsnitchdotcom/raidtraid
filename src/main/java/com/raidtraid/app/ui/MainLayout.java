package com.raidtraid.app.ui;

import com.raidtraid.app.data.UserSession;
import com.raidtraid.app.data.service.DataService;
import com.raidtraid.app.security.SecurityService;
import com.raidtraid.app.ui.list.ListView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinServletRequest;
import de.mekaso.vaadin.addons.Carousel;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
@CssImport(value = "./styles/components/app-layout.css", themeFor = "vaadin-app-layout")
public class MainLayout extends AppLayout {

    private final SecurityService securityService;
    private final DataService dataService;

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 465;
    private static final int HEIGHT = 275;
    private static final int OFFSET = 20;
    private static final int DEFAULT_ELEMENTS = 3;


    private IntegerField numberOfElements;
    private RadioButtonGroup<String> orientation;
    private Button nextButton;
    private Button prevButton;
    private ComboBox<Integer> directNavi;
    private Checkbox autoplay;

    private static final String LOGOUT_SUCCESS_URL = "";

    UserSession userSession;

    public MainLayout(SecurityService securityService, UserSession userSession, DataService dataService) {
        this.securityService = securityService;
        this.userSession = userSession;
        this.dataService = dataService;
        createHeader();
        addToDrawer(createDrawer());
        setDrawerOpened(true);

    }

//    private Div createSimpleDiv(Integer value) {
//        Div content = new Div();
//        IFrame iframe = new IFrame("https://player.twitch.tv/?channel=" + dataService.getRaidFinder().getData().get(value).getUrl() + "&parent=localhost");
//        iframe.setWidth("465px");
//        iframe.setHeight("275px");
//        content.add(iframe);
////		content.add(new H1(channels[value]));
//        return content;
//    }




    private void createHeader() {

        H1 logo = new H1("Vaadin CRM");
        logo.addClassNames("text-l", "m-m");

        Button logout = new Button("Log out", e -> securityService.logout());
//        Image logo = new Image("https://sullygnome.com/Images/gnome.png", "Logo");
//                Button logoutButton = new Button("Logout", click -> {
//            UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
//            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
//            logoutHandler.logout(
//                    VaadinServletRequest.getCurrent().getHttpServletRequest(), null,
//                    null);
//        });
//        logo.setWidth(100, Unit.PIXELS);
//        logo.setHeight(50, Unit.PIXELS);
//        logo.setMaxWidth(100, Unit.PIXELS);
//        logo.setMaxHeight(50, Unit.PIXELS);

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);

    }

    private VerticalLayout createDrawer() {

        VerticalLayout verticalLayout = new VerticalLayout();
        Div div = new Div();
        div.setText("Hello " + userSession.getUser().getUsername());
        div.getElement().getStyle().set("font-size", "xx-large");
        div.getElement().getStyle().set("padding-bottom","10px");

//        Carousel carousel = Carousel.create();
//        carousel.setWidth(WIDTH + "px");
//        carousel.setHeight(HEIGHT + "px");
//        for (int i = 1; i <= DEFAULT_ELEMENTS; i++) {
//            carousel.add(createSimpleDiv(i));
//        }
//
//        this.numberOfElements = new IntegerField();
//        numberOfElements.setValue(DEFAULT_ELEMENTS);
//        numberOfElements.setHasControls(true);
//        numberOfElements.setMin(3);
//        numberOfElements.setMax(12);
//        numberOfElements.setLabel("Elements");
//
//        this.nextButton = new Button(VaadinIcon.CARET_SQUARE_RIGHT_O.create(), click -> {
//            carousel.next();
//        });
//        this.prevButton = new Button(VaadinIcon.CARET_SQUARE_LEFT_O.create(), click -> {
//            carousel.prev();
//        });
//        this.directNavi = new ComboBox<>("Direct Navigation");
//        this.directNavi.setItems(IntStream.rangeClosed(1, (int) carousel.getChildren().count()).boxed().collect(Collectors.toList()));
//        this.directNavi.setValue(Integer.valueOf(1));
//        this.directNavi.addValueChangeListener(change -> {
//            if (this.directNavi.getValue() != null) {
//                int index = this.directNavi.getValue() - 1;
//                //Component targetComponent = carousel.getChildren().collect(Collectors.toList()).get(index);
//                //carousel.show(targetComponent);
//                carousel.show(index);
//            }
//        });
//        this.autoplay = new Checkbox("Autoplay");
//        autoplay.addValueChangeListener(valueChange -> {
//            if (autoplay.getValue() != null && autoplay.getValue()) {
//                carousel.withAutoplay();
//            } else {
//                carousel.stop();
//            }
//        });
//
//        Button infoButton = new Button("Info", (clickEvent) -> {
//            String message = String.format("There is a %s (index %s) on center stage",
//                    carousel.getSelectedComponent().getClass().getSimpleName(),
//                    carousel.getSelectedIndex());
//            Notification.show(message);
//        });
//
//        com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(prevButton, nextButton, directNavi, autoplay, infoButton);
//        section.setTitle("Server side controls");
//        VerticalLayout vl = new VerticalLayout(section);
//        vl.setSizeUndefined();


        //super.getStyle().set("justify-content", "space-evenly");
        //super.getStyle().set("flex-direction", "column");

        //verticalLayout.add(div, vl, carousel);
        verticalLayout.add(div);

        return verticalLayout;
    }

}
