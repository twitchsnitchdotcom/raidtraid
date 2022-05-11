package com.raidtraid.app.ui.list;

import com.raidtraid.app.data.service.CrmService;
import com.raidtraid.app.data.service.DataService;
import com.raidtraid.app.dto.raidfinder.Datum;
import com.raidtraid.app.dto.raidfinder.RaidFindersDTO;
import com.raidtraid.app.ui.MainLayout;
import com.vaadin.componentfactory.timeline.Timeline;
import com.vaadin.componentfactory.timeline.model.Item;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Component
@Scope("prototype")
@Route(value="", layout = MainLayout.class)
@PageTitle("Dashboard | Vaadin CRM")
@PermitAll
public class ListView extends VerticalLayout {

    CrmService service;

    DataService raidService;

    Grid<Datum> grid = new Grid<>(Datum.class, false);

    public ListView(CrmService service, DataService raidService) {

        this.service = service;
        this.raidService = raidService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        add(new H3("Stream Timeline"), addTimeLine(), new H3("Suggested Raiders"), this.grid);
        updateList();
    }

    private void configureGrid() {
        RaidFindersDTO raidFindersDTO = this.raidService.getRaidFinder();
        grid.addClassNames("contact-grid");
        grid.setSizeFull();

        //grid.setColumns("liveMinutes", "liveViewers");
        Grid.Column<Datum> datumColumn = grid.addComponentColumn(i -> {
            Image image = new Image(i.getLogo(), "alt text");
            image.setHeight("50px");
            image.setWidth("50px");
            return image;
        }).setHeader("Image");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.setColumnOrder(datumColumn);
        grid.setItems(new ListDataProvider<>(raidFindersDTO.getData()));
    }


    private void updateList() {

    }

private Timeline addTimeLine(){
    // create items
    Item item1 = new Item(LocalDateTime.of(2021, 8, 11, 2, 30, 00),
            LocalDateTime.of(2021, 8, 11, 8, 00, 00), "Item 1");
    item1.setId("1");

    Item item2 = new Item(LocalDateTime.of(2021, 8, 11, 9, 00, 00),
            LocalDateTime.of(2021, 8, 11, 17, 00, 00), "Item 2");
    item2.setId("2");

    Item item3 = new Item(LocalDateTime.of(2021, 8, 12, 0, 30, 00),
            LocalDateTime.of(2021, 8, 12, 3, 00, 00), "Item 3");
    item3.setId("3");

    Item item4 = new Item(LocalDateTime.of(2021, 8, 12, 4, 30, 00),
            LocalDateTime.of(2021, 8, 12, 20, 00, 00), "Item 4");
    item4.setId("4");

    Item item5 = new Item(LocalDateTime.of(2021, 8, 12, 21, 30, 00),
            LocalDateTime.of(2021, 8, 13, 01, 15, 00), "Item 5");
    item5.setId("5");

    List<Item> items = Arrays.asList(item1, item2, item3, item4, item5);

    // make items readonly
    items.forEach(i -> i.setEditable(false));

    // create timeline
    Timeline timeline = new Timeline(items);

    // set timeline range
    timeline.setTimelineRange(LocalDateTime.of(2021, 8, 10, 00, 00, 00),
            LocalDateTime.of(2021, 8, 15, 00, 00, 00));

    return timeline;
}

}
