package org.knowm.xchange.loyalbit;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.loyalbit.service.polling.LoyalbitAccountService;
import org.knowm.xchange.loyalbit.service.polling.LoyalbitMarketDataService;
import org.knowm.xchange.loyalbit.service.polling.LoyalbitTradeService;
import org.knowm.xchange.utils.nonce.CurrentTimeNonceFactory;

import si.mazi.rescu.SynchronizedValueFactory;

/**
 * @author Matija Mazi
 */
public class LoyalbitExchange extends BaseExchange implements Exchange {

  private SynchronizedValueFactory<Long> nonceFactory = new CurrentTimeNonceFactory();

  @Override
  protected void initServices() {
    this.pollingMarketDataService = new LoyalbitMarketDataService(this);
    this.pollingTradeService = new LoyalbitTradeService(this);
    this.pollingAccountService = new LoyalbitAccountService(this);
  }

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {
    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://www.loyalbit.com");
    exchangeSpecification.setHost("www.loyalbit.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("Loyalbit");
    return exchangeSpecification;
  }

  @Override
  public SynchronizedValueFactory<Long> getNonceFactory() {
    return nonceFactory;
  }
}
