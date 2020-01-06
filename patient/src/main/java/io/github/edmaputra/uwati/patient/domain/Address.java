package io.github.edmaputra.uwati.patient.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class Address extends io.github.edmaputra.edtmplte.domain.Address<String> {

    public Address(
            @NotBlank(message = "Street Name Cannot Null or Empty") String street,
            @NotBlank(message = "City Name Cannot Null or Empty") String city,
            @NotBlank(message = "Province Name Cannot Null or Empty") String province,
            @NotBlank(message = "Zip Code Name Cannot Null or Empty") String zipCode,
            @NotBlank(message = "Country Name Cannot Null or Empty") String country) {
        super(street, city, province, zipCode, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
