package it.pkg.module.client.ui.impl;

import java.util.Comparator;
import java.util.List;

import it.pkg.module.client.mvp.place.PersonDetailPlace;
import it.pkg.module.client.requestfactory.proxy.PersonProxy;
import it.pkg.module.client.ui.ListPersonsView;
import com.github.apetrelli.gwtintegration.mvp.client.ui.impl.AbstractMvpView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class ListPersonsViewImpl extends AbstractMvpView<ListPersonsView.Presenter> implements ListPersonsView {

	private static ListPersonsViewImplUiBinder uiBinder = GWT
			.create(ListPersonsViewImplUiBinder.class);

	interface ListPersonsViewImplUiBinder extends
			UiBinder<Widget, ListPersonsViewImpl> {
	}
	
	@UiField(provided=true) CellTable<PersonProxy> dataTable;
	
	@UiField SimplePager pager;
	
	private ListDataProvider<PersonProxy> dataProvider;
	
	private Column<PersonProxy, String> defaultSortColumn;

	public ListPersonsViewImpl() {
		dataTable = new CellTable<PersonProxy>(new PersonKeyProvider());
		initWidget(uiBinder.createAndBindUi(this));
		buildTable();
	}

	@Override
	public void setPersons(List<PersonProxy> persons) {
		List<PersonProxy> list = dataProvider.getList();
		list.clear();
		list.addAll(persons);
		dataProvider.flush();
		ColumnSortList sortList = dataTable.getColumnSortList();
		sortList.clear();
		sortList.push(defaultSortColumn);
		
		pager.setDisplay(dataTable);
		pager.setPage(0);
	}
	
	private void buildTable() {
		TextColumn<PersonProxy> nameColumn = new TextColumn<PersonProxy>() {

			@Override
			public String getValue(PersonProxy object) {
				return object.getLastName()
						+ ", "
						+ (object.getPersonalTitle() != null ? object
								.getPersonalTitle().toString() + " " : "")
						+ object.getFirstName();
			}
		};
		nameColumn.setSortable(true);
		dataTable.addColumn(nameColumn, "Name");
		dataProvider = new ListDataProvider<PersonProxy>();
		dataProvider.addDataDisplay(dataTable);
		buildSortHandler(nameColumn);
		defaultSortColumn = nameColumn;
		pager.setDisplay(dataTable);
		dataTable.addCellPreviewHandler(new CellPreviewEvent.Handler<PersonProxy>() {

			@Override
			public void onCellPreview(CellPreviewEvent<PersonProxy> event) {
				   String type = event.getNativeEvent().getType();
                   if (type.equals("click")) {
                	   presenter.goTo(new PersonDetailPlace(event.getValue().getId()));
                   }
            }
		});
		dataProvider.flush();
	}
	private void buildSortHandler(TextColumn<PersonProxy> nameColumn) {
		ListHandler<PersonProxy> handler = new ListHandler<PersonProxy>(dataProvider.getList());
		handler.setComparator(nameColumn, new Comparator<PersonProxy>() {
			
			@Override
			public int compare(PersonProxy o1, PersonProxy o2) {
				return o1.getLastName().compareToIgnoreCase(o2.getLastName());
			}
		});
		dataTable.addColumnSortHandler(handler);
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
