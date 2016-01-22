package top.yudie.demo.jpa.test1.repo;

import org.springframework.data.repository.CrudRepository;

import top.yudie.demo.jpa.test1.entity.SecurityUser;

public interface SecurityUserRepo extends CrudRepository<SecurityUser, String> {
}
