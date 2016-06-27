package org.knowm.xchange.therock.service.polling;

import java.io.IOException;
import java.util.Date;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.service.polling.marketdata.PollingMarketDataService;
import org.knowm.xchange.therock.TheRock;
import org.knowm.xchange.therock.TheRockAdapters;
import org.knowm.xchange.therock.dto.marketdata.TheRockOrderBook;
import org.knowm.xchange.therock.dto.marketdata.TheRockTicker;

/**
 * @author Matija Mazi
 */
public class TheRockMarketDataService extends TheRockMarketDataServiceRaw implements PollingMarketDataService {

  public TheRockMarketDataService(Exchange exchange) {
    super(exchange);
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {
    TheRockTicker t = getTheRockTicker(new TheRock.Pair(currencyPair));
    return new Ticker.Builder().currencyPair(currencyPair).last(t.getLast()).bid(t.getBid()).ask(t.getAsk()).high(t.getHigh()).low(t.getLow())
        .volume(t.getVolume()).timestamp(new Date()).build();
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws IOException {
    final TheRockOrderBook theRockOrderBook = getTheRockOrderBook(new TheRock.Pair(currencyPair));
    return TheRockAdapters.adaptOrderBook(theRockOrderBook);
  }

  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws IOException {
    throw new NotYetImplementedForExchangeException();
  }
}
