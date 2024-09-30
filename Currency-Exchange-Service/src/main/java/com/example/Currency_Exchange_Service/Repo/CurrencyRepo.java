package com.example.Currency_Exchange_Service.Repo;

import com.example.Currency_Exchange_Service.Model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency,Integer> {

   public Currency findByFromAndTo(String FromCurrency,String ToCurrency);
}
