package com.nnk.springboot;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.repositories.BidRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidTests {

	@Autowired
	private BidRepository bidListRepository;

	@Test
	public void bidListTest() {
		Bid bid = new Bid("Account Test", "Type Test", 10d);

		// Save
		bid = bidListRepository.save(bid);
		Assert.assertNotNull(bid.getId());
		Assert.assertEquals(bid.getBidQuantity(), 10d, 10d);

		// Update
		bid.setBidQuantity(20d);
		bid = bidListRepository.save(bid);
		Assert.assertEquals(bid.getBidQuantity(), 20d, 20d);

		// Find
		List<Bid> listResult = bidListRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = bid.getId();
		bidListRepository.delete(bid);
		Optional<Bid> bidList = bidListRepository.findById(id);
		Assert.assertFalse(bidList.isPresent());
	}
}
