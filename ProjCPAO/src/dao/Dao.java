package dao;

public interface Dao<T> {
	public int create(T obj);

	public void delete(T obj);

	public void update(T obj);

	public T getByID(int id);

}