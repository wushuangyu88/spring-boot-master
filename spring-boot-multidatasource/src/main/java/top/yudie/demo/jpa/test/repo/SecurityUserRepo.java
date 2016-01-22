package top.yudie.demo.jpa.test.repo;

import org.springframework.data.repository.CrudRepository;

import top.yudie.demo.jpa.test.entity.SecurityUser;

public interface SecurityUserRepo extends CrudRepository<SecurityUser, String> {
}
