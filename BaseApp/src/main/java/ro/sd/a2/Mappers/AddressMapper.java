package ro.sd.a2.Mappers;

import ro.sd.a2.DTO.AddressDto;
import ro.sd.a2.entity.Address;

public class AddressMapper {
   public static AddressDto mapAddressToDTO(Address address){
       return AddressDto.builder().apartment(address.getApartment())
               .id(address.getId())
               .houseHoldNumber(address.getHouseHoldNumber())
               .floor(address.getFloor())
               .street(address.getStreet())
               .city(address.getCity())
               .building(address.getBuilding()).build();

   }

    public static AddressDto mapAddressToDTOSimple(Address address){
        return AddressDto.builder()
                .id(address.getId())
                .houseHoldNumber(address.getHouseHoldNumber())
                .street(address.getStreet())
                .city(address.getCity()).build();
    }

    public static Address mapDTOToAddress(AddressDto addressDto) {
        return Address.builder().apartment(addressDto.getApartment())
                .id(addressDto.getId())
                .houseHoldNumber(addressDto.getHouseHoldNumber())
                .floor(addressDto.getFloor())
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .building(addressDto.getBuilding()).build();
    }
    public static Address mapDTOToAddressSimple(AddressDto addressDto) {
        return Address.builder().id(addressDto.getId())
                .houseHoldNumber(addressDto.getHouseHoldNumber())
                .street(addressDto.getStreet())
                .city(addressDto.getCity()).build();
    }


}
