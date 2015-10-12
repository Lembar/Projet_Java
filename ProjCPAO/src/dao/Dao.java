package dao;

public interface Dao<T> {
	public void create(T obj);

	public void delete(T obj);

	public void update(T obj);

	public T getByID(int id);

}