package ua.service;

import ua.entity.User;

public interface UserService {
	User findOne(int id);
	void save(User user);
	User findByName(String username);
	User findByUsername(String username);
	User findByEmail(String email);
	void sendMail(String content, String email, String mailBody);
}
