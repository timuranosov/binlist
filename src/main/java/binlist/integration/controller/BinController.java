package binlist.integration.controller;

import binlist.integration.model.Bank;
import binlist.integration.model.Card;
import binlist.integration.model.CardNumber;
import binlist.integration.model.Country;
import binlist.integration.service.bank.BankService;
import binlist.integration.service.card.CardService;
import binlist.integration.service.cardnumber.CardNumberService;
import binlist.integration.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Controller
public class BinController {

    @Autowired
    private CardService cardService;
    @Autowired
    private BankService bankService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CardNumberService cardNumberService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCards(ModelMap model) {
        List<Card> cards = cardService.getCards().getContent();
        model.put("cards", cards);
        return "list-cards";
    }

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public String searchCard(@RequestParam("bin") long bin, ModelMap model) {
        List<Card> cards = cardService.getCardByBinId(bin);
        if (cards.isEmpty()) {
            RestTemplate restTemplate = new RestTemplate();
            Card card = restTemplate.getForObject("https://lookup.binlist.net/" + bin, Card.class);

            Objects.requireNonNull(card).setBinId(bin);
            cards.add(card);

            CardNumber cardNumber = Objects.requireNonNull(card.getCardNumber());
            cardNumber.setBinId(bin);
            cardNumberService.saveCardNumber(cardNumber);

            Bank bank = Objects.requireNonNull(card.getBank());
            bank.setBinId(bin);
            bankService.saveBank(bank);

            Country country = Objects.requireNonNull(card.getCountry());
            country.setBinId(bin);
            countryService.saveCountry(country);
            cardService.saveCard(card);
        }
        model.put("cards", cards);
        return "list-cards";
    }
}
