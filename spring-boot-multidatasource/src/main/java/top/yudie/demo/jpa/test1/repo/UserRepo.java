package top.yudie.demo.jpa.test1.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import top.yudie.demo.jpa.test1.entity.User;
@Repository("test1UserRepo")
public interface UserRepo extends CrudRepository<User, String> {
}
