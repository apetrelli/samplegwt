#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.ui.impl;

import java.util.Comparator;
import java.util.List;

import com.github.apetrelli.gwtintegration.cellview.client.builder.CellTableWithListDataBuilder;
import com.github.apetrelli.gwtintegration.cellview.client.widget.SimplePagedTable;
import com.github.apetrelli.gwtintegration.mvp.client.ui.impl.AbstractMvpView;
import com.github.apetrelli.gwtintegration.util.shared.ObjectUtils;
import ${package}.module.client.mvp.place.PersonDetailPlace;
import ${package}.module.client.requestfactory.proxy.PersonProxy;
import ${package}.module.client.ui.ListPersonsView;
import ${package}.shared.shared.enums.PersonalTitle;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.ProvidesKey;

public class ListPersonsViewImpl extends AbstractMvpView<ListPersonsView.Presenter> implements ListPersonsView {

    private static ListPersonsViewImplUiBinder uiBinder = GWT
            .create(ListPersonsViewImplUiBinder.class);

    interface ListPersonsViewImplUiBinder extends
            UiBinder<Widget, ListPersonsViewImpl> {
    }

    @UiField(provided=true) SimplePagedTable<PersonProxy> dataTable;

    public ListPersonsViewImpl() {
        CellTableWithListDataBuilder<PersonProxy> builder = CellTableWithListDataBuilder.create();
        builder.createDefaultDataProvider()
                .setKeyProvider(new PersonKeyProvider())
                .createDefaultSelectionModel().addSelectionCellboxColumn()
                .addColumn("Title", new TextColumn<PersonProxy>() {

                    @Override
                    public String getValue(PersonProxy object) {
                        PersonalTitle title = object.getPersonalTitle();
                        return title != null ? title.toString() : "-";
                    }
                }, new Comparator<PersonProxy>() {

                    @Override
                    public int compare(PersonProxy o1, PersonProxy o2) {
                        return ObjectUtils.compare(o1.getPersonalTitle(),
                                o2.getPersonalTitle());
                    }
                })
                .addColumn("Surname", new TextColumn<PersonProxy>() {

                    @Override
                    public String getValue(PersonProxy object) {
                        return object.getLastName();
                    }
                }, new Comparator<PersonProxy>() {

                    @Override
                    public int compare(PersonProxy o1, PersonProxy o2) {
                        return o1.getLastName().compareTo(o2.getLastName());
                    }
                })
                .addColumn("Name", new TextColumn<PersonProxy>() {

                    @Override
                    public String getValue(PersonProxy object) {
                        return object.getFirstName();
                    }
                }, new Comparator<PersonProxy>() {

                    @Override
                    public int compare(PersonProxy o1, PersonProxy o2) {
                        return o1.getLastName().compareTo(o2.getFirstName());
                    }
                }).setCellPreviewHandler(new CellPreviewEvent.Handler<PersonProxy>() {

                    @Override
                    public void onCellPreview(CellPreviewEvent<PersonProxy> event) {
                           String type = event.getNativeEvent().getType();
                           if (type.equals("click")) {
                               presenter.goTo(new PersonDetailPlace(event.getValue().getId()));
                           }
                    }
                });
        dataTable = new SimplePagedTable<PersonProxy>(builder);
        dataTable.setDefaultSortColumnIndex(2);
        dataTable.setPageSize(5);
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPersons(List<PersonProxy> persons) {
        dataTable.setItems(persons);
    }

    private static class PersonKeyProvider implements ProvidesKey<PersonProxy> {

        @Override
        public Object getKey(PersonProxy item) {
            return item.getId();
        }

    }
    @UiHandler("add")
    void onAddClick(ClickEvent event) {
        presenter.goTo(new PersonDetailPlace());
    }
}
