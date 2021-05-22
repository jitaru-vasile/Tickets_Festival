package ro.sd.a2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTO.AddressDto;
import ro.sd.a2.Exception.NullFieldException;
import ro.sd.a2.Mappers.AddressMapper;
import ro.sd.a2.controller.FirstController;
import ro.sd.a2.entity.Address;
import ro.sd.a2.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    public final AddressRepository addressRepository;

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void saveAddress(AddressDto dto){
        if(dto.getCity().equals("") || dto.getCity() == null)
        {
            throw new NullFieldException("Field city not completed");
        }
        if(dto.getHouseHoldNumber().equals("") || dto.getHouseHoldNumber() == null)
        {
            throw new NullFieldException("Field household number not completed");
        }
        if(dto.getStreet().equals("") || dto.getStreet() == null)
        {
            throw new NullFieldException("Field street not completed");
        }
        if(dto.getApartment().equals("") || dto.getApartment() == null)
        {
            throw new NullFieldException("Field apartment not completed");
        }
        if(dto.getBuilding().equals("") || dto.getBuilding() == null)
        {
            throw new NullFieldException("Field city not completed");
        }
        if(dto.getFloor().equals("") || dto.getFloor() == null)
        {
            throw new NullFieldException("Field floor not completed");
        }

        addressRepository.save(AddressMapper.mapDTOToAddress(dto));

    }
//pune warning
    //Apache utils StringUtils.isNotEmpty()
    public void updateAddress(AddressDto dto) {
        Address address = addressRepository.getOneById(dto.getId());

        if(dto.getCity().equals("") || dto.getCity() == null)
        {
            log.info("Field city not completed");
        }
        else{
            address.setCity(dto.getCity());
        }
        if(dto.getHouseHoldNumber().equals("") || dto.getHouseHoldNumber() == null)
        {
            log.info("Field household number not completed");
        }else{
            address.setHouseHoldNumber(dto.getHouseHoldNumber());
        }
        if(dto.getStreet().equals("") || dto.getStreet() == null)
        {
            log.info("Field street not completed");
        }else {

            address.setStreet(dto.getStreet());
        }
        if(dto.getApartment().equals("") || dto.getApartment() == null)
        {
            log.info("Field apartment not completed");
        }else{
            address.setApartment(dto.getApartment());
        }
        if(dto.getBuilding().equals("") || dto.getBuilding() == null)
        {
            log.info("Field city not completed");
        }else {
            address.setBuilding(dto.getBuilding());
        }
        if(dto.getFloor().equals("") || dto.getFloor() == null)
        {
            log.info("Field floor not completed");
        }else {
            address.setFloor(dto.getFloor());
        }
        addressRepository.save(address);

    }
}
