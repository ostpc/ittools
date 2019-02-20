package ua.org.ostpc.ittools.service;


import ua.org.ostpc.ittools.entity.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}
