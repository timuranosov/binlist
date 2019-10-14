package binlist.integration.service.card;

import binlist.integration.model.Card;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CardService {

    Page<Card> getCards();

    List<Card> getCardByBinId(long id);

    void saveCard(Card card);
}
