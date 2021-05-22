package ro.sd.a2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.Exception.NullFieldException;
import ro.sd.a2.Mappers.UserMapper;
import ro.sd.a2.controller.FirstController;
import ro.sd.a2.entity.UserProfile;
import ro.sd.a2.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO logIn(UserDTO user){
        return UserMapper.mapUserToDTO(userRepository.getUserProfileByEmailAndPassword(user.getEmail(),user.getPassword()));
    }

    public List<UserDTO> getAllUsersAdmin() {
        List<UserDTO> userDTOS = new ArrayList<>();
         List<UserProfile> users = userRepository.findAll();
         for(UserProfile user:users){
             if(!user.isPermission())
                userDTOS.add(UserMapper.mapUserToDTO(user));
         }
         return userDTOS;
    }

    public Boolean saveUser(UserDTO userDto){
        if(userDto.getFirstName().equals("") || userDto.getFirstName() == null){
            throw new NullFieldException("Field first name is not completed!");
        }
        if(userDto.getLastName().equals("") || userDto.getLastName() == null){
            throw new NullFieldException("Field last name is not completed!");
        }
        if(userDto.getEmail().equals("") || userDto.getEmail() == null){
            throw new NullFieldException("Field email is not completed!");
        }
        if(userDto.getPassword().equals("") || userDto.getPassword() == null){
            throw new NullFieldException("Field password is not completed!");
        }
        if(userDto.getDateOfBirth() ==  null){
            throw new NullFieldException("Field date is not completed!");
        }
        userRepository.save(UserMapper.mapDTOToUser(userDto));
        return true;
    }

    public UserDTO getUserByID(String id) {
        return UserMapper.mapUserToDTO(userRepository.getUserProfileById(id));
    }

    public Boolean updateUser(UserDTO userDto){
        UserProfile userProfile = userRepository.getUserProfileById(userDto.getId());
        if(userDto.getFirstName().equals("") || userDto.getFirstName() == null){
            log.info("Field first name is not completed!");
        }else {
            userProfile.setFirstName(userDto.getFirstName());
        }
        if(userDto.getLastName().equals("") || userDto.getLastName() == null){
            log.info("Field last name is not completed!");
        }else{
            userProfile.setLastName(userDto.getLastName());
        }
        if(userDto.getPassword().equals("") || userDto.getPassword() == null){
            log.info("Field password is not completed!");
        }else{
            userProfile.setPassword(userDto.getPassword());
        }
        if(userDto.getDateOfBirth() ==  null){
            log.info("Field date is not completed!");
        }else{
            userProfile.setBirthDate(userDto.getDateOfBirth());
        }

        userRepository.save(userProfile);
        return true;
    }
}
