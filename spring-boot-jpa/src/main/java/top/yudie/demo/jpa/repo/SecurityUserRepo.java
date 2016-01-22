package top.yudie.demo.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import top.yudie.demo.jpa.entity.SecurityUser;

public interface SecurityUserRepo extends CrudRepository<SecurityUser, String> {
	/**
	 * 方法名findByuserCode会由jpa框架自动解析，关键词"find"、"By"
	 * @param userCode
	 * @return
	 */
	SecurityUser findByuserCode(String userCode);
	
	/**
	 * 更新方法扩展，需要@Transactional，@Modifying。@Query为hql语句。支持两种参数注入方法
	 */
    @Modifying
    @Transactional
//    @Query("update SecurityUser u set u.userName = :userName where u.userCode = :userCode ")
//    int updateUserNameByUserCode(@Param(value="userCode") String userCode, @Param(value="userName")String userName);
    @Query("update SecurityUser u set u.userName = ?2 where u.userCode = ?1 ")
    int updateUserNameByUserCode(String userCode, String userName);
    
    /**
     * 批量更新方法，未实现
     */
	@Modifying
	@Transactional
	@Query("update SecurityUser u set u.userName = :userName where u.userPwd = :userPwd ")
	int resetUserPwdByUserNames(@Param("userName") List<String> userNames,@Param("userPwd")String userPwd);
}
