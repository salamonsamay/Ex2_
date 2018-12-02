package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import Geom.Point3D;

public class GisLayer implements GIS_layer{
	
	private ArrayList<GIS_element> elementList = new ArrayList<GIS_element>();
	
	public Meta_data get_Meta_data() {
		return elementList.get(0).getData();
	}

	@Override
	public int size() {
		return elementList.size();
	}

	@Override
	public boolean isEmpty() {
		return elementList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return elementList.contains(o);
	}

	@Override
	public Iterator<GIS_element> iterator() {
		return elementList.iterator();
	}

	@Override
	public Object[] toArray() {
		return elementList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return elementList.toArray(a);
	}

	@Override
	public boolean add(GIS_element e) {
		return elementList.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return elementList.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return elementList.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		return elementList.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return elementList.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return elementList.removeAll(c);
	}

	@Override
	public void clear() {
		elementList.clear();
	}

}
