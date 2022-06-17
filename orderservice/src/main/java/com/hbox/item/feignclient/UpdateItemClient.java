package com.hbox.item.feignclient;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.hbox.model.ItemsDetail;

@FeignClient(value = "HUNGERBOX-SERVICE", url = "http://localhost:8083/hungerbox/dish")
public interface UpdateItemClient {

	@PutMapping("/updateItems")
	public String updateItemDetails(@RequestBody ItemsDetail items);
	
	@GetMapping("/{itemId}")
	public List<ItemsDetail> getItemDetails(@PathVariable int itemId);
}
