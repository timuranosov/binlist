package binlist.integration.service.cardnumber;

import binlist.integration.model.Bank;
import binlist.integration.model.CardNumber;
import binlist.integration.repository.BankRepository;
import binlist.integration.repository.CardNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardNumberServiceImpl implements CardNumberService {

    @Autowired
    private CardNumberRepository cardNumberRepository;

    @Override
    public void saveCardNumber(CardNumber cardNumber) {
        cardNumberRepository.save(cardNumber);
    }
}
