package binlist.integration.test;

import binlist.integration.Application;
import binlist.integration.model.Card;
import binlist.integration.repository.CardRepository;
import binlist.integration.service.card.CardService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DatabaseInteractionTest {
    private static final long TEST_BIN = 111111;
    private static final long NUM_CARDS = 50;

    @Resource
    private CardRepository cardRepository;
    @Autowired
    private CardService cardService;

    @AfterEach
    public void tearDown() {
        for (long i = 0; i < NUM_CARDS; i++) {
            Card card = cardRepository.getOne(i + 1);
            cardRepository.delete(card);
        }
        Card card = cardRepository.getOne(TEST_BIN);
        cardRepository.delete(card);
    }

    @Test
    public void testSaveCard() {
        Card card = new Card();
        card.setBinId(TEST_BIN);
        cardRepository.save(card);
        Card secondCard = cardRepository.getOne(TEST_BIN);
        assertNotNull(card);
        assertEquals(card.getBinId(), secondCard.getBinId());
    }

    @Test
    public void findAllCards() {
        Card card = new Card();
        card.setBinId(TEST_BIN);
        cardRepository.save(card);
        assertNotNull(cardRepository.findAll());
    }

    @Test
    public void findTenTopCards() {
        for (long i = 0; i < NUM_CARDS; i++) {
            Card card = new Card();
            card.setBinId(i + 1);
            cardRepository.save(card);
        }
        assertEquals(cardService.getCards().getContent().size(), 10);
    }
}
