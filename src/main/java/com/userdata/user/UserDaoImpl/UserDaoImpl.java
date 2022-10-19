package com.userdata.user.UserDaoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.tags.form.PasswordInputTag;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.userdata.user.UserDao.UserDao;
import com.userdata.user.model.User;
import com.userdata.user.model.MobileUpdate;
import com.userdata.user.model.Response;
import com.userdata.user.model.User;
@Component
public class UserDaoImpl implements UserDao {
	KeyHolder holder = new GeneratedKeyHolder();

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> findAll() {
		
        String sql = "SELECT * FROM PERSON WHERE deleted = FALSE";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        
        return addUser(rows);
	}

	@Override
	public List<User> findAllById(Integer id) {
		
	        String sql = "SELECT * FROM PERSON WHERE ID= ?";

	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,id);
		        return  addUser(rows);
	        	
	}

	private List<User> addUser(List<Map<String, Object>> rows) {
		
		List<User> users = new ArrayList<>();
		
		for (Map<String, Object> row : rows) {
            
            User user = new User();
            
            user.setId(((int) row.get("id")));
            
            if(row.get("mobile") != null)
            	user.setMobile((String) row.get("mobile"));
            else
            	user.setMobile("1111111111");
           
            if(row.get("age") != null)
            	user.setAge((int) row.get("age"));
            else
            	user.setAge(0);
            
            if(row.get("name") != null)
            	user.setName((String) row.get("name"));
            else
            	user.setMobile("name not set");
            
            if(row.get("email") != null)
            	user.setEmail((String) row.get("email"));
            else
            	user.setMobile("No Email");
            	
            user.setDeleated((boolean) row.get("deleted"));
            if(!user.isDeleted())
            {
            	users.add(user);
            }
        }
		
		return users;
		
	}

	

	@Override
	public int count() {
		// TODO Auto-generated method stub
		System.out.println("its running inside count");
        String sql = "SELECT count(id) FROM PERSON ";
        
        List<Map<String, Object>> res =jdbcTemplate.queryForList(sql);
		return res.size();
	}

	@Override
	public User addPersons(User user) throws Exception {
		
		
		String INSERT_SQL = "INSERT INTO PERSON(name,email,mobile,age,deleted) values(?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL,  new String[]{"id"});
				
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getMobile());
				ps.setInt(4, user.getAge());
				ps.setBoolean(5, user.isDeleted());

				return ps;
			}
		}, holder);

		int newUserId = holder.getKey().intValue();
		user.setId(newUserId);
		return user;
	}
	
	/*
	 * @Override public MobileUpdate updateUserMobile(MobileUpdate mobileUpdate) {
	 * String sql = "UPDATE PERSON SET mobile=? where id=?";
	 * jdbcTemplate.update(sql,mobileUpdate.getId(),mobileUpdate.getMobile());
	 * return mobileUpdate;
	 * 
	 * }
	 */
	
	@Override
	public User updateUserMobile(User user) {
		
		String sql = "UPDATE PERSON SET mobile=? where id=?";
		jdbcTemplate.update(sql,user.getMobile(),user.getId());
		return user;
		
	}
	
	@Override
	public int getUserUpdate(User user, int id) {
		return jdbcTemplate.update("UPDATE PERSON SET name = ?, email = ?, age = ?, mobile = ? WHERE id = ?",
							new Object[] {user.getName(),user.getEmail(),user.getAge(), user.getMobile(), id});
	}
	
	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM PERSON WHERE id=?", id);
	}

	@Override
	public int deleteByIdTrue(User user,int id) {
		
		String sql = "UPDATE PERSON SET deleted=? where id=?";
		int temp = jdbcTemplate.update(sql,user.isDeleted(),id);
		return temp;
		
	}
	
	
//	@Override
//	public MobileUpdate updateUserMobileById(Integer id) {
//		MobileUpdate mobileUpdate = new MobileUpdate();
//		String sql = "UPDATE PERSON SET mobile=? where id=?";
//		jdbcTemplate.update(
//		        sql, 
//		        new Object[] {mobileUpdate.getMobile(), new String("id")});
//		return 	mobileUpdate;
//	}
//
//	@Override
//	public MobileUpdate updateUserMobile(MobileUpdate mobileUpdate) {
//		String sql = "UPDATE PERSON SET mobile=? where id=?";
//		jdbcTemplate.update(sql,mobileUpdate.getMobile(),mobileUpdate.getId());
//		return 	mobileUpdate;
//	}
//	

}
