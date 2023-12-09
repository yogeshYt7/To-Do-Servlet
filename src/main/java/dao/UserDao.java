package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.catalina.User;

import dto.Task;
import dto.UserDto;

public class UserDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

	//saving user
	public void saveUser(UserDto dto) {
		manager.getTransaction().begin();
		manager.persist(dto);
		manager.getTransaction().commit();
	}
	//finding user by email
	public UserDto findByEmail(String email) {
		Query query = manager.createQuery("select x from UserDto x where email=?1").setParameter(1, email);
		List<UserDto> list = query.getResultList();
		if (!list.isEmpty())
			return list.get(0);
		else
			return null;
	}

	//saving task
	public void saveTask(Task task) {
		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();
	}
	//updating user
	public void updateUser(UserDto dto) {
		manager.getTransaction().begin();
		manager.merge(dto);
		manager.getTransaction().commit();
	}
	public Task findTaskById(int id) {
		return manager.find(Task.class, id);
	}
	public void updateTask(Task task) {
		manager.getTransaction().begin();
		manager.merge(task);
		manager.getTransaction().commit();
	}
	
	public UserDto findById(int id)
	{
		return manager.find(UserDto.class, id);
	}
	public void deleteTask(Task task) {
		manager.getTransaction().begin();
		manager.remove(task);
		manager.getTransaction().commit();
	}
}
