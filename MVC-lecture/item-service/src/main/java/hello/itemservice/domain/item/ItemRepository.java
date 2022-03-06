package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 스프링 컨테이너 안에서 쓰면 어차피 싱글톤으로 유지되어서
    // static 필요 없지만, 따로 new해서 쓰면 다 따로 인스턴스가 되니까.

    // + 동시성 문제로 ConcurrentHashMap, 또 sequence도 atomic으로 써야 함.
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        // 그냥 return store.values()해도 되지만
        // ArrayList로 감싸서 반환하면
        // 반환된 값에 add, delete해도 원본이 수정될 위험 x. + 타입 바꿔야 하는 수고 덜기
        return new ArrayList<>(store.values());
    }

    // 사실 updateParam의 id는 사용되지 않기 때문에
    // updateParamDTO라는 객체를 또 따로 만들어서 해주는 게 바람직하다.
    // 심지어 updateParam.setId도 할 수 있으니까. 그래서 혼란이 올 수 있는데,
    // 예제라서 단순하게 짠 것
    public void update(Long itemId, Item updateParam){
        Item item = findById(itemId);
        item.setItemName(updateParam.getItemName());
        item.setPrice(updateParam.getPrice());
        item.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }

}
