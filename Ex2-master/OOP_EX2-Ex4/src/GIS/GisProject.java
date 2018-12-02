package GIS;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GisProject implements GIS_project {
	private ArrayList<GIS_layer> projectList = new ArrayList();

    @Override
    public Meta_data get_Meta_data() {
        return projectList.get(0).get_Meta_data();
    }

    @Override
    public int size() {
        return projectList.size();
    }

    @Override
    public boolean isEmpty() {
        return projectList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return projectList.contains(o);
    }

    @Override
    public Iterator<GIS_layer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return projectList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return projectList.toArray(a);
    }
    @Override
    public boolean remove(Object o) {
        return projectList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return projectList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends GIS_layer> c) {
        return false;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return projectList.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return projectList.removeAll(c);
    }

    @Override
    public void clear() {
    	projectList.clear();
    }

	@Override
	public boolean add(GIS_layer e) {
		return projectList.add(e);
	}
}
