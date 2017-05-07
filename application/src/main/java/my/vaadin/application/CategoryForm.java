package my.vaadin.application;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class CategoryForm extends FormLayout
{		
	private TwinColSelect<String> selections = new TwinColSelect<>("Select category");		
	
	private Button saveCat = new Button("Save"); 
	private Button deleteCat = new Button("Delete");
	private Button editCat = new Button("Edit");
	
	private HotelService service = HotelService.getInstance();
	private Hotel hotel;
	private MyUI myUI;
	
	public CategoryForm(MyUI myUI)
	{
		this.myUI = myUI;
		VerticalLayout layout = new VerticalLayout();
		
		selections.setItems(service.getCategories());			
		
		selections.setDescription("Set hotel's category");
		
		selections.addSelectionListener(event -> {	     
			layout.addComponent(new Label("Selected items: " +
	            event.getNewSelection()));
		});
		
		setSizeUndefined();
		HorizontalLayout buttons = new HorizontalLayout(selections, saveCat, editCat, deleteCat);
		addComponents(selections, buttons);
		
		saveCat.setStyleName(ValoTheme.BUTTON_PRIMARY);
		saveCat.setClickShortcut(KeyCode.ENTER);
		
				
		saveCat.addClickListener(e -> save());
		deleteCat.addClickListener(e -> delete());
		editCat.addClickListener(e -> edit());
	}
	
	private void delete()
	{
		service.delete(hotel);
		myUI.updateList();		
	}
	
	private void save()
	{
		service.save(hotel);
		myUI.updateList();		
	}
	
	private void edit()
	{
		
	}
	
}
