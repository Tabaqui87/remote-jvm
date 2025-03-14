package it.tabaqui.jmx;

/**
 * MBean responsabile di riempire/svuotare la heap memory al bisogno
 */
public interface HeapManagerMBean {
	
	// Getters/setters
	
	/**
	 * Restituisce il numero di oggetti in memoria
	 * @return
	 */
	public int getSize();
	
	// Methods
	
	/**
	 * Aggiunge oggetti in memoria
	 * @param count Numero di oggetti che verranno aggiunti
	 */
	public void push(int count);
	
	/**
	 * Aggiunge un oggetto in memoria
	 */
	public default void push() {
		push(1);
	}
	
	/**
	 * Rimuove tutti gli oggetti precedentemente aggiunti dalla memoria (senza eseguire GC)
	 */
	public void free();
}
