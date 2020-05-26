package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.User;

public interface UserDAO {
	public List<User> list();
	public void saveorUpdateUser (User user);
	public void deleteUser(int idUser);
	public User getIdUser(int idUser);

}
 