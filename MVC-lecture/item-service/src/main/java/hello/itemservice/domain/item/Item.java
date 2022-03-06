package hello.itemservice.domain.item;

import lombok.Data;

// @Data. 좀 위험함. 주의 필요
// @Getter @Setter
@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
