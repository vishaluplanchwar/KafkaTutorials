package com.vishaluplanch.kafka.stateful.ops.count.rest;

import com.vishaluplanch.kafka.stateful.ops.count.StockCountStateStoreUtil;
import org.apache.kafka.streams.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stock-count-rest/v1/")
public class StockCountRestController {

    @Autowired
    private StockCountStateStoreUtil stockCountStateStoreUtil;

    @GetMapping(value = "/countByStockName/{stockName}")
    public String getCountByStockName(@PathVariable String stockName) {
        return stockName.concat("-").concat(stockCountStateStoreUtil.getCountByStockName(stockName).toString());
    }

    @GetMapping(value = "/allCounts")
    public List<KeyValue<String, Long>> allCounts() {
      return stockCountStateStoreUtil.getAllCountByStock();
    }

}
