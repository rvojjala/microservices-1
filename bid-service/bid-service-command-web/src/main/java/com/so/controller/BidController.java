package com.so.controller;

import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.so.dto.BidDto;
import com.so.service.BidService;

/**
 * Created by sergiu.oltean on 5/8/2017.
 */
@RestController
public class BidController {

	@Autowired
	private BidService bidService;

	@RequestMapping(value = "/bids", method = RequestMethod.POST)
	public CompletableFuture<ResponseEntity> createOrder(@RequestBody BidDto bid) {
		return bidService.createBid(bid.getItemCode(), bid.getAmount()).thenApply(b -> new ResponseEntity(b.getEntityId(), HttpStatus.OK));
	}
}
