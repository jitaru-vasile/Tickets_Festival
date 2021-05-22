package ro.sd.a2.Mappers;

import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.entity.UserProfile;

public class UserMapper {
    public static UserDTO mapUserToDTO(UserProfile userProfile){
        UserDTO  userDTO= UserDTO.builder().id(userProfile.getId())
                                    .firstName(userProfile.getFirstName())
                                    .lastName(userProfile.getLastName())
                                    .email(userProfile.getEmail())
                                    .permission(userProfile.isPermission())
                                    .dateOfBirth(userProfile.getBirthDate())
                                    .password(userProfile.getPassword())
                                    .addressDto(AddressMapper.mapAddressToDTO(userProfile.getAddress()))
                .build();
        return userDTO;

    }
    public static UserProfile mapDTOToUser(UserDTO userDTO){
        return UserProfile.builder().id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .permission(userDTO.isPermission())
                .password(userDTO.getPassword())
                .birthDate(userDTO.getDateOfBirth())
                .address(AddressMapper.mapDTOToAddress(userDTO.getAddressDto()))
                .build();
    }

}
