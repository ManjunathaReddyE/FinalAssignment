package com.hbox.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hbox.model.Items;
import java.lang.String;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Items, Integer> {
	
	//List<Items> findByItemId(Integer itemId);
	
	List<Items> findByItemName(String itemName);
	
	List<Items> findByItemType(String itemType);
	

}
