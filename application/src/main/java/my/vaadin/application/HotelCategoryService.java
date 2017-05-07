/*package my.vaadin.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotelCategoryService 
{
	private static final Logger LOGGER = Logger.getLogger(HotelCategoryService.class.getName());

	private final Set<String> categorys = new HashSet<>();
	
	private static HotelCategoryService instance;
	private final HashMap<Long, Hotel> hotels = new HashMap<>();
	private long nextId = 0;
	
	private void HotelCategoryService() {}
	
	public static HotelCategoryService getInstance()
	{
		if (instance == null) {
			instance = new HotelCategoryService();
			instance.ensureTestData();
		}
		return instance;
	}
	
	public synchronized Set<String> getCategories() {
		return categorys;
	}
	
	public synchronized List<Hotel> findAll() {
		return findAll(null);
	}
	
	public synchronized List<Hotel> findAll(String stringFilter) {
		ArrayList<Hotel> arrayList = new ArrayList<>();
		for (Hotel hotel : hotels.values()) {
			try {
				boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
						|| hotel.toString().toLowerCase().contains(stringFilter.toLowerCase());
				if (passesFilter) {
					arrayList.add(hotel.clone());
				}
			} catch (CloneNotSupportedException ex) {
				Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		Collections.sort(arrayList, new Comparator<Hotel>() {

			@Override
			public int compare(Hotel o1, Hotel o2) {
				return (int) (o2.getId() - o1.getId());
			}
		});
		return arrayList;
	}
	
	public synchronized void save(Hotel entry) {
		if (entry == null) {
			LOGGER.log(Level.SEVERE, "Hotel is null.");
			return;
		}
		if (entry.getId() == null) {
			entry.setId(nextId++);
		}
		try {
			entry = (Hotel) entry.clone();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		categorys.put(entry.getId(), entry);
	}
	
	public void ensureTestData() {
		if (findAll(null).isEmpty()) {
			final String[] categoryData = new String[] {
					"Hotel;" };

			Random r = new Random(0);
			for (String categorys : categoryData) {
				String[] split = categorys.split(";");
				HotelCategory c = new HotelCategory();				
				//c.setHotelCategory(split[0]);							
				//h.setCategory(HotelCategory.values()[r.nextInt(HotelCategory.values().length)]);
				//h.setHotelCategory(HotelCategory.contains()[r.nextInt(HotelCategory.contains().length)]);		
				//save(c);
			}
		}
	}
}
*/