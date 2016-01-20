package top.yudie.demo.jpa.repo;

import org.springframework.data.repository.CrudRepository;

import top.yudie.demo.jpa.entity.User;

public interface UserRepo extends CrudRepository<User, String> {
}
