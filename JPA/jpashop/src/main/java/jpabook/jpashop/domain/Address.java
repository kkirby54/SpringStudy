package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

// 값을 생성할 때만 넣어주고, setter는 못하게 막아두는 게 바람직한 설계
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
