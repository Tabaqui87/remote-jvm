package it.tabaqui.jmx;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementazione di HeapManagerMBean: gli oggetti aggiunti tramite il metodo "push" avranno una dimensione di 1MB
 */
public class HeapManager implements HeapManagerMBean {
	
	// Static fields
	
	private static final int OBJECT_SIZE = 1024 * 1024;
	
	// Fields
	
	private List<Object> data = new ArrayList<>();
	
	// Getters/setters
	
	@Override
	public int getSize() {
		return data.size();
	}
	
	// Methods
	
	@Override
	public void push(int count) {
		if (count < 1) {
			throw new IllegalArgumentException("Il numero di oggetti da aggiungere dev'essere maggiore di zero!");
		}
		for (int i = 0; i < count; i++) {
			data.add(new byte[OBJECT_SIZE]);
		}
	}
	
	@Override
	public void free() {
		data.clear();
	}
}
