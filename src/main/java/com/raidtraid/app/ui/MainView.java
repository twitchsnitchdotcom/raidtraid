//
//package com.raidtraid.app.ui;
//
//import com.raidtraid.app.data.UserSession;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.html.IFrame;
//import com.vaadin.flow.component.html.Image;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.server.VaadinServletRequest;
//import de.mekaso.vaadin.addons.Carousel;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//
//import javax.annotation.security.PermitAll;
//import java.util.concurrent.TimeUnit;
//
///**
// * Application main class that is hidden to user before authentication.
// *
// * The class is annotated with {@code @PermitAll} to allow only authenticated
// * users to view the class.
// */
//@Route("")
//@PermitAll
//public class MainView extends VerticalLayout {
//
//    private static final String LOGOUT_SUCCESS_URL = "";
//
//    public MainView(UserSession userSession) {
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
//
//        setAlignItems(Alignment.CENTER);
//        add(div, logoutButton, addCarousel());
//    }
//
//    public Carousel addCarousel() {
//        Div div = new Div();
//        Carousel carousel = Carousel.create()
//                .withAutoplay()
//                .withDuration(30, TimeUnit.SECONDS);
//// adjust the width and height (optionally)
//        carousel.setWidth("500px");
//        carousel.setHeight("500px");
//        carousel.withBorder();
//        IFrame iframe = new IFrame("https://player.twitch.tv/?channel=ninja&parent=localhost");
//        iframe.setWidth("500px");
//        iframe.setHeight("500px");
//        div.add(iframe);
//        carousel.add(div);
//        Image image = new Image("https://picsum.photos/600/400", "A Random Image");
//        image.setHeight("0px");
//        image.setWidth("0px");
//        carousel.add(image);
//        return carousel;
//    }
//
//    public IFrame getIframe(){
//        IFrame iframe = new IFrame("https://player.twitch.tv/?channel=ninja&parent=localhost");
//        iframe.setWidth("1000px");
//        iframe.setHeight("1000px");
//        return iframe;
//    }
//
//    public IFrame getIframe2(){
//        IFrame iframe = new IFrame("https://player.twitch.tv/?channel=ninja&parent=localhost");
//        iframe.setWidth("100%");
//        iframe.setHeight("100%");
//        return iframe;
//    }
//}
