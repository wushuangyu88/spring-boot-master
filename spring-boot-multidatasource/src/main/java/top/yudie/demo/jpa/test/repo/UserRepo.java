package top.yudie.demo.jpa.test.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import top.yudie.demo.jpa.test.entity.User;
@Repository("testUserRepo")
public interface UserRepo extends CrudRepository<User, String> {
}
