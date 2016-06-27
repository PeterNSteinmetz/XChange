package org.knowm.xchange.lakebtc.service.polling;

import java.io.IOException;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.lakebtc.dto.marketdata.LakeBTCOrderBook;
import org.knowm.xchange.lakebtc.dto.marketdata.LakeBTCTickers;

/**
 * @author kpysniak
 */
public class LakeBTCMarketDataServiceRaw extends LakeBTCBasePollingService {

  /**
   * @param exchange
   */
  protected LakeBTCMarketDataServiceRaw(Exchange exchange) {

    super(exchange);

  }

  public LakeBTCTickers getLakeBTCTickers() throws IOException {

    return lakeBTC.getLakeBTCTickers();
  }

  public LakeBTCOrderBook getLakeBTCOrderBookUSD() throws IOException {

    return lakeBTC.getLakeBTCOrderBookUSD();
  }

  public LakeBTCOrderBook getLakeBTCOrderBookCNY() throws IOException {

    return lakeBTC.getLakeBTCOrderBookCNY();
  }
}
