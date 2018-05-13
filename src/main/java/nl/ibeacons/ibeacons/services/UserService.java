package nl.ibeacons.ibeacons.services;

import nl.ibeacons.ibeacons.entity.User;
import nl.ibeacons.ibeacons.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;

	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
}
