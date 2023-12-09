package service;

import dao.UserDao;
import dto.Task;
import dto.UserDto;
import helper.AES;

public class UserService {

	public boolean saveUser(UserDto dto) {
		// checking age
		if (dto.getAge() < 18)
			return false;
		else {
			UserDao dao = new UserDao();
			UserDto dto1 = dao.findByEmail(dto.getEmail());
			// checking email is repeated
			if (dto1 != null)
				return false;
			else {
				// encrypting password
				dto.setPassword(AES.encrypt(dto.getPassword(), "123"));
				dao.saveUser(dto);
				return true;
			}
		}
	}

	public boolean login(String email, String password) {
		UserDao dao = new UserDao();
		UserDto dto = dao.findByEmail(email);
		// checking email
		if (dto == null)
			return false;
		else {
			// checking password
			// decrypting password
			if (password.equals(AES.decrypt(dto.getPassword(), "123")))
				return true;
			else
				return false;
		}
	}

	public void saveTask(Task task) {
		UserDao dao = new UserDao();
		dao.saveTask(task);
	}

	public void updateUser(UserDto dto) {
		UserDao dao = new UserDao();
		dao.updateUser(dto);
	}

	public void changeStatus(int id) {
		UserDao dao = new UserDao();
		Task task = dao.findTaskById(id);
		task.setStatus(true);
		dao.updateTask(task);
	}

	public void deleteTask(int id, UserDto dto) {
		UserDao dao = new UserDao();
		Task task = dao.findTaskById(id);
		if (task != null) {
			Task task3 = null;
			for (Task task2 : dto.getTasks()) {
				if (task2.getId() == task.getId()) {
					task3 = task2;
				}
			}
			dto.getTasks().remove(task3);
			dao.updateUser(dto);
			// delete task
			dao.deleteTask(task);
		}
	}

	public void updateTask(Task task) {
		UserDao dao = new UserDao();
		dao.updateTask(task);
	}

}
