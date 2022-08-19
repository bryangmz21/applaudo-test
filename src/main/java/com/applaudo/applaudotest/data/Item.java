package com.applaudo.applaudotest.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {

    @Id
    private int itemId;

    private String itemName;

    private String itemEnteredByUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date itemEnteredDate;

    private Double itemBuyingPrice;

    private Double itemSellingPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date itemLastModifiedDate;

    private String itemLastModifiedByUser;

    private String itemStatus;


}
