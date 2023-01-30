package com.example.digitopia.task.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitopia.task.DataAccess.IUserDal;
import com.example.digitopia.task.Entities.User;

@Service
public class UserManager implements IUserService  {

	private IUserDal userDal;
	
	@Autowired
	public UserManager(IUserDal userDal) {
		this.userDal = userDal;
	}

	@Override
	public User getById(int id) {
		
		return userDal.getById(id);
	}

	@Override
	public void add(User user) {
		userDal.add(user);
		/*boolean isExistUser = isExist(user);
		System.out.println("AddedUser: "+ isExistUser);
		if(isExistUser) {
			return null;
		}

		userDal.add(user);
		User addedUser = getById(user.getId());
		return addedUser;
		*/
	}

	@Override
	public void update(User user) {
		userDal.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDal.delete(user);
		
	}

	@Override
	public List<User> getUsersByNormalizedName(String normalizedName) {
		
		return userDal.getUsersByNormalizedName(normalizedName);
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userDal.getUserByEmail(email);
	}

}
